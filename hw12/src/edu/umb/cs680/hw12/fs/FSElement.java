package edu.umb.cs680.hw12.fs;


import java.time.LocalDateTime;

public abstract class FSElement {
    protected   Directory parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    public FSElement(Directory parent,String name,int size,LocalDateTime creationTime){
        this.parent=parent;
        this.name=name;
        this.size=size;
        this.creationTime=creationTime;
        if(this.parent!=null){
            parent.appendChild(this);
        }

    }
    public Directory getParent(){
        return this.parent;
    }
    public int getSize(){
        return this.size;
    }
    public String getName(){
        return this.name;
    }
    public LocalDateTime getCreationTime(){
        return this.creationTime;
    }
    public abstract boolean isDirectory();
    public abstract boolean isLink();
    public abstract boolean isFile();



    public static void main(String args[]){
        System.out.println("");
    }

    protected void setParent(Directory parent) {
        this.parent=parent;
    }

    public abstract void accept(FSVisitor v);



}

