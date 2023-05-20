package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ReverseComparatorTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void check_subDirectories()
    {
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(new ReverseComparator());
        assertEquals("test",home.get(0).getName());
    }
    @Test
    public void check_getFiles(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(new ReverseComparator());
        LinkedList<File> files_list=home.get(1).getFiles(new ReverseComparator());
        String[] expected = {"b","a"};
        String a[]=new String[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getName();
        }
        assertArrayEquals(expected,a);
    }

}