name := "Scala-JMS"

version := "0.1"

organization := "marianoguerra"

scalaVersion := "2.9.2"

seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

mainClass in oneJar := Some("org.marianoguerra.jms.TopicExample")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "Maven2 Repository" at "http://repo2.maven.org/maven2/"

resolvers += "Apache Maven2 Repository" at "http://repo1.maven.org/maven2/"

libraryDependencies ++= Seq(
  "org.jboss.spec.javax.jms" % "jboss-jms-api_1.1_spec" % "1.0.1.Final",
  "org.jboss" % "jboss-common-core" % "2.2.20.GA",
  "org.jboss.netty" % "netty" % "3.2.7.Final",
  "jboss" % "jnp-client" % "4.2.2.GA",
  "org.hornetq" % "hornetq-jms" % "2.2.21.Final",
  "org.hornetq" % "hornetq-core" % "2.2.21.Final")
