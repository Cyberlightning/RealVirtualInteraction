Real Virtual Interaction Installation and Administration Guide
======================================

-   [1 Introduction](#Introduction)
-   [2 System Requirements](#System_Requirements)
    -   [2.1 Hardware Requirements](#Hardware_Requirements)
    -   [2.2 Operating System Support](#Operating_System_Support)
    -   [2.3 Software Requirements](#Software_Requirements)
        -   [2.3.1 Client Side](#Client_Side)
        -   [2.3.2 Real Virtual Interaction Server](#Real_Virtual_Interaction_Server)
        -   [2.3.3 Publish/Subscribe Web Client](#Publish_Subscribe_Web_Client)
-   [3 Software Installation and Configuration](#Software_Installation_and_Configuration)
-   [4 Sanity Checks](#Sanity_Checks)
    -   [4.1 End to End testing](#End_to_End_testing)
    -   [4.2 List of Running Processes](#List_of_Running_Processes)
    -   [4.3 Network interfaces Up & Open](#Network_interfaces_Up_and_Open)
    -   [4.4 Databases](#Databases)
-   [5 Diagnosis Procedures](#Diagnosis_Procedures)
    -   [5.1 Resource availability](#Resource_availability)
    -   [5.2 Remote Service Access](#Remote_Service_Access)
    -   [5.3 Resource consumption](#Resource_consumption)
    -   [5.4 I/O flows](#IO_flows)

<a name="Introduction"></a>
# Introduction

This guide if for installing and administering FIWARE Real Virtual
Interaction Server. Although this guide is mainly for Real Virtual
Interaction Backend software, we have included some instructions about
how to get the client application working as well.

<a name="System_Requirements"></a>
# System Requirements

Minumum requirements follow official Java SE 1.7 requirements. In excess
the real virtual backend requires around 300KB of hard disk space +
space for databases (2KB upwards depending on amount of sensor data).
With one android application feeding sensor data the estimated size of
data base should not arise over 1MB. Real virtual backend requires about
heap 50MB.

<a name="Hardware_Requirements"></a>
## Hardware Requirements

Hardware with Windows and MacOS X

-   RAM: 128 MB; 64 MB for Windows XP (32-bit)
-   Disk space: 124 MB

Hardware with Linux:

-   RAM: 64 MB
-   Disk space: 58 MB

<a name="Operating_System_Support"></a>
## Operating System Support

Windows:

-   Windows 8 (Desktop)
-   Windows 7
-   Windows Vista SP2
-   Windows XP SP3 (32-bit); Windows XP SP2 (64-bit)
-   Windows Server 2008
-   Windows Server 2012 (64-bit)

Mac OS X:

-   Intel-based Mac running Mac OS X 10.7.3 (Lion) or later.
-   Administrator privileges for installation

Linux:

-   Oracle Linux 5.5+
-   Oracle Linux 6.x (32-bit)\*, 6.x (64-bit)\*\*
-   Red Hat Enterprise Linux 5.5+, 6.x (32-bit)\*, 6.x (64-bit)\*\*
-   Ubuntu Linux\* 10.04 and above
-   Suse Linux Enterprise Server\* 10 SP2, 11.x

<a name="Software_Requirements"></a>
## Software Requirements

<a name="Client_Side"></a>
### Client Side

Browsers with Windows OS:

-   Firefox 3.6 and above,
-   Chrome

Browser with Mac OS X:

-   64-bit browser
-   A 64-bit browser (Safari or Firefox, for example) is required to run
    Java 7 on Mac OS X. 32-bit browsers such as Chrome do not support
    Java 7 on the Mac platform.

Browsers with Linux:

-   All OS that support versions Firefox 3.6 and above

<a name="Real_Virtual_Interaction_Server"></a>
### Real Virtual Interaction Server

The binary file contains dependencies, but if you are build from the
source code then you need to acquire the following Dependencies:

-   [json-simple-1.1.1.jar](http://code.google.com/p/json-simple/ "http://code.google.com/p/json-simple/")
-   [commons-codec-1.8.jar](http://commons.apache.org/proper/commons-codec/download_codec.cgi "http://commons.apache.org/proper/commons-codec/download_codec.cgi")
-   [JRE](http://www.oracle.com/technetwork/java/javase/downloads/index.html "http://www.oracle.com/technetwork/java/javase/downloads/index.html")

<a name="Publish_Subscribe_Web_Client"></a>
### Publish/Subscribe Web Client

The .html file contains the neccessary source code and can be deployed
locally or on remote server. There are following JavaScipt files as
dependencies:

     <link href="css/eggplant/jquery-ui-1.10.3.custom.css" rel="stylesheet">
     <script src="js/jquery-1.9.1.js"></script>
     <script src="js/jquery-ui-1.10.3.custom.js"></script>
     <script src="js/three.min.js"></script>

You can manually download them from following links and place them on
the server .

-   [jquery, jquery-ui-1.10.3.custom.css,
    jquery-ui-1.10.3.custom.js](https://jqueryui.com/download/all/)
-   [three.min.js](http://threejs.org/ "http://threejs.org/")

<a name="Software_Installation_and_Configuration"></a>
# Software Installation and Configuration

In order to change the configuration of the real virtual interaction
backend, you will need to make your own build. All server configurations
can be changed from StaticResources.java class file. Please refer to
software requirements chapter for dependencies. Any Java supported IDE
is fine for importing the source code. We recommend [Eclipse
IDE](http://www.eclipse.org/downloads/ "http://www.eclipse.org/downloads/").
Egit is a good plugin for Eclipse and allows importing projects directly
from the [GitHub](https://github.com/ "https://github.com/"). Before
this you should register an account to GitHub.com and also follow
instructions on how to install git on to your machine. In Eclipse you
can just choose File-\>Import.. and then scroll to Git folder and choose
"Projects from Git" and press "next". Then choose "URI" and press
"next". If you have copied the github repository link (which is for real
virtual interaction backend repo:
[https://github.com/Cyberlightning/RealVirtualInteraction.git](https://github.com/Cyberlightning/RealVirtualInteraction))
to clip board, the information should automatically be pasted to
required fields. After this choose "master" branch and clone to project.
In the last screen you can use new project wizard to import the project
as a Java project. After these steps you can simply choose run or debug
to test the import.

Otherwise you can deploy the binary .jar file to any server. You can use
FTP software like
[Filezilla](https://filezilla-project.org/ "https://filezilla-project.org/")
to upload the binary file to desired location. Binary file can be
downloaded from
[here](https://forge.fiware.org/frs/download.php/1595/MIWI-RealVirtualBackend-Release-4.2.3.jar "https://forge.fiware.org/frs/download.php/1595/MIWI-RealVirtualBackend-Release-4.2.3.jar").
You can start server in Linux for instance:

     $ screen java -jar MIWI-RealVirtualBackend-Release-4.2.3.jar

Type Ctrl+A+D to detach screen and leave it running.

<a name="Sanity_Checks"></a>
Sanity Checks
=============

<a name="End_to_End_testing"></a>
## End to End testing

To ensure that the real virtual interaction backend functions as
required, the administrator can run a simulation test by starting the
binary .jar file with following parameters:

    $ java -jar MIWI-RealVirtualBackend-Release-3.3.3.jar -simulate

The simulate parameter will launch a test routine that will simulate a
connected device and sends a test packet every 3 seconds to the UDP port
of the server. This data will be stored in the database and will be
available for subscription/publishing as well as request response. Below
example is a simulation run in Windows through console. Don't worry if
there is some garbled text in the console, simulation is still working
ok.

    Microsoft Windows [Version 6.0.6001]
      Copyright (c) 2006 Microsoft Corporation.  All rights reserved.

      C:\java -jar MIWI-RealVirtualBackend-Release-3.3.3.jar -simulate
      Test Packet send to 10.20.217.101:61616
      Test Packet send to 10.20.217.101:61616
      Test Packet send to 10.20.217.101:61616
      Serialized data is saved in deviceDB.ser
      Serialized data is saved in BaseStationRefernceDB.ser
      Test Packet send to 10.20.217.101:61616

When the simulation is running you can connect to the server with the
PubSubClient or use ReqResClient to test whether the server is
accessible by remote clients. This is also a fast way to test those
clients. You can also send messages to the simulator by using
"d23c058698435eff" as
[UUID](http://en.wikipedia.org/wiki/Universally_unique_identifier "http://en.wikipedia.org/wiki/Universally_unique_identifier").
If on a localhost, a sample query could be:

    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
      Accept-Encoding: gzip, deflate
      Accept-Language: fi-fi,fi;q=0.8,en-us;q=0.5,en;q=0.3
      Connection: keep-alive
      Host: 127.0.0.1:44446
      User-Agent: Mozilla/5.0 (Windows NT 6.0; rv:25.0) Gecko/20100101 Firefox/25.0
      Content-Length: 81
      Content-Type: application/x-www-form-urlencoded

      action=update&device_id=d23c058698435eff&sensor_id=test&parameter=test&value=test

The server should print the following in console if the message is being
received:

    Packet received from server:action=update&device_id=d23c058698435eff&sensor_id=test&parameter=test&value=test

You can use the HttpQueryTester.html included in the html folder of the
real virtual interaction backend source code to test it. Just make sure
that you type in localhost address (127.0.0.1).

<a name="List_of_Running_Processes"></a>
## List of Running Processes

The real virtual interaction backend will start one process with Java.
You can for instance in Linux use

    top -U <user> 

The process will show as "java" process run by the user.

<a name="Network_interfaces_Up_and_Open"></a>
## Network interfaces Up & Open

-   UDP port: 61616 (by default)
-   UDP port: 61617 (only needed for testing and is by default one
    greater than set UDP port)
-   TCP port: 44445 (by default)
-   TCP port: 44446 (by default)

<a name="Databases"></a>
## Databases

The real virtual interaction backend will create the database files if
they do not exist. There is no need for any SQL solution currently.

Default names for data base files:

-   DeviceDB.ser
-   BaseStationReferenceDB.ser

<a name="Diagnosis_Procedures"></a>
# Diagnosis Procedures

<a name="Resource_availability"></a>
## Resource availability

The GE is rather lightweight and is capable in running on a decent
hardware with 1-2GB of RAM. Amount of harddisk is dedicated for
serializing incoming sensor traffic hence a few GB is completely ok for
starters. The complete scaling of these attributes comes from the real
amount of events the service needs to be able to handle.

<a name="Remote_Service_Access"></a>
## Remote Service Access

Using a SSH enabled console to check the status of server. Otherwise NO
external administration interface is being provided along with the
deliverable.

<a name="Resource_consumption"></a>
## Resource consumption

The CPU load should be around 0-1% when there is not I/O events on
server. Temporarily the server may use more CPU but if there is a stable
100% there is likely something wrong and server should be restarted. In
linux use following command to check CPU/Memory consumption:

    top -U <user>

<a name="IO_flows"></a>
## I/O flows

-   UDP port 61616 (by default) does not accept larger than 1024 byte
    UDP packets. This is because larger than 1024 bytes may not be
    supported network
    [MTU](http://en.wikipedia.org/wiki/Maximum_transmission_unit "http://en.wikipedia.org/wiki/Maximum_transmission_unit").
    The payload may be compressed using Gzip to increase amount of
    information. There can be a mechanism developed to include data
    being divided in to multiple packets, but due to nature of UDP
    traffic this is not recommended. Rather divide data into separate
    packets from device end.

