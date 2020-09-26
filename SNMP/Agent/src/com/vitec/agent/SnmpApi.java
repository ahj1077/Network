package com.vitec.agent;

import java.net.*;

import org.snmp4j.*;
import org.snmp4j.event.*;
import org.snmp4j.mp.*;
import org.snmp4j.smi.*;
import org.snmp4j.transport.*;

public class SnmpApi {
	private static final int Port = 161;
	private static final String IP = "192.168.30.59";
	
    private static OctetStringConverter converter = new OctetStringConverter();
	private static PDU pdu = new PDU();
	private static CommunityTarget target = new CommunityTarget();
    private static UdpAddress targetAddress = new UdpAddress();
	private static OctetString octetString = new OctetString("public");
	
    public static void setPDU(String oid) {
		pdu.clear();
		pdu.add(new VariableBinding(new OID(oid)));
	    pdu.setType(PDU.GET);
	}
    
    public static void setTargetAddress(String IP) throws java.io.IOException {
    	 targetAddress.setInetAddress(InetAddress.getByName(IP));
         targetAddress.setPort(Port);
         target.setAddress(targetAddress);
         target.setCommunity(octetString);
         target.setVersion(SnmpConstants.version2c);
    }
	
	public static String getSystemDateAndTime() throws java.io.IOException {
	   String OID = ".1.3.6.1.4.1.4096.2.2.9000.6.1.0";

	   setPDU(OID);
	   setTargetAddress(IP);
	   
       Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
       
       snmp.listen();
       ResponseEvent response = snmp.send(pdu, target);
       
       String dateAndTime = "-1";
       PDU result = response.getResponse();
       
       if (result == null) {
           System.out.println("Error: There is some problems.");
       } else {
    	   dateAndTime = converter.convertDateAndTime(result.get(0).getVariable().toString());
       }
       
       snmp.close();
       return dateAndTime;
	}
	
	public static String getSystemSerialNum() throws java.io.IOException {
		   String OID = ".1.3.6.1.4.1.4096.2.2.9000.6.2.0";

		   setPDU(OID);
		   setTargetAddress(IP);
		   
	       Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
	       
	       snmp.listen();
	       ResponseEvent response = snmp.send(pdu, target);
	       
	       String serialNum = "-1";
	       PDU result = response.getResponse();
	       
	       if (result == null) {
	           System.out.println("Error: There is some problems.");
	       } else {
	    	   serialNum = result.get(0).getVariable().toString();
	       }
	       
	       snmp.close();
	       return serialNum;

	}
	
	public static String getDeviceState() throws java.io.IOException {
		   String OID = ".1.3.6.1.4.1.4096.2.2.9000.3.1.0";
		   String[] results = new String[]{"Unavaliable","Online","Offline","Secure"};
		   setPDU(OID);
		   setTargetAddress(IP);
		   
	       Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
	       
	       snmp.listen();
	       ResponseEvent response = snmp.send(pdu, target);
	       
	       String state = "-1";
	       PDU result = response.getResponse();
	       
	       if (result == null) {
	           System.out.println("Error: There is some problems.");
	       } else {
	    	   state = results[Integer.valueOf(result.get(0).getVariable().toString()) - 1];
	       }
	       
	       snmp.close();
	       return state;
	}
	
	public static String getDeviceTemper() throws java.io.IOException {
		   String OID = ".1.3.6.1.4.1.4096.2.2.9000.3.2.1.0";
		   String[] results = new String[]{"Unknown","Ok","Temper"};
		   setPDU(OID);
		   setTargetAddress(IP);
		   
	       Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
	       
	       snmp.listen();
	       ResponseEvent response = snmp.send(pdu, target);
	       
	       String state = "-1";
	       PDU result = response.getResponse();
	       
	       if (result == null) {
	           System.out.println("Error: There is some problems.");
	       } else {
	    	   state = results[Integer.valueOf(result.get(0).getVariable().toString()) - 1];
	       }
	       
	       snmp.close();
	       return state;
	}
	public static String getDeviceTemperDate() throws java.io.IOException {
		   String OID = ".1.3.6.1.4.1.4096.2.2.9000.3.2.2.0";
		   setPDU(OID);
		   setTargetAddress(IP);
		   
	       Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
	       
	       snmp.listen();
	       ResponseEvent response = snmp.send(pdu, target);
	       
	       String dateAndTime = "-1";
	       PDU result = response.getResponse();
	       
	       if (result != null) {
	    	   dateAndTime = converter.convertDateAndTime(result.get(0).getVariable().toString());
	       }
	       else {
	           System.out.println("Error: There is some problems.");
	       }
	       
	       snmp.close();
	       return dateAndTime;
	}
	
	public static String getDeviceLastTemperCause() throws java.io.IOException {
		   String OID = ".1.3.6.1.4.1.4096.2.2.9000.3.2.3.0";
		   String[] results = new String[]{"Unavaliable","TempOutOfRange","BatteryLow","EraseButtonPressed",
				   "SecurityProcessorWatchdog", "SecurityProcessorRestart","PowerTooHigh","MotionDetected",
				   "CaseTempered","TSPPModule","General"};
		   setPDU(OID);
		   setTargetAddress(IP);
		   
	       Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
	       
	       snmp.listen();
	       ResponseEvent response = snmp.send(pdu, target);
	       
	       String state = "-1";
	       PDU result = response.getResponse();
	       
	       if (result == null) {
	           System.out.println("Error: There is some problems.");
	       } else {
	    	   state = results[Integer.valueOf(result.get(0).getVariable().toString()) - 1];
	       }
	       
	       snmp.close();
	       return state;
	}
}
