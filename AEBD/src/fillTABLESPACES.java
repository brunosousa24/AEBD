
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunosousa
 */
public class fillTABLESPACES implements Runnable {
    Connection sys, work;

    public fillTABLESPACES(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("TABLESPACES :: filling");
    }
    
}
