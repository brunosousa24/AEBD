
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
public class fillROLES implements Runnable {
    Connection sys, work;

    public fillROLES(Connection sys, Connection work) {
        this.sys = sys;
        this.work = work;
    }

    @Override
    public void run() {
        System.out.println("ROLES :: filling");
    }
    
}