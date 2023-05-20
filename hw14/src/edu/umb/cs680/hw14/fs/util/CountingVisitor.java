package edu.umb.cs680.hw14.fs.util;

import edu.umb.cs680.hw14.fs.*;


public class CountingVisitor implements FSVisitor {
    int fNum=0,dNum=0,lNum=0;
    @Override
    public void visit(Link link) {
        lNum++;

    }

    @Override
    public void visit(Directory dir) {
        dNum++;

    }

    @Override
    public void visit(File file) {
        fNum++;

    }
    public int getLNum(){
        return lNum;
    }
    public int getDNum(){
        return dNum;
    }
    public int getFNum(){
        return fNum;
    }

}

