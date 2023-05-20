package edu.umb.cs680.hw12.fs;



import java.time.LocalDateTime;

public class Link extends FSElement{
    protected FSElement target;
    public Link(Directory parent, String name, int size, LocalDateTime creationTime,FSElement target) {
        super(parent, name, size, creationTime);
        this.target=target;
    }

    public FSElement getTarget() {
        return this.target;
    }
    public boolean isLink(){
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}

