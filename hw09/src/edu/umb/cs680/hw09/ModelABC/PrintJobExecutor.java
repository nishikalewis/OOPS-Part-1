package edu.umb.cs680.hw09.ModelABC;



import edu.umb.cs680.hw09.LoginModule.*;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {

    @Override
    public void doPrint(SecurityContext ctx) {
        if(ctx.getState()instanceof LoggedIn){
            PrintJob.execute();
            System.out.println(" authentication done");
        }
        //super.doPrint(ctx);
    }

    @Override
    public void doAccessControl() {
        //super.doAccessControl();
    }

    @Override
    public void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        //super.doAuthentication(pwd, ctx);
        ctx.login(pwd);
    }

    @Override
    public void doErrorHandling() {
        //super.doErrorHandling();
    }

    public static void main(String[] args){

        System.out.println("printJobExecutor");
    }
}

