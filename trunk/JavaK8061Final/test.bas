'' to compile: fbc -dll -Wl --kill-at JavaK8061.bas




Declare Function OpenDevice Lib "k8061.dll" Alias "OpenDevice" () As Long
Declare Sub CloseDevices Lib "k8061.dll" Alias "CloseDevices" ()
Declare Function ReadAnalogChannel Lib "k8061.dll" Alias "ReadAnalogChannel" (ByVal CardAddress As Long, ByVal Channel As Long) As Long
Declare Function PowerGood Lib "k8061.dll" Alias "PowerGood" (ByVal CardAddress As Long) As Long
Declare Function Connected Lib "k8061.dll" Alias "Connected" (ByVal CardAddress As Long) As Long
Declare Sub ReadVersion Lib "k8061.dll" Alias "ReadVersion" (ByVal CardAddress As Long, buffer As Long ptr)
Declare Sub ReadAllAnalog Lib "k8061.dll" Alias "ReadAllAnalog" ( ByVal CardAddress As Long, Buffer As Long ptr)
Declare Sub OutputAnalogChannel Lib "k8061.dll" Alias "OutputAnalogChannel" (ByVal CardAddress As Long, ByVal Channel As Long, ByVal Data As Long)
Declare Sub OutputAllAnalog Lib "k8061.dll" Alias "OutputAllAnalog" (ByVal CardAddress As Long, Buffer As Long)
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


Print OpenDevice

clearalldigital(0)
Print ReadAllDigital(0)

Dim b(1 To 8) As Integer = {1,2,4,8,16,32,64,128}
Dim i As Integer
For i=1 To 8
	Dim v As Integer = 117 And b(i) 
	If v>0 Then 
		Print "True",
	Else	
		Print "false",
	End if
Next
		