# JPA-2.1

Ne pas oublier de :
1) configurer votre eclipse pour utiliser la JDK et non pas la JRE

Version is still SNAPSHOT ==> development in progress (https://docs.oracle.com/middleware/1212/core/MAVEN/maven_version.htm#MAVEN400)

Reference used in the first version :
http://www.javahelps.com/2015/08/jpa-hello-world-using-hibernate.html

Database script for the first version:
CREATE DATABASE IF NOT EXISTS javahelps;

CREATE  TABLE javahelps.student ( 
student_id INT NOT NULL ,
student_name VARCHAR(45) NOT NULL ,
student_age INT NOT NULL ,
PRIMARY KEY (student_id) );

2 methods to run the application :
* clean package pour g�n�rer le jar exc�cutable (config faite dans le pom.xml) puis le lancer avec java -jar
* directement compile exec:java -Dexec.mainClass="com.javahelps.jpa.Main"


To understand automatic schema generation :
http://www.mastertheboss.com/jboss-frameworks/hibernate-jpa/quickstart-tutorials-hibernate-jpa/jpa-21-tutorial


<!-- for JPA, use hibernate-entitymanager instead of hibernate-core --> from official documentation :
http://hibernate.org/orm/downloads/

To avoid this "[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!"
We should update POM with this : 		
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

