package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.Directory;
import edu.umb.cs680.hw08.fs.FSVisitor;
import edu.umb.cs680.hw08.fs.File;
import edu.umb.cs680.hw08.fs.Link;
//import jdk.internal.icu.text.UnicodeSet;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {
    private LinkedList<File> foundFiles;
    private String fileName;

    public FileSearchVisitor(String s) {
        this.fileName=s;
    }

    @Override
    public void visit(Link link) {
        return;

    }

    @Override
    public void visit(Directory dir) {
        return;

    }

    @Override
    public void visit(File file) {
        foundFiles = new LinkedList<>();
        if (file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }
    public LinkedList<File> getFoundFiles(){
        return foundFiles;
    }
}
