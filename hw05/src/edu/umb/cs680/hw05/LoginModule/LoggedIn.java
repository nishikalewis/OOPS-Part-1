package edu.umb.cs680.hw05.LoginModule;

public class LoggedIn implements State{
    static SecurityContext ctx;
    private static LoggedIn instance=null;
    public static LoggedIn getInstance(SecurityContext ctx){
        if(instance==null)
        {
            instance=new LoggedIn(ctx);
        }
        return instance;
    }

    @Override
    public void login(EncryptedString pwd) {
        if(!this.ctx.isActive()){
            this.ctx.changeState(LoggedOut.getInstance(ctx));
            this.ctx.login(pwd);
        }
    }
    @Override
    public void logout() {
        this.ctx.changeState(LoggedOut.getInstance(ctx));

    }
    public LoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }
}
