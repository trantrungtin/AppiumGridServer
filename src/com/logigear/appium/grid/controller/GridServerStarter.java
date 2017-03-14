/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logigear.appium.grid.controller;

import com.logigear.appium.grid.runner.ICommandRunner;
import com.logigear.appium.grid.runner.RunnerFactory;
import com.logigear.enviroment.Enviroment;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author tin.tran
 */
public class GridServerStarter {
    
    private ICommandRunner mRunner = null;
    
    public GridServerStarter() {
        mRunner = new RunnerFactory().get();
    }
    
    public void run() {
        String gridBatFile = mRunner.generateRunableCommandFile(getCommand(), "gridServer");
        mRunner.run(gridBatFile);
    }
    
    private String getCommand() {
        String currentPath = Paths.get("").toAbsolutePath().toString();
        String command = mRunner.getTitle("Appium Grid Server") + "\n";
        command += mRunner.getCDCommand() + currentPath + "\n";
        String gridHubJson = currentPath + File.separator +  "grid_hub.json";
        if (Enviroment.isMAC()) {
            command += "java -cp *:. org.openqa.grid.selenium.GridLauncherV3 -role hub";
        }
        else {
            command += "java -cp *;. org.openqa.grid.selenium.GridLauncherV3 -role hub";
        }
        command += " -hubConfig " + gridHubJson;
        return command;
    }
}
