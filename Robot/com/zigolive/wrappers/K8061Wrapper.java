package com.zigolive.wrappers;

/**
 * Wrapper class for the K8061.dll library
 * 
 * @author James McTaggart
 */
public class K8061Wrapper {

	static{
		System.loadLibrary("K8061");
	}
	
	private static K8061Wrapper _instance;
	
	private K8061Wrapper(){
		
	}
	
	public static K8061Wrapper getInstance(){
		if(_instance==null)_instance = new K8061Wrapper();
		return _instance;
	}
	
	public native long OpenDevice();
	//Opens the communication link to the K8061 device
	
	public native void CloseDevices();
	//Closes the link to all open K8061 devices
	
	public native boolean PowerGood(long cardAddress);
	//Checks that IC6 is working properly
	
	public native boolean Connected(long cardAddress);
	//Checks that USB connection to the card is valid
	
	public native void ReadVersion(long cardAddress, long[] buffer); 
	//Reads the software version of IC3 and IC6 and places in buffer
	
	
	//Analogue to Digital converter procedures
	
	public native long ReadAnalogChannel(long cardAddress, long channelNo);
	//Reads the status of one analogue input-channel
	
	public native void ReadAllAnalog(long cardAddress, long[] buffer);
	//Reads the status of all analogue inputchannels
	
	
	//Digital to Analogue conversion procedures
	
	public native void OutputAnalogChannel(long cardAddress, long channel, long data);
	//Sets the analogue output channel according to the	data
	
	public native void OutputAllAnalog(long cardAddress, long[] buffer);
	//Sets all analogue output channels according to the data
	
	public native void ClearAnalogChannel(long cardAddress, long channel);
	//Sets the analogue output channel to minimum
	
	public native void ClearAllAnalog(long cardAddress);
	//Sets all analogue output channels to minimum
	
	public native void SetAnalogChannel(long cardAddress, long channel);
	//Sets the analogue output channel to maximum
	
	public native void SetAllAnalog(long cardAddress);
	//Sets all analogue output channels to maximum
	
	
	//PWM Output procedure
	
	public native void OutputPWM(long cardAddress, long data);
	//Sets the PWM output according to the data
	
	
	//Digital Output procedures
	
	public native void OutputAllDigital(long cardAddress, long data);
	//Sets the digital outputs according to the data
	
	public native void ClearDigitalChannel(long cardAddress, long channel);
	//Clears the output channel
	
	public native void ClearAllDigital(long CardAddress);
	//Clears all output channels
	
	public native void SetDigitalChannel(long cardAddress, long channel);
	//Sets the output channel
	
	public native void SetAllDigital(long cardAddress);
	//Sets all output channels
	
	
	//Digital Input procedures and functions
	
	public native boolean ReadDigitalChannel(long cardAddress, long channel);
	//Reads the status of the input channel
	
	public native long ReadAllDigital(long cardAddress, long buffer);
	//Reads the status of all the input channels
	
	public static void main(String[] args) {
		K8061Wrapper k = K8061Wrapper.getInstance();
		System.out.println(k.OpenDevice());
	}
}
