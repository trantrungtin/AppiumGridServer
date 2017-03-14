/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logigear.appium.grid.runner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tin.tran
 */
public class TerminalRunner implements ICommandRunner{
    @Override
    public void run(String path) {
        try {
            Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + path);
        } catch (IOException ex) {
            Logger.getLogger(TerminalRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String generateRunableCommandFile(String command, String fileName) {
        String path = "";
        try {
            File temp = File.createTempFile(fileName, ".command");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
                bw.write(command);
            }
            temp.setExecutable(true);
            path = temp.getAbsolutePath();
        }   catch (IOException ex) {
            Logger.getLogger(TerminalRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return path;
    }

    @Override
    public String getTitle(String title) {
        return "title='" + title + "'\n"
                + "echo -n -e \"\033]0;$title\007\"";
    }

    @Override
    public String getCDCommand() {
        return "cd ";
    }
}
