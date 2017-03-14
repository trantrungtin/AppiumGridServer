/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logigear.appium.grid.runner;

/**
 *
 * @author tin.tran
 */
public class RunnerFactory {
    public ICommandRunner get() {
        if (mRunner == null) {
            if (isWindow()) {
                mRunner = new CMDRunner();
            }
            else {
                mRunner = new TerminalRunner();
            }
        }
        return mRunner;
    }
    
    private boolean isWindow() {
        return (OS.indexOf("win") >= 0);
    }
    
    private boolean isMAC() {
        return (OS.indexOf("mac") >= 0);
    }
    
    private static String OS = System.getProperty("os.name").toLowerCase();
    private ICommandRunner mRunner = null;
}
