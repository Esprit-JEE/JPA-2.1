# JPA-2.1 Skeleton

*Please configure eclipse to use JDK and not JRE
*Please set your envirnment variable JAVA_HOME to JDK 8 path


*Hibernate logging is important to read generated SQL queries :
http://www.thoughts-on-java.org/hibernate-logging-guide/
http://memorynotfound.com/configure-hibernate-logging-slf4j-log4j2/

*Application logging, slf4j is recommended :
http://howtodoinjava.com/log4j/slf4j-vs-log4j-which-one-is-better/

*Version is still SNAPSHOT ==> development in progress (https://docs.oracle.com/middleware/1212/core/MAVEN/maven_version.htm#MAVEN400)

*Reference used in the first version :
http://www.javahelps.com/2015/08/jpa-hello-world-using-hibernate.html

Database script for the first version:
CREATE DATABASE IF NOT EXISTS javahelps;

CREATE  TABLE javahelps.student ( 
student_id INT NOT NULL ,
student_name VARCHAR(45) NOT NULL ,
student_age INT NOT NULL ,
PRIMARY KEY (student_id) );

* 2 methods to run the application :
* clean package pour générer le jar exc�cutable (config faite dans le pom.xml) puis le lancer avec java -jar
* directement clean compile exec:java -Dexec.mainClass="com.javahelps.jpa.Main"


* To understand automatic schema generation :
http://www.mastertheboss.com/jboss-frameworks/hibernate-jpa/quickstart-tutorials-hibernate-jpa/jpa-21-tutorial


* <!-- for JPA, use hibernate-entitymanager instead of hibernate-core --> from official documentation :
http://hibernate.org/orm/downloads/

* To avoid this "[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!"
We should update POM with this : 		
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

*Hibernate VS JPA and conf files:
If you are using Hibernate's proprietary API, you'll need the hibernate.cfg.xml. 
If you are using JPA i.e. Hibernate EntityManager, you'll need the persistence.xml.
hibernate.cfg.xml is for Hibernate; persistence.xml is for JPA.
If you do Hibernate without JPA, you don't need persistence.xml.
If you do JPA, you have to have a provider implementation, which means Hibernate, EclipseLink, etc...

*To understand aspectJ :
http://www.darpandodiya.com/code/aspectj-notes-tutorial-example/