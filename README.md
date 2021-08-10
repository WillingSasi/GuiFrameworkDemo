1。login token
2.shut down
3.exception

Android remote connect 
1.Thd android device and PC(or Mac) are in the same LAN
  Connect the device to PC by USB and check the device do have an IP.
2.Execute this command lines in terminal:
  adb tcpip 5555      # open port
  adb connect IP:5555 # the device's IP
3.Pull out USB and check :
  adb devices
4.Disconnect after running cases:
  adb disconnect IP:5555 