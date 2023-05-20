package edu.umb.cs680.hw12.fs.util;


import edu.umb.cs680.hw12.fs.*;
import edu.umb.cs680.hw12.fs.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

class VisitorTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void check_CountingVisitor(){
        Directory rootDir=fs.getRootDir().getFirst();
        CountingVisitor visitor = new CountingVisitor();
        rootDir.accept( visitor );
        int d= visitor.getDNum();
        int f= visitor.getFNum();
        int l= visitor.getLNum();
        assertEquals(5,d);
        assertEquals(5,f);
        assertEquals(1,l);
    }
    @Test
    public void check_FileCrawlingVisitor(){
        Directory rootDir=fs.getRootDir().getFirst();
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        rootDir.accept( visitor );
        LinkedList<File> files=visitor.getFiles();
        assertEquals("x",files.get(0).getName());
    }
    @Test
    public void check_FileSearchVisitor(){
        Directory rootDir=fs.getRootDir().getFirst();
        FileSearchVisitor visitor = new FileSearchVisitor("example.txt");
        rootDir.accept( visitor );
        //no such file exist;
        System.out.println(visitor.getFoundFiles().size());
        FileSearchVisitor v= new FileSearchVisitor("x");
        rootDir.accept( v);
        assertEquals(1,v.getFoundFiles().size());
    }
}