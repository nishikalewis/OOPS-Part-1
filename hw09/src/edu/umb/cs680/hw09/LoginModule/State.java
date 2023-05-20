package edu.umb.cs680.hw09.LoginModule;

public interface State {
    public  void login(EncryptedString pwd);
    public void logout();

}
