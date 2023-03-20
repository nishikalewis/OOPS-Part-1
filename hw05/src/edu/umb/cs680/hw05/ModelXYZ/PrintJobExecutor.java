package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw05.LoginModule.EncryptedString;
import edu.umb.cs680.hw05.LoginModule.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {

    @Override
    public void doPrint(SecurityContext ctx) {
        //super.doPrint(ctx);
    }

    @Override
    public void doAccessControl() {
        //super.doAccessControl();
    }

    @Override
    public void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        //super.doAuthentication(pwd, ctx);
    }

    @Override
    public void doErrorHandling() {
        //super.doErrorHandling();
    }

    public static void main(String[] args){
        System.out.println("printJobExecutor");
    }
}
