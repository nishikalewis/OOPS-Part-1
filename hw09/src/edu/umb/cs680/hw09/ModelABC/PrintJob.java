package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJob implements Command {
    Command job;
    public PrintJob(){
        this.job=job;
    }
    public static void execute(){
        Printer.print();
    }
}
