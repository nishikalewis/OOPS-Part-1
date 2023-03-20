package edu.umb.cs680.hw05.PrintingFramework;

import edu.umb.cs680.hw05.LoginModule.EncryptedString;
import edu.umb.cs680.hw05.LoginModule.SecurityContext;

public abstract class PrintJobExecutor {
    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) {
        try {
            doAuthentication(pwd, ctx);
            doAccessControl();
            doPrint(ctx);
            doErrorHandling();
        } catch (Exception e) {
            System.out.println("can't login");

        }
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


