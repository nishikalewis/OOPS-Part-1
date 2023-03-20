package edu.umb.cs680.hw05;

import edu.umb.cs680.hw05.LoginModule.EncryptedString;
import edu.umb.cs680.hw05.LoginModule.SecurityContext;
import edu.umb.cs680.hw05.LoginModule.User;
import edu.umb.cs680.hw05.ModelABC.PrintJobExecutor;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {
    @Test
    void check_ABC (){
        PrintJobExecutor a=new PrintJobExecutor();
        PrintJob job=new PrintJob();
        EncryptedString pwd=new EncryptedString("pwd");
        SecurityContext ctx=new SecurityContext(new User());
        a.execute(job,pwd,ctx);

    }
    @Test
    void check_XYZ (){
        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor x=new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        PrintJob job1=new PrintJob();
        //Encrypted  String
        x.execute(job1,null,null);
    }

}