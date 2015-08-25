package com.zigolive.robot;


public class JavaK8061
{
    static 
    {
     	System.loadLibrary( "JavaK8061" );
    }
    // Must be kept, as it is read by the Native functions
	private Integer cardID;
	public JavaK8061() throws Exception {
		int cid = this.openDevice();
		switch(cid){
			case 0:case 1:case 2:case 3:case 4:case 5:case 6:case 7://Everything is OK :)
				cardID = new Integer(cid);
				break;
			case -1:
				throw new Exception("All cards have already been found");
			case -2:
				throw new Exception("No card found");
		}
	}
	
	public native int openDevice();
	public native void closeDevices();
	public native void setAllDigital();
	public native void setDigitalChannel(int channel);
	public native void setAllAnalog();
	public native void setAnalogChannel(int channel);
	public native void clearAllDigital();
	public native void clearDigitalChannel(int channel);
	public native void clearAllAnalog();
	public native void clearAnalogChannel(int channel);
	public native void outputAllAnalog(long[] data);
	public native void outputAllDigital(int data);
	public native void outputAllDigitalA(boolean[] data);
	public native void outputAnalogChannel(int channel, int data);
	public native void outputPWM(int data);
	public native long[] readVersion();
	public native long[] readAllAnalog();
	public native int readAllDigital();
	public native boolean[] readAllDigitalA();
	public native int readDigitalChannel(int channel);
}

