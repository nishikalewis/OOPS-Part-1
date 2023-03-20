package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.LoginModule.Authenticator;
import edu.umb.cs680.hw05.LoginModule.EncryptedString;
import edu.umb.cs680.hw05.LoginModule.LoggedIn;
import edu.umb.cs680.hw05.LoginModule.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {

    @Override
    public void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        try{
            ctx.login(pwd);
            if(Authenticator.authenticate(ctx,pwd)){
                ctx.changeState(new LoggedIn(ctx));
            }
            else{
                throw new Exception("invalid -login");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void doAccessControl() {
        //super.doAccessControl();
    }

    @Override
    public void doErrorHandling() {
        //super.doErrorHandling();
    }

    @Override
    public void doPrint(SecurityContext ctx) {
        if(ctx.getState() instanceof LoggedIn){
            System.out.println("authentication successful");
        }
        else{
            System.out.println("authentication failed");
        }
    }
}
