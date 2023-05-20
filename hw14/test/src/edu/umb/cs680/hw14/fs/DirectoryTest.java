package edu.umb.cs680.hw14.fs;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }
    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {
                d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime())};
        return dirInfo;
    }
    @Test
    public void verifyDirectoryEqualityRoot(){
        String[] expected = {"prjRoot","0",String.valueOf(time)};
        Directory root=fs.getRootDir().getFirst();
        Directory actual = root;
        assertArrayEquals(expected,
                dirToStringArray(actual) );
    }

    //verifying the public methods
    @Test
    public void check_getChildrenAC(){
        Directory root=fs.getRootDir().getFirst();
        Directory home= (Directory) root.getChildren().getFirst();
        String[] expected = {"lib","0",String.valueOf(time)};
        String actual[]=dirToStringArray(home);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void check_countChildren(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories();
        int count= home.getLast().countChildren();
        assertEquals(1,count);
    }
    @Test
    public void check_subDirectories()
    {
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories();
        LinkedList<Directory> child=home.getLast().getSubDirectories();
        assertEquals("src",child.get(0).getName());
    }

    @Test
    public void check_getFiles(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories();
        LinkedList<File> files_list=home.get(1).getFiles();
        String[] expected = {"a","b"};
        String a[]=new String[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getName();
        }
        assertArrayEquals(expected,a);
    }
    @Test
    public void check_getTotalSize(){
        Directory root=fs.getRootDir().getFirst();
        int total= root.getTotalSize();
        int exp=60;
        assertEquals(exp,total);
    }
    @Test
    public void check_isDirectory(){
        Directory root=fs.getRootDir().getFirst();
        assertFalse(!root.isDirectory());
    }

    @Test
    public void check_sc(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories((FSElement o1, FSElement o2)->
                (int)(o1.getSize()- o2.getSize()));
        LinkedList<File> files_list=home.get(1).getFiles((FSElement c1, FSElement c2)->
        (int)(c1.getSize()- c2.getSize()));
        int[] expected = {10,15};
        int a[]=new int[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getSize();
        }
        assertArrayEquals(expected,a);
    }

    @Test
    public void check_getChildren_AC(){
        Directory root=fs.getRootDir().getFirst();
        Directory home= (Directory) root.getChildren(Comparator.comparing( FSElement::getName )).getFirst();
        String[] expected = {"lib","0",String.valueOf(time)};
        assertEquals(expected[0], home.getName());
    }
    @Test
    public void check_subDirectories_AC()
    {
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(Comparator.comparing( FSElement::getName ));
        LinkedList<Directory> child=home.getLast().getSubDirectories(Comparator.comparing( FSElement::getName ));
        assertEquals("src",child.get(0).getName());
    }
    @Test
    public void check_getFiles_AC(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(Comparator.comparing( FSElement::getName ));
        LinkedList<File> files_list=home.get(1).getFiles(Comparator.comparing( FSElement::getName ));
        String[] expected = {"a","b"};
        String a[]=new String[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getName();
        }
        assertArrayEquals(expected,a);
    }
    @Test
    public void check_subDirectories_RC()
    {
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(Comparator.comparing(FSElement::getName,
                Comparator.reverseOrder()));
        assertEquals("test",home.get(0).getName());
    }
    @Test
    public void check_getFiles_RC(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(Comparator.comparing(FSElement::getName,
                Comparator.reverseOrder()));
        LinkedList<File> files_list=home.get(1).getFiles(Comparator.comparing(FSElement::getName,
                Comparator.reverseOrder()));
        String[] expected = {"b","a"};
        String a[]=new String[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getName();
        }
        assertArrayEquals(expected,a);
    }
}