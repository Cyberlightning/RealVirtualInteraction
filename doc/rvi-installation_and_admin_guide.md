<div id="bodyContent">
<h1> Real Virtual Interaction, <br> Installation and Administration Guide </h1>
  <ul>
    <li class="toclevel-1"><a href="#Introduction"><span class="tocnumber">1</span> <span class="toctext">Introduction</span></a></li>
    <li class="toclevel-1"><a href="#System_Requirements"><span class="tocnumber">2</span> <span class="toctext">System Requirements</span></a>
      <ul>
        <li class="toclevel-2"><a href="#Hardware_Requirements"><span class="tocnumber">2.1</span> <span class="toctext">Hardware Requirements</span></a></li>
        <li class="toclevel-2"><a href="#Operating_System_Support"><span class="tocnumber">2.2</span> <span class="toctext">Operating System Support</span></a></li>
        <li class="toclevel-2"><a href="#Software_Requirements"><span class="tocnumber">2.3</span> <span class="toctext">Software Requirements</span></a>
          <ul>
            <li class="toclevel-3"><a href="#Client_Side"><span class="tocnumber">2.3.1</span> <span class="toctext">Client Side</span></a></li>
            <li class="toclevel-3"><a href="#Real_Virtual_Interaction_Server"><span class="tocnumber">2.3.2</span> <span class="toctext">Real Virtual Interaction Server</span></a></li>
            <li class="toclevel-3"><a href="#Publish.2FSubscribe_Web_Client"><span class="tocnumber">2.3.3</span> <span class="toctext">Publish/Subscribe Web Client</span></a></li>
          </ul>
        </li>
      </ul>
    </li>
    <li class="toclevel-1"><a href="#Software_Installation_and_Configuration"><span class="tocnumber">3</span> <span class="toctext">Software Installation and Configuration</span></a></li>
    <li class="toclevel-1"><a href="#Sanity_Checks"><span class="tocnumber">4</span> <span class="toctext">Sanity Checks</span></a>
      <ul>
        <li class="toclevel-2"><a href="#End_to_End_testing"><span class="tocnumber">4.1</span> <span class="toctext">End to End testing</span></a></li>
        <li class="toclevel-2"><a href="#List_of_Running_Processes"><span class="tocnumber">4.2</span> <span class="toctext">List of Running Processes</span></a></li>
        <li class="toclevel-2"><a href="#Network_interfaces_Up_.26_Open"><span class="tocnumber">4.3</span> <span class="toctext">Network interfaces Up &amp; Open</span></a></li>
        <li class="toclevel-2"><a href="#Databases"><span class="tocnumber">4.4</span> <span class="toctext">Databases</span></a></li>
      </ul>
    </li>
    <li class="toclevel-1"><a href="#Diagnosis_Procedures"><span class="tocnumber">5</span> <span class="toctext">Diagnosis Procedures</span></a>
      <ul>
        <li class="toclevel-2"><a href="#Resource_availability"><span class="tocnumber">5.1</span> <span class="toctext">Resource availability</span></a></li>
        <li class="toclevel-2"><a href="#Remote_Service_Access"><span class="tocnumber">5.2</span> <span class="toctext">Remote Service Access</span></a></li>
        <li class="toclevel-2"><a href="#Resource_consumption"><span class="tocnumber">5.3</span> <span class="toctext">Resource consumption</span></a></li>
        <li class="toclevel-2"><a href="#I.2FO_flows"><span class="tocnumber">5.4</span> <span class="toctext">I/O flows</span></a></li>
      </ul>
    </li>
  </ul>
</td></tr></tbody></table><script type="text/javascript"> if (window.showTocToggle) { var tocShowText = "show"; var tocHideText = "hide"; showTocToggle(); } </script>
</div>
<a name="Introduction" id="Introduction"></a><h1> <span class="mw-headline"> Introduction</span></h1>
<p>This guide if for installing and administering FIWARE Real Virtual Interaction Server.  Although this guide is mainly for Real Virtual Interaction Backend software, we have included some instructions about how to get the client application working as well.
</p>
<a name="System_Requirements" id="System_Requirements"></a><h1> <span class="mw-headline"> System Requirements </span></h1>
<p>Minumum requirements follow official Java SE 1.7 requirements. In excess the real virtual backend requires
  around 300KB of hard disk space + space for databases (2KB upwards depending on amount of sensor data). With one android application feeding sensor data the estimated size of data base should not arise over 1MB. Real virtual backend requires about heap 50MB.
</p>
<a name="Hardware_Requirements" id="Hardware_Requirements"></a><h2> <span class="mw-headline"> Hardware Requirements </span></h2>
<p>Hardware with Windows and MacOS X
</p>
<ul><li> RAM: 128 MB; 64 MB for Windows XP (32-bit)
</li><li> Disk space: 124 MB
</li></ul>
<p>Hardware with Linux:
</p>
<ul><li> RAM: 64 MB
</li><li> Disk space: 58 MB
</li></ul>
<a name="Operating_System_Support" id="Operating_System_Support"></a><h2> <span class="mw-headline"> Operating System Support </span></h2>
<p>Windows:
</p>
<ul><li> Windows 8 (Desktop)
</li><li> Windows 7
</li><li> Windows Vista SP2
</li><li> Windows XP SP3 (32-bit); Windows XP SP2 (64-bit)
</li><li> Windows Server 2008
</li><li> Windows Server 2012 (64-bit)
</li></ul>
<p>Mac OS X:
</p>
<ul><li> Intel-based Mac running Mac OS X 10.7.3 (Lion) or later.
</li><li> Administrator privileges for installation
</li></ul>
<p>Linux:
</p>
<ul><li> Oracle Linux 5.5+
</li><li> Oracle Linux 6.x (32-bit)*, 6.x (64-bit)**
</li><li> Red Hat Enterprise Linux 5.5+, 6.x (32-bit)*, 6.x (64-bit)**
</li><li> Ubuntu Linux* 10.04 and above
</li><li> Suse Linux Enterprise Server* 10 SP2, 11.x
</li></ul>
<a name="Software_Requirements" id="Software_Requirements"></a><h2> <span class="mw-headline"> Software Requirements </span></h2>
<a name="Client_Side" id="Client_Side"></a><h3> <span class="mw-headline"> Client Side </span></h3>
<p>Browsers with Windows OS:
</p>
<ul><li> Firefox 3.6 and above, 
</li><li> Chrome
</li></ul>
<p>Browser with Mac OS X:   
</p>
<ul><li> 64-bit browser
</li><li> A 64-bit browser (Safari or Firefox, for example) is required to run Java 7 on Mac OS X. 32-bit browsers such as Chrome do not support Java 7 on the Mac platform.
</li></ul>
<p>Browsers with Linux:
</p>
<ul><li> All OS that support versions Firefox 3.6 and above
</li></ul>
<a name="Real_Virtual_Interaction_Server" id="Real_Virtual_Interaction_Server"></a><h3> <span class="mw-headline"> Real Virtual Interaction Server </span></h3>
<p>The binary file contains dependencies, but if you are build from the source code then you need to acquire the following Dependencies:
</p>
<ul><li> <a href="http://code.google.com/p/json-simple/" class="external text" title="http://code.google.com/p/json-simple/" rel="nofollow">json-simple-1.1.1.jar</a>
</li><li> <a href="http://commons.apache.org/proper/commons-codec/download_codec.cgi" class="external text" title="http://commons.apache.org/proper/commons-codec/download_codec.cgi" rel="nofollow">commons-codec-1.8.jar</a>
</li><li> <a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html" class="external text" title="http://www.oracle.com/technetwork/java/javase/downloads/index.html" rel="nofollow">JRE</a>
</li></ul>
<a name="Publish.2FSubscribe_Web_Client" id="Publish.2FSubscribe_Web_Client"></a><h3> <span class="mw-headline"> Publish/Subscribe Web Client </span></h3>
<p>The .html file contains the neccessary source code and can be deployed locally or on remote server. There are following JavaScipt files as dependencies:
</p>
<pre> &lt;link href="css/eggplant/jquery-ui-1.10.3.custom.css" rel="stylesheet"&gt;
 &lt;script src="js/jquery-1.9.1.js"&gt;&lt;/script&gt;
 &lt;script src="js/jquery-ui-1.10.3.custom.js"&gt;&lt;/script&gt;
 &lt;script src="js/three.min.js"&gt;&lt;/script&gt;
</pre>
<p>You can manually download them from following links and place them on the server .
</p>
<ul><li> <a href="https://jqueryui.com/download/all/">jquery, jquery-ui-1.10.3.custom.css, jquery-ui-1.10.3.custom.js</a>
</li><li> <a href="http://threejs.org/" class="external text" title="http://threejs.org/" rel="nofollow">three.min.js</a>
</li></ul>
<a name="Software_Installation_and_Configuration" id="Software_Installation_and_Configuration"></a><h1> <span class="mw-headline"> Software Installation and Configuration </span></h1>
<p>In order to change the configuration of the real virtual interaction backend, you will need to make your own build. All server configurations can be changed from StaticResources.java class file.
  Please refer to software requirements chapter for dependencies. Any Java supported IDE is fine for importing the source code. We recommend <a href="http://www.eclipse.org/downloads/" class="external text" title="http://www.eclipse.org/downloads/" rel="nofollow">Eclipse IDE</a>. Egit is a good plugin
  for Eclipse and allows importing projects directly from the <a href="https://github.com/" class="external text" title="https://github.com/" rel="nofollow">GitHub</a>. Before this you should register an account to GitHub.com and also follow instructions on how to install git on to your machine. 
  In Eclipse you can just choose File-&gt;Import.. and then scroll to Git folder and choose "Projects from Git" and press "next". Then choose "URI" and press "next". If you have copied the github repository link 
  (which is for real virtual interaction backend repo: <a href="https://github.com/Cyberlightning/RealVirtualInteraction">https://github.com/Cyberlightning/RealVirtualInteraction.git</a>) to clip board, the information should automatically be pasted to required fields. After this choose "master" 
  branch and clone to project. In the last screen you can use new project wizard to import the project as a Java project. After these steps you can simply choose run or debug to test the import. 
</p><p>Otherwise you can deploy the binary .jar file to any server. You can use FTP software like <a href="https://filezilla-project.org/" class="external text" title="https://filezilla-project.org/" rel="nofollow">Filezilla</a> to upload the binary file to desired location. Binary file can be downloaded from <a href="https://forge.fiware.org/frs/download.php/1595/MIWI-RealVirtualBackend-Release-4.2.3.jar" class="external text" title="https://forge.fiware.org/frs/download.php/1595/MIWI-RealVirtualBackend-Release-4.2.3.jar" rel="nofollow">here</a>. You can start server in Linux for instance:
</p>
<pre> $ screen java -jar MIWI-RealVirtualBackend-Release-4.2.3.jar
</pre>
<p>Type Ctrl+A+D to detach screen and leave it running.
</p>
<a name="Sanity_Checks" id="Sanity_Checks"></a><h1> <span class="mw-headline"> Sanity Checks </span></h1>
<a name="End_to_End_testing" id="End_to_End_testing"></a><h2> <span class="mw-headline"> End to End testing</span></h2>
<p>To ensure that the real virtual interaction backend functions as required, the administrator can run a simulation test by starting the binary .jar file with following parameters:
</p>
<pre>$ java -jar MIWI-RealVirtualBackend-Release-3.3.3.jar -simulate
</pre>
<p>The simulate parameter will launch a test routine that will simulate a connected device and sends a test packet every 3 seconds to the UDP port of the server. This data will be stored in the database and will be available for subscription/publishing as well as request response. Below example is a simulation run in Windows through console. Don't worry if there is some garbled text in the console, simulation is still working ok.
</p>
<pre>Microsoft Windows [Version 6.0.6001]
  Copyright (c) 2006 Microsoft Corporation.  All rights reserved.

  C:\java -jar MIWI-RealVirtualBackend-Release-3.3.3.jar -simulate
  Test Packet send to 10.20.217.101:61616
  Test Packet send to 10.20.217.101:61616
  Test Packet send to 10.20.217.101:61616
  Serialized data is saved in deviceDB.ser
  Serialized data is saved in BaseStationRefernceDB.ser
  Test Packet send to 10.20.217.101:61616
</pre>
<p>When the simulation is running you can connect to the server with the PubSubClient or use ReqResClient to test whether the server is accessible by remote clients. This is also a fast way to test those clients. You can also send messages to the simulator by using "d23c058698435eff" as <a href="http://en.wikipedia.org/wiki/Universally_unique_identifier" class="external text" title="http://en.wikipedia.org/wiki/Universally_unique_identifier" rel="nofollow">UUID</a>. If on a localhost, a sample query could be:
</p>
<pre>Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
  Accept-Encoding: gzip, deflate
  Accept-Language: fi-fi,fi;q=0.8,en-us;q=0.5,en;q=0.3
  Connection: keep-alive
  Host: 127.0.0.1:44446
  User-Agent: Mozilla/5.0 (Windows NT 6.0; rv:25.0) Gecko/20100101 Firefox/25.0
  Content-Length: 81
  Content-Type: application/x-www-form-urlencoded

  action=update&amp;device_id=d23c058698435eff&amp;sensor_id=test&amp;parameter=test&amp;value=test
</pre>
<p>The server should print the following in console if the message is being received:
</p>
<pre>Packet received from server:action=update&amp;device_id=d23c058698435eff&amp;sensor_id=test&amp;parameter=test&amp;value=test
</pre>
<p>You can use the HttpQueryTester.html included in the html folder of the real virtual interaction backend source code to test it. Just make sure that you type in localhost address (127.0.0.1).
</p>
<a name="List_of_Running_Processes" id="List_of_Running_Processes"></a><h2> <span class="mw-headline">List of Running Processes</span></h2>
<p>The real virtual interaction backend will start one process with Java. You can for instance in Linux use 
</p>
<pre>top -U &lt;user&gt; 
</pre>
<p>The process will show as "java" process run by the user.
</p>
<a name="Network_interfaces_Up_.26_Open" id="Network_interfaces_Up_.26_Open"></a><h2> <span class="mw-headline">Network interfaces Up &amp; Open </span></h2>
<ul><li> UDP port: 61616 (by default)
</li><li> UDP port: 61617 (only needed for testing and is by default one greater than set UDP port)
</li><li> TCP port: 44445 (by default)
</li><li> TCP port: 44446 (by default)
</li></ul>
<a name="Databases" id="Databases"></a><h2> <span class="mw-headline">Databases</span></h2>
<p>The real virtual interaction backend will create the database files if they do not exist. There is no need for any SQL solution currently. 
</p><p>Default names for data base files:
</p>
<ul><li> DeviceDB.ser
</li><li> BaseStationReferenceDB.ser
</li></ul>
<a name="Diagnosis_Procedures" id="Diagnosis_Procedures"></a><h1> <span class="mw-headline">Diagnosis Procedures</span></h1>
<a name="Resource_availability" id="Resource_availability"></a><h2> <span class="mw-headline"> Resource availability </span></h2>
<p>The GE is rather lightweight and is capable in running on a decent hardware with 1-2GB of RAM. Amount of harddisk is dedicated for serializing incoming sensor traffic hence a few GB is completely ok for starters. The complete scaling of these attributes comes from the real amount of events the service needs to be able to handle.
</p>
<a name="Remote_Service_Access" id="Remote_Service_Access"></a><h2> <span class="mw-headline">Remote Service Access</span></h2>
<p>Using a SSH enabled console to check the status of server. Otherwise NO external administration interface is being provided along with the deliverable.
</p>
<a name="Resource_consumption" id="Resource_consumption"></a><h2> <span class="mw-headline">Resource consumption</span></h2>
<p>The CPU load should be around 0-1% when there is not I/O events on server. Temporarily the server may use more CPU but if 
  there is a stable 100% there is likely something wrong and server should be restarted. In linux use following command to check CPU/Memory consumption:
</p>
<pre>top -U &lt;user&gt;
</pre>
<a name="I.2FO_flows" id="I.2FO_flows"></a><h2> <span class="mw-headline">I/O flows</span></h2>
<ul><li> UDP port 61616 (by default) does not accept larger than 1024 byte UDP packets. This is because larger than 1024 bytes may not be supported network <a href="http://en.wikipedia.org/wiki/Maximum_transmission_unit" class="external text" title="http://en.wikipedia.org/wiki/Maximum_transmission_unit" rel="nofollow">MTU</a>. The payload may be compressed using Gzip to increase amount of information. There can be a mechanism developed to include data being divided in to multiple packets, but due to nature of UDP traffic this is not recommended. Rather divide data into separate packets from device end.
</li></ul>
  
</div>