package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;

class FileSystemTest {

    private static  FileSystem fs;
    LocalDateTime time=TestFixtureInitializer.time;
    @BeforeAll
    public static void setUP(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void check_nullInstance(){
        assertNotNull(fs);
    }

    @Test
    public void check_getRootDir(){
        Directory root=fs.getRootDir().getFirst();
        assertEquals("prjRoot",root.getName());
    }


}