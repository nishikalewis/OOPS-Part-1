package edu.umb.cs680.hw09.PrintingFramework;



import edu.umb.cs680.hw09.LoginModule.*;


public abstract class PrintJobExecutor {
    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) {
        try {
            doAuthentication(pwd, ctx);
            doAccessControl();


        } catch (Exception e) {
            doErrorHandling();
            System.out.println("can't login");
        }
        doPrint(ctx);
    }

    public void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
    }

    public void doPrint(SecurityContext ctx) {
    }

    public void doAccessControl() {
    }

    public void doErrorHandling() {
    }
}


