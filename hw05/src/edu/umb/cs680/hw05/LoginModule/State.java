package edu.umb.cs680.hw05.LoginModule;

public interface State {
    public  void login(EncryptedString pwd);
    public void logout();

}
