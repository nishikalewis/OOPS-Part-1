package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void check_getChildren(){
        Directory root=fs.getRootDir().getFirst();
        Directory home= (Directory) root.getChildren(new AlphabeticalComparator()).getFirst();
        String[] expected = {"lib","0",String.valueOf(time)};
        assertEquals(expected[0], home.getName());
    }
    @Test
    public void check_subDirectories()
    {
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(new AlphabeticalComparator());
        LinkedList<Directory> child=home.getLast().getSubDirectories(new AlphabeticalComparator());
        assertEquals("src",child.get(0).getName());
    }
    @Test
    public void check_getFiles(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(new AlphabeticalComparator());
        LinkedList<File> files_list=home.get(1).getFiles(new AlphabeticalComparator());
        String[] expected = {"a","b"};
        String a[]=new String[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getName();
        }
        assertArrayEquals(expected,a);
    }

}