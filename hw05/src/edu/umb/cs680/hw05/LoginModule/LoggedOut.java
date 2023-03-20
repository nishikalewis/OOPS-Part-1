package edu.umb.cs680.hw05.LoginModule;

public class LoggedOut implements State{
    static SecurityContext ctx;
    private static LoggedOut instance=null;
    public static LoggedOut getInstance(SecurityContext ctx){
        if(instance==null)
        {
            instance=new LoggedOut(ctx);
        }
        return instance;
    }

    public LoggedOut(SecurityContext ctx){
        this.ctx = ctx;
    };

    public void login(EncryptedString pwd){
        if (Authenticator.authenticate(this.ctx , pwd)){
            this.ctx.changeState(new LoggedIn(this.ctx));
        }
        else{
            System.out.println("Authentication has failed");
        }
    }

    public void logout(){}

}
