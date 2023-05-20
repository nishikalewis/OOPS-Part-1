package edu.umb.cs680.hw12.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    private String[] fileoStringArray(File f){
        String[] Info = {String.valueOf(f.getParent().getName()),
                f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
        return Info;
    }

    @Test
    public void check_file(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<File> files=root.getFiles();
        String expected[]={"prjRoot","x","5",String.valueOf(time)};
        String actual[]=fileoStringArray(files.getFirst());
        assertArrayEquals(expected,actual);
    }

    @Test
    public void check_ifFile(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<Directory> home=root.getSubDirectories();
        LinkedList<File> files_list=home.get(0).getFiles();
        assertFalse(files_list.getFirst().isDirectory());

    }

}