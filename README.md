# ToDoMVC-automation Repository

======================================================================
Product Name	 : ToDoMVC-automation
Release Version	 : 1.0
Release Date	 : 10 October 2021

======================================================================
# Supported Platforms

   Apple Mac OS X
      10.14.x 64-bit on x86-64
   Microsoft Windows
      10 64-bit on x86-64
   Red Hat Enterprise Linux Server
      7.0 64-bit on x86-64

======================================================================
#  Minimum Software Requirements

   Oracle Corporation:
     JAVA 15.0.1
   Apache Org:
     Maven 3.6.3

======================================================================
#  Optional Software Requirements for running in docker

   Docker Corporation
     Docker 19.03.8
   Real VNC Corporation
     VNC Viewer 6.21.406

======================================================================
# Steps To Run

You can run the automation test in the following ways:

 # A. Running with mvn
  
  Step 1.Clone this repository inyour local machine.
  Step 2.Go to root directory of the project "todomvc-automation"
  Step 3.Run CMD / Shell / Terminal on this path todomvc-automation/
  Step 4.Run the command - mvn clean test
  Step 5.Automation test will run in terminal assuming software requirements are met
  Step 6.Report will be published at todomvc-automation\target\cucumber-reports\report.html
  
 # B. Running with Docker

  Step 1.docker pull selenium/standalone-chrome-debug:3.141.59
  Step 2.docker pull komalpande/todomvc-automation:latest
  Step 3.Step docker run -d -p 4444:4444 -p 5900:5900 --shm-size="2g" selenium/standalone-chrome-debug:3.141.59
  Step 4.docker run -d --network="host" komalpande/todomvc-automation:latest mvn -f /home/todomvc-automation/pom.xml clean test -Dbrowser="chrome"
  Step 5.Open VNC viewer and connect to localhost:5900 to see remote execuion in docker
  Step 6.Docker logs <<container_name_for_komalpande/todomvc-automation>> to view logs


======================================================================
This code is created and maintained by Komal Pande Dated 10 Oct 2021.

