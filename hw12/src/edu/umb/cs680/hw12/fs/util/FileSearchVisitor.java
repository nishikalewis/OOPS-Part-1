package edu.umb.cs680.hw12.fs.util;

import edu.umb.cs680.hw12.fs.*;


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

