Project Description
--

Maven multi module project. This project covers scopes described above, 
maven profiles, jacoco plugin both on hellomaven project pom.xml 

Scopes:

-compile: scope default,it is used run and compile classes and to run tests.

-provided: it is used run classes and tests. This tells that the dependency is not to be part of our application. (for
example tomcat is needed to run locally but it´s not when we are deploying the application to a server )

-runtime: it is used run classes and tests.

-test: it is used to run and compile the tests.

-system: system scope is very similar to the provided scope. The main difference is that system requires us to directly
point to a specific jar on the system.

``` 
example:
 <scope>system</scope>
 <systemPath>${project.basedir}/libs/custom-dependency-1.3.2.jar</systemPath>
````

-import: t’s only available for the dependency type pom.

import indicates that this dependency should be replaced with all effective dependencies declared in its POM.

``` 
Here, below custom-project dependency will be replaced with all dependencies declared in custom-project’s pom.xml <dependencyManagement> section.

 <dependency>
    <groupId>com.baeldung</groupId>
    <artifactId>custom-project</artifactId>
    <version>1.3.2</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
````

DependencyManagement:

This tag consists of a dependencies tag which itself might contain multiple dependency tags. Each dependency is supposed
to have at least three main tags: groupId, artifactId, and version.
To use in the parent pom.xml to have control over the child projects dependencies versions.
In the child projects it is not required to have the version tag in the dependencies, if so the version of the child
dependency will overwrite the version of the parent pom.xm dependency version

``` 
parent pom.xml:

<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-test</artifactId>
				<scope>test</scope>
				<version>4.0</version>
			</dependency>
		</dependencies>
	</dependencyManagement>
	
child pom.xml:

            <dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-test</artifactId>
				<scope>test</scope>
			</dependency>
	
````


Repository Managers (Nexus):
Must have docker installed. After docker desktop initialized on local machine run this command: <br/>

````
docker run -d -p 8081:8081 --name nexus sonatype/nexus3
````
This will generate a nexus image to access on local machine, to access the interface go to http://localhost:8081/  

There are two repository types, snapshot and release.<br/>
The snapshot is for projects with -SNAPSHOT between the version tag on pom.xml, for example: 
````
<version>1.0.0-SNAPSHOT</version>
````
The release repository is for projects with final versions, for example :
````
<version>1.0</version>
````

to deploy a project to nexus see the hellomaven pom.xml example and the settings.xml under the folder repositoy_and_settings <br />
````
pom.xml 


<repositories>
		<repository>
			<id>maven-group</id>
			<url>http://localhost:8081/repository/maven-group/</url>
		</repository>
	</repositories>

	<distributionManagement>
		<snapshotRepository>
			<id>nexus-snapshots</id>
			<url>http://localhost:8081/repository/maven-snapshots/</url>
		</snapshotRepository>
		<repository>
			<id>nexus-releases</id>
			<url>http://localhost:8081/repository/maven-releases/</url>
		</repository>
	</distributionManagement>
````

````
settings.xml 


<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.1.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">

  <servers>
    <server>
      <id>nexus-snapshots</id>
      <username>admin</username>
      <password>admintest</password>
    </server>
    <server>
      <id>nexus-releases</id>
      <username>admin</username>
      <password>admintest</password>
    </server>
  </servers>

  <mirrors>
    <mirror>
      <id>central</id>
      <name>central</name>
      <url>http://localhost:8081/repository/maven-group/</url>
      <mirrorOf>*</mirrorOf>
    </mirror>
  </mirrors>

</settings>
````

then run mvn deploy