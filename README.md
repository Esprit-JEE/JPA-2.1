# JPA-2.1

http://www.javahelps.com/2015/08/jpa-hello-world-using-hibernate.html

CREATE DATABASE IF NOT EXISTS javahelps;

CREATE  TABLE javahelps.student ( 
student_id INT NOT NULL ,
student_name VARCHAR(45) NOT NULL ,
student_age INT NOT NULL ,
PRIMARY KEY (student_id) );

2 methodes pour lancer le programme :
* clean package pour générer le jar excécutable (config faite dans le pom.xml) puis le lancer avec java -jar
* directement compile exec:java -Dexec.mainClass="com.javahelps.jpa.Main"


Pour comprendre la génération automatique des tables a partir des entities:
http://www.mastertheboss.com/jboss-frameworks/hibernate-jpa/quickstart-tutorials-hibernate-jpa/jpa-21-tutorial


Cette remarque <!-- for JPA, use hibernate-entitymanager instead of hibernate-core --> se trouve dans la doc officiel :
http://hibernate.org/orm/downloads/
