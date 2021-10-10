# ToDoMVC-automation Repository

====================================================================== <br />
Product Name	 : ToDoMVC-automation <br />
Release Version : 1.0 <br />
Release Date	 : 10 October 2021 <br />

======================================================================
# Supported Platforms

   Apple Mac OS X <br />
      10.14.x 64-bit on x86-64 <br />
   Microsoft Windows <br />
      10 64-bit on x86-64 <br />
   Red Hat Enterprise Linux Server <br />
      7.0 64-bit on x86-64 <br />

======================================================================
#  Minimum Software Requirements

   Oracle Corporation: <br />
     JAVA 15.0.1 <br />
   Apache Org: <br />
     Maven 3.6.3 <br />
   Google Corporation <br />
     Google Chrome latest v 93 onwards  <br />

======================================================================
#  Optional Software Requirements for running in docker

   Docker Corporation <br />
     Docker 19.03.8 <br />
   Real VNC Corporation <br />
     VNC Viewer 6.21.406 <br />

======================================================================
# Steps To Run

You can run the automation test in the following ways: <br />

 # A. Running with mvn
  
  Step 1.Clone this repository inyour local machine <br />
  Step 2.Go to root directory of the project "todomvc-automation" <br />
  Step 3.Run CMD / Shell / Terminal on this path todomvc-automation/ <br />
  Step 4.Run the command - mvn clean test <br />
  Step 5.Automation test will run in terminal assuming software requirements are met <br />
  Step 6.Report will be published at todomvc-automation\target\cucumber-reports\report.html <br />
  
 # B. Running with Docker

  Step 1.docker pull selenium/standalone-chrome-debug:3.141.59 <br />
  Step 2.docker pull komalpande/todomvc-automation:latest <br />
  Step 3.docker run -d -p 4444:4444 -p 5900:5900 --shm-size="2g" selenium/standalone-chrome-debug:3.141.59 <br />
  Step 4.docker run -d --network="host" komalpande/todomvc-automation:latest mvn -f /home/todomvc-automation/pom.xml clean test -Dbrowser="chrome" <br />
  Step 5.Open VNC viewer and connect to localhost:5900 to see remote execuion in docker , open URL localhost:5900 enter default user and pass "secret" <br />
  Step 6.Docker logs <<container_name_for_komalpande/todomvc-automation>> to view logs <br />
  Step 7.View test execution logs at https://reports.cucumber.io/reports/<<report_id_from_docker_logs>> <br />


======================================================================<br />
This code is created and maintained by Komal Pande Dated 10 Oct 2021.

