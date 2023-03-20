package edu.umb.cs680.hw04;

public class SecurityContext {
    State state;
    User user;
    boolean firstLogin = true;

    public SecurityContext(User user){
        this.user = user;
        this.state = new LoggedOut(this);
    };

    public void changeState(State newState){
        this.state = newState;
    };

    public void login(EncryptedString pwd){
        this.state.login(pwd);
        if(this.firstLogin) {
            this.firstLogin = false;
        }
    };

    public void logout(){
        this.state.logout();
    };

    public boolean isActive(){
        return this.firstLogin;
    };

    public State getState(){
        return this.state;
    }

    public static void main(String[] args){
        System.out.println("Login module");
    }
}
