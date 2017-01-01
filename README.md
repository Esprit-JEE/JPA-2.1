# JPA-2.1 Skeleton

============prerequisites==============
*Configure eclipse to use JDK and not JRE
*Set your environment variable JAVA_HOME to JDK 8 path (JDK not JRE)


========Try the application==============
To try this application, you can:
* <mvn clean compile exec:java> to run directly the application (exec-maven-plugin)
OR
* <mvn clean package> to generate executable jar (maven-assembly-plugin), then run the application using <java -jar>
OR
* <clean eclipse:eclipse compile exec:java> to be able to debug using eclipse


================== JPA ===========================
*Hibernate logging is important to read generated SQL queries :
http://www.thoughts-on-java.org/hibernate-logging-guide/
http://memorynotfound.com/configure-hibernate-logging-slf4j-log4j2/

*Application logging, slf4j is recommended :
http://howtodoinjava.com/log4j/slf4j-vs-log4j-which-one-is-better/

*Reference used in the first version :
http://www.javahelps.com/2015/08/jpa-hello-world-using-hibernate.html

* To understand automatic schema generation :
http://www.mastertheboss.com/jboss-frameworks/hibernate-jpa/quickstart-tutorials-hibernate-jpa/jpa-21-tutorial

* <!-- for JPA, use hibernate-entitymanager instead of hibernate-core --> from official documentation :
http://hibernate.org/orm/downloads/

*Hibernate VS JPA and conf files:
If you are using Hibernate's proprietary API, you'll need the hibernate.cfg.xml. 
If you are using JPA i.e. Hibernate EntityManager, you'll need the persistence.xml.
hibernate.cfg.xml is for Hibernate; persistence.xml is for JPA.
If you do Hibernate without JPA, you don't need persistence.xml.
If you do JPA, you have to have a provider implementation, which means Hibernate, EclipseLink, etc...


================ TIPS =============================
*Version is still SNAPSHOT ==> development in progress (https://docs.oracle.com/middleware/1212/core/MAVEN/maven_version.htm#MAVEN400)

* To avoid this "[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!"
We should update POM with this : 		
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

*To understand aspectJ :
http://www.darpandodiya.com/code/aspectj-notes-tutorial-example/

*-Xlint:all to pass to java compiler
//Enable all recommended warnings. In this release, enabling all available warnings is recommended.
http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html
http://www.javaworld.com/article/2073587/javac-s--xlint-options.html

