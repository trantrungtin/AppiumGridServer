/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logigear.appium.grid;

import java.util.Map;
import java.util.logging.Logger;
import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;
import org.openqa.grid.web.servlet.handler.RequestHandler;

/**
 *
 * @author tin.tran
 */
public class MobileMatcher extends DefaultCapabilityMatcher {
	
	private static final Logger log = Logger.getLogger(RequestHandler.class.getName());
	
	@Override
	public boolean matches(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability) {
		
		boolean matched = true;
		
		String keywords[] = {"browserName", "platformName" };
		for (String key : keywords) {			
			if (!requestedCapability.containsKey(key)) {
				matched = false;
				break;
			}			
			String reqValue = requestedCapability.get(key).toString();
			String capValue = nodeCapability.get(key).toString();
			
			
			if (!reqValue.equalsIgnoreCase(capValue)) {
				matched = false;
				break;
			}			
		}
		
		// check device name by containing
		String reqDeviceName = requestedCapability.get("deviceName").toString();
		String capDeviceName = nodeCapability.get("deviceName").toString();
		boolean matchedDeviceName = reqDeviceName.length() > 3 
									&& capDeviceName.length() > 3
									&& capDeviceName.startsWith(reqDeviceName);
		if (!matchedDeviceName) {
			matched = false;
		}
		
		log.info("nodeCapability: " + nodeCapability.toString() 
				+ ",requestedCapability:" + requestedCapability.toString() + 
				"," + (matched ? "matched" : "not matched"));
		
		return matched;
	}
}
