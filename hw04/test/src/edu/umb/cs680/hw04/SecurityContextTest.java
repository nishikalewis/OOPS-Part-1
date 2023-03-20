package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {
    SecurityContext ctx=new SecurityContext(new User());
    @Test
    void instance_verification(){

        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    void login_verification(){
        ctx.login(new EncryptedString("pwd"));
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    void users_verification(){
        SecurityContext ctx1=new SecurityContext(new User());
        ctx1.login(new EncryptedString("pwd"));
        SecurityContext ctx2=new SecurityContext(new User());
        ctx2.login(new EncryptedString("pd"));
        assertEquals(ctx1.getState() instanceof LoggedIn,ctx2.getState() instanceof LoggedIn);
    }
    @Test
    void transitions_verification(){
        SecurityContext ct=new SecurityContext(new User());
        assertTrue(ct.isActive());
        assertTrue(ct.getState() instanceof LoggedOut);
        ct.login(new EncryptedString("pwd"));
        assertTrue(ct.getState() instanceof LoggedIn);
        ct.logout();
        assertTrue(ct.getState() instanceof LoggedOut);

    }


}