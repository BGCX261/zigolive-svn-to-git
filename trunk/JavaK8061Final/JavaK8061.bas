'' to compile: fbc -dll -Wl --kill-at JavaK8061.bas

#include "jni.bi"


Declare Function OpenDevice Lib "k8061.dll" Alias "OpenDevice" () As Long
Declare Sub CloseDevices Lib "k8061.dll" Alias "CloseDevices" ()
Declare Function ReadAnalogChannel Lib "k8061.dll" Alias "ReadAnalogChannel" (ByVal CardAddress As Long, ByVal Channel As Long) As Long
Declare Function PowerGood Lib "k8061.dll" Alias "PowerGood" (ByVal CardAddress As Long) As Long
Declare Function Connected Lib "k8061.dll" Alias "Connected" (ByVal CardAddress As Long) As Long
Declare Sub ReadVersion Lib "k8061.dll" Alias "ReadVersion" (ByVal CardAddress As Long, Buffer As Long ptr)
Declare Sub ReadAllAnalog Lib "k8061.dll" Alias "ReadAllAnalog" ( ByVal CardAddress As Long, buffer As Long ptr)
Declare Sub OutputAnalogChannel Lib "k8061.dll" Alias "OutputAnalogChannel" (ByVal CardAddress As Long, ByVal Channel As Long, ByVal Data As Long)
Declare Sub OutputAllAnalog Lib "k8061.dll" Alias "OutputAllAnalog" (ByVal CardAddress As Long, buffer As Long ptr)
Declare Sub ClearAnalogChannel Lib "k8061.dll" Alias "ClearAnalogChannel" ( ByVal CardAddress As Long, ByVal Channel As Long)
Declare Sub SetAllAnalog Lib "k8061.dll" Alias "SetAllAnalog" (ByVal CardAddress As Long)
Declare Sub ClearAllAnalog Lib "k8061.dll" Alias "ClearAllAnalog" (ByVal CardAddress As Long)
Declare Sub SetAnalogChannel Lib "k8061.dll" Alias "SetAnalogChannel" (ByVal CardAddress As Long, ByVal Channel As Long)
Declare Sub OutputAllDigital Lib "k8061.dll" Alias "OutputAllDigital" (ByVal CardAddress As Long, ByVal Data As Long)
Declare Sub ClearDigitalChannel Lib "k8061.dll" Alias "ClearDigitalChannel" (ByVal CardAddress As Long, ByVal Channel As Long)
Declare Sub ClearAllDigital Lib "k8061.dll" Alias "ClearAllDigital" (ByVal CardAddress As Long)
Declare Sub SetDigitalChannel Lib "k8061.dll" Alias "SetDigitalChannel" (ByVal CardAddress As Long, ByVal Channel As Long)
Declare Sub SetAllDigital Lib "k8061.dll" Alias "SetAllDigital" ( ByVal CardAddress As Long)
Declare Function ReadDigitalChannel Lib "k8061.dll" Alias "ReadDigitalChannel" ( ByVal CardAddress As Long, ByVal Channel As Long) As Long
Declare Function ReadAllDigital Lib "k8061.dll" Alias "ReadAllDigital" (ByVal CardAddress As Long) As Long
Declare Sub OutputPWM Lib "k8061.dll" Alias "OutputPWM" (ByVal CardAddress As Long, ByVal Data As Long)



' Get the card ID from the Java class
Function getCardId(env as JNIEnv ptr, obj as jobject) As integer
	Dim cid As integer
	Dim cclass As jclass
	Dim cidfield As jfieldID
	cclass = (*env)->GetObjectClass(env, obj)
	cidfield = (*env)->GetFieldID(env, cclass, "cardID", "Ljava/lang/Integer;")
	Dim i As jobject
	i = (*env)->GetObjectField(env, obj, cidfield)
	Dim ic As jclass
	ic = (*env)->FindClass(env, "java/lang/Integer")
	Dim imeth As jmethodID
	imeth = (*env)->GetMethodID(env, ic, "intValue", "()I")
	Return (*env)->CallIntMethod(env, i,imeth) 	
End Function





Function Java_com_zigolive_robot_JavaK8061_openDevice Alias "Java_com_zigolive_robot_JavaK8061_openDevice" (env as JNIEnv ptr, obj as jobject) As jint Export
	Return OpenDevice
End function


Sub Java_com_zigolive_robot_JavaK8061_closeDevices Alias "Java_com_zigolive_robot_JavaK8061_closeDevices" (env as JNIEnv ptr, obj as jobject) export
	CloseDevices
End sub

Function Java_com_zigolive_robot_JavaK8061_readAnalogChannel Alias "Java_com_zigolive_robot_JavaK8061_readAnalogChannel" (env as JNIEnv ptr, obj as jobject,channel As jint) As jint Export
	Return ReadAnalogChannel(getCardId(env,obj), channel)
End function


Function Java_com_zigolive_robot_JavaK8061_powerGood Alias "Java_com_zigolive_robot_JavaK8061_powerGood" (env as JNIEnv ptr, obj as jobject) As jlong Export
	Return PowerGood(getCardId(env, obj))
End function

Function Java_com_zigolive_robot_JavaK8061_connected Alias "Java_com_zigolive_robot_JavaK8061_connected" (env as JNIEnv ptr, obj as jobject) As jlong Export
	Return Connected(getCardId(env, obj))
End function
' Get the board version, and return it as a Java Long array
function Java_com_zigolive_robot_JavaK8061_readVersion Alias "Java_com_zigolive_robot_JavaK8061_readVersion" (env as JNIEnv ptr, obj as jobject) As jlongArray Export
	Dim buffer(50) As Long
	Dim pbuffer As Long Ptr = @buffer(0)
	ReadVersion(getCardId(env,obj),pbuffer)
	Dim rba As jlongArray
	rba = (*env)->NewLongArray(env, 50)
	Dim temp(50) As jlong
	Dim i As Integer
	For i = 0 To 49
		temp(i) = buffer(i)
	Next
	Dim ptemp As jlong Ptr = @temp(0)
	(*env)->SetLongArrayRegion(env, rba, 0, 50, ptemp)
	Return rba
end Function



function Java_com_zigolive_robot_JavaK8061_readAllAnalog Alias "Java_com_zigolive_robot_JavaK8061_readAllAnalog" (env as JNIEnv ptr, obj as jobject) As jlongArray Export
	Dim buffer(0 To 7) As Long
	Dim pbuffer As Long Pointer = @buffer(0)
	ReadAllAnalog(getCardId(env, obj), pbuffer)
	
	Dim rba As jlongArray
	rba = (*env)->NewLongArray(env, 8)
	Dim temp(0 To 7) As jlong
	Dim i As Integer
	For i=0 To 7
		temp(i) = buffer(i)
	Next
	Dim ptemp As jlong Ptr = @temp(0)
	(*env)->SetLongArrayRegion(env, rba, 0, 8, ptemp)
	Return rba
end function

Sub Java_com_zigolive_robot_JavaK8061_outputAnalogChannel Alias "Java_com_zigolive_robot_JavaK8061_outputAnalogChannel" (env as JNIEnv ptr, obj as jobject,channel As jlong, ddata As jlong) Export
	OutputAnalogChannel(getCardId(env, obj), channel, ddata)
end sub


Sub Java_com_zigolive_robot_JavaK8061_outputAllAnalog Alias "Java_com_zigolive_robot_JavaK8061_outputAllAnalog" (env as JNIEnv ptr, obj as jobject, o As jlongArray) Export
	' Convert the jlongarray to a long(), then send the pointer
	Dim b As jboolean
	Dim pb As jboolean Ptr = @b
	Dim parr As jlong Ptr
	
	parr = (*env)->GetLongArrayElements(env, o, null)
	Dim i As Integer
	Dim larr(8) As Long 
	For i = 0 To 7
		larr(i) = *(parr+i)
	Next
	Dim plarr As Long Ptr = @larr(0)
	OutputAllAnalog(getCardId(env, obj), plarr) 
end sub

Sub Java_com_zigolive_robot_JavaK8061_clearAnalogChannel Alias "Java_com_zigolive_robot_JavaK8061_clearAnalogChannel" (env as JNIEnv ptr, obj as jobject, channel As jlong) Export
	ClearAnalogChannel(getCardId(env, obj), channel)
end sub

Sub Java_com_zigolive_robot_JavaK8061_setAllAnalog Alias "Java_com_zigolive_robot_JavaK8061_setAllAnalog" (env as JNIEnv ptr, obj as jobject) Export
	SetAllAnalog(getCardId(env, obj))
end sub

Sub Java_com_zigolive_robot_JavaK8061_clearAllAnalog Alias "Java_com_zigolive_robot_JavaK8061_clearAllAnalog" (env as JNIEnv ptr, obj as jobject) Export
	ClearAllAnalog(getCardId(env, obj))
end sub

Sub Java_com_zigolive_robot_JavaK8061_setAnalogChannel Alias "Java_com_zigolive_robot_JavaK8061_setAnalogChannel" (env as JNIEnv ptr, obj as jobject,channel As jlong) Export
	SetAnalogChannel(getCardId(env, obj), channel)
end sub

Sub Java_com_zigolive_robot_JavaK8061_outputAllDigital Alias "Java_com_zigolive_robot_JavaK8061_outputAllDigital" (env as JNIEnv ptr, obj as jobject,ddata As jlong) Export
	OutputAllDigital(getCardId(env, obj),ddata) 
end sub

Sub Java_com_zigolive_robot_JavaK8061_outputAllDigitalA Alias "Java_com_zigolive_robot_JavaK8061_outputAllDigitalA" (env as JNIEnv ptr, obj as jobject,ddata As jbooleanArray) Export
	'%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	Dim parr As jboolean Ptr
	Dim b(1 To 8) As Integer = {1,2,4,8,16,32,64,128}
	Dim i As Integer
	'Dim iddata(0 To 7) As Integer 
	Dim res As Integer 
	parr = (*env)->GetBooleanArrayElements(env, ddata, null)
	For i=0 To 7
		'iddata(i) = *(parr+i)
		If *(parr+i) > 0 Then
			res = res + b(i+1)
		EndIf
		'Print iddata(i)
	Next
	'Print res
	OutputAllDigital(getCardId(env, obj),res) 
end sub

Sub Java_com_zigolive_robot_JavaK8061_clearDigitalChannel Alias "Java_com_zigolive_robot_JavaK8061_clearDigitalChannel" (env as JNIEnv ptr, obj as jobject,channel As jlong) Export
	ClearDigitalChannel(getCardId(env, obj),channel)
end sub

Sub Java_com_zigolive_robot_JavaK8061_clearAllDigital Alias "Java_com_zigolive_robot_JavaK8061_clearAllDigital" (env as JNIEnv ptr, obj as jobject) Export
	ClearAllDigital(getCardId(env, obj))
end sub

Sub Java_com_zigolive_robot_JavaK8061_setDigitalChannel Alias "Java_com_zigolive_robot_JavaK8061_setDigitalChannel" (env as JNIEnv ptr, obj as jobject,channel As jlong) Export
	SetDigitalChannel(getCardId(env, obj), channel)
end sub

Sub Java_com_zigolive_robot_JavaK8061_setAllDigital Alias "Java_com_zigolive_robot_JavaK8061_setAllDigital" (env as JNIEnv ptr, obj as jobject) Export
	SetAllDigital(getCardId(env, obj))
end sub

Function Java_com_zigolive_robot_JavaK8061_readDigitalChannel Alias "Java_com_zigolive_robot_JavaK8061_readDigitalChannel" (env as JNIEnv ptr, obj as jobject, channel As jlong) As jlong Export
	Return ReadDigitalChannel(getCardId(env, obj), channel)
End function

Function Java_com_zigolive_robot_JavaK8061_readAllDigital Alias "Java_com_zigolive_robot_JavaK8061_readAllDigital" (env as JNIEnv ptr, obj as jobject) As jlong Export
	Return ReadAllDigital(getCardId(env, obj))
end function

Function Java_com_zigolive_robot_JavaK8061_readAllDigitalA Alias "Java_com_zigolive_robot_JavaK8061_readAllDigitalA" (env as JNIEnv ptr, obj as jobject) As jbooleanArray Export
	Dim digi As Integer = ReadAllDigital(getCardId(env, obj))
	
	Dim bdigi(8) As UByte
	Dim b(0 To 7) As Integer = {1,2,4,8,16,32,64,128}
	Dim i As Integer
	Dim rba As jbooleanArray
	rba = (*env)->NewBooleanArray(env, 8)
	For i=0 To 7
		Dim v As Integer = digi And b(i) 
		If v>0 Then 
			bdigi(i) = 1
		Else	
			bdigi(i) = 0
		End if
	Next
	Dim ptemp As jboolean Ptr = @bdigi(0)
	(*env)->SetBooleanArrayRegion(env, rba, 0, 8, ptemp)
	Return rba
end function

Sub Java_com_zigolive_robot_JavaK8061_outputPWM Alias "Java_com_zigolive_robot_JavaK8061_outputPWM" (env as JNIEnv ptr, obj as jobject,ddata As jlong) Export 
	OutputPWM(getCardId(env, obj), ddata)
end sub

