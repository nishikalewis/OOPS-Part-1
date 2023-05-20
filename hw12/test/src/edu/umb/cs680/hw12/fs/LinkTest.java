package edu.umb.cs680.hw12.fs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void check_LinkMethods(){
        Directory root=fs.getRootDir().getFirst();
        LinkedList<FSElement> child=root.getChildren();
        assertEquals("y",child.getLast().getName());
        assertTrue(child.getLast().isLink());
        Link l= (Link) child.getLast();
        assertEquals("src",l.getTarget().getName());
    }
}