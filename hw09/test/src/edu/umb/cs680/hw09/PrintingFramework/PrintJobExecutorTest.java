package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.LoginModule.EncryptedString;
import edu.umb.cs680.hw09.LoginModule.SecurityContext;
import edu.umb.cs680.hw09.LoginModule.User;
import edu.umb.cs680.hw09.ModelABC.PrintJob;
import edu.umb.cs680.hw09.ModelABC.PrintJobExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {
    @Test
    public void check_PrintJob(){

        PrintJobExecutor pje=new PrintJobExecutor();
        Command j=new PrintJob();
        pje.execute(j,new EncryptedString("pwd"),new SecurityContext(new User()));
        assertNotNull(j);
    }

}