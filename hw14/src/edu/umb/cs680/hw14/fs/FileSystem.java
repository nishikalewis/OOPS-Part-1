package edu.umb.cs680.hw14.fs;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem {
    private static FileSystem fs=null;
    LinkedList<Directory>root=new LinkedList<>();
    private FileSystem(){}
    public static FileSystem getFileSystem(){
        if(fs==null)
            fs=new FileSystem();
        return fs;
    }
    public LinkedList<Directory> getRootDir(){
        return this.root;
    }
    public void appendRoot(Directory root){
        this.root.add(root);
    }
    public static void main(String[] args){
        FileSystem fileSystem=FileSystem.getFileSystem();
        Directory dir=new Directory(null,"root",0, LocalDateTime.now());
        fileSystem.appendRoot(dir);
        System.out.println("file system");
    }
}

