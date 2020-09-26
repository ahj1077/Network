package com.vitec.agent;

public class SnmpClient{

    public static void main(String[] args) throws java.io.IOException {
    	
    	while(true) {
    		try {
    			System.out.println(SnmpApi.getSystemDateAndTime());
    			System.out.println(SnmpApi.getSystemSerialNum());    
    			System.out.println(SnmpApi.getDeviceState());    			
    			System.out.println(SnmpApi.getDeviceTemper());    			
    			System.out.println(SnmpApi.getDeviceTemperDate());
    			System.out.println(SnmpApi.getDeviceLastTemperCause());    			
    			Thread.sleep(1000);

    			
    			
    			
    		} catch (Exception ex) {
    			System.out.println ("ex *** : " + ex);
    			ex.printStackTrace ();
    		}
    	}
    }
}