# hopital-data-service



#Add Lombok JAR

Follow these steps to integrate Lombok into your project:

##1) Create lib folder in module:
 Create a new folder named lib within your project module.
 
##2 Download Lombok JAR:
Download the Lombok JAR file and place it in the lib folder you created.

##3 Configure Spring Tool Suite (STS) on MacOS:
- Navigate to the STS application in Finder.
- Right-click on the STS application and select "Show Package Contents."

##4 Locate SpringToolSuite4.ini:
Navigate to Contents -> Eclipse -> SpringToolSuite4.ini.

##5 Edit SpringToolSuite4.ini:
Open SpringToolSuite4.ini in a text editor in terminal.

open -a TextEdit SpringToolSuite4.ini

##6 Add the following lines:

 #Lombok Java Agent Configuration
 
-javaagent:/path/to/lombok.jar


Make sure to replace /path/to/lombok.jar with the actual path to your Lombok JAR file.

##7 Save and Restart:

- Save the changes to SpringToolSuite4.ini.
- Restart Spring Tool Suite for the configuration to take effect.

These additions instruct the Java Virtual Machine (JVM) to use the Lombok Java agent during the execution of STS.





