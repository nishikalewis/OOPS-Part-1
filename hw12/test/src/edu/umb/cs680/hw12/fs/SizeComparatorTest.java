package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SizeComparatorTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void check_sc(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories(new SizeComparator());
        LinkedList<File> files_list=home.get(1).getFiles(new SizeComparator());
        int[] expected = {10,15};
        int a[]=new int[2];
        for(int i=0;i<files_list.size();i++){
            a[i]=files_list.get(i).getSize();
        }
        assertArrayEquals(expected,a);
    }

}