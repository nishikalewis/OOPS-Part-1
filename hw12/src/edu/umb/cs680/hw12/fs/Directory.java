package edu.umb.cs680.hw12.fs;



import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement{
    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e:children){
            e.accept(v);
        }
    }

    LinkedList<FSElement>children=new LinkedList<>();
    public LinkedList<FSElement>getChildren(){
        return this.children;
    }
    public LinkedList<FSElement>getChildren(Comparator<FSElement> c){
        children=getChildren();
        Collections.sort(children,c);
        return children;
    }
    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
        Collections.sort(children,new AlphabeticalComparator());
    }

    public int countChildren(){
        int childcount=0;
        for(FSElement f:this.children){
            childcount++;
        }
        return childcount;
    }
    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDirectory=new LinkedList<>();
        for(FSElement child:children){
            if(child.isDirectory()){
                subDirectory.add((Directory) child);
            }
        }
        return subDirectory;
    }
    public LinkedList<Directory>getSubDirectories(Comparator<FSElement>c){
        LinkedList<Directory>subdir=getSubDirectories();
        subdir.sort(c);
        return subdir;
    }
    public LinkedList<File> getFiles(){
        LinkedList<File> file=new LinkedList<>();
        for(FSElement child:children){
            if(child.isFile()){
                file.add((File) child);
            }
        }
        return file;
    }
    public LinkedList<File> getFiles(Comparator<FSElement>c){
        LinkedList<File> file=getFiles();
        file.sort(c);
        return file;
    }
    public int getTotalSize(){
        int ts=0;
        for(int i=0;i<this.children.size();i++){
            if(this.children.get(i)instanceof Directory){
                Directory a=(Directory) this.children.get(i);
                ts=ts+a.getTotalSize();
            }
            else {
                ts=ts+this.children.get(i).getSize();
            }
        }
        return ts;
    }

}


