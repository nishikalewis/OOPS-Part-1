package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {
    SecurityContext ctx=new SecurityContext(new User());
    @Test
    void check_instance(){

        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    void check_login(){
        ctx.login(new EncryptedString("pwd"));
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    void check_users(){
        SecurityContext ctx1=new SecurityContext(new User());
        ctx1.login(new EncryptedString("pwd"));
        SecurityContext ctx2=new SecurityContext(new User());
        ctx2.login(new EncryptedString("pd"));
        assertEquals(ctx1.getState() instanceof LoggedIn,ctx2.getState() instanceof LoggedIn);
    }
    @Test
    void check_transitions(){
        SecurityContext ct=new SecurityContext(new User());
        assertTrue(ct.isActive());
        assertTrue(ct.getState() instanceof LoggedOut);
        ct.login(new EncryptedString("pwd"));
        assertTrue(ct.getState() instanceof LoggedIn);
        ct.logout();
        assertTrue(ct.getState() instanceof LoggedOut);

    }


}