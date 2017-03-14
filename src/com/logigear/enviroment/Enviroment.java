/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logigear.enviroment;

/**
 *
 * @author tin.tran
 */
public class Enviroment {
    public static boolean isWindow() {
        return (OS.indexOf("win") >= 0);
    }
    
    public static boolean isMAC() {
        return (OS.indexOf("mac") >= 0);
    }
    
    private static String OS = System.getProperty("os.name").toLowerCase();
}
