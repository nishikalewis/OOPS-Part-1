package edu.umb.cs680.hw07;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
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
    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"src","0",String.valueOf(time)};
        Directory root=fs.getRootDir().getFirst();
        Directory home=root.getSubDirectories().getFirst();
        String actual[]=dirToStringArray(home);
        assertArrayEquals(expected,actual);
    }
    //verifying the public methods
    @Test
    public void check_getChildren(){
        Directory root=fs.getRootDir().getFirst();
        Directory home= (Directory) root.getChildren().getFirst();
        String[] expected = {"src","0",String.valueOf(time)};
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
        LinkedList<File> files_list=home.get(0).getFiles();
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

}