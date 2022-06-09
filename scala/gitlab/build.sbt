
scalaVersion := "2.13.8"

organization := "com.assembly"
name := "gitlab"
version := "1.0"


libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"

// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.6.7"
libraryDependencies += "org.springframework.boot" % "spring-boot-configuration-processor" % "2.6.7"

libraryDependencies += "com.softwaremill.sttp.client3" %% "core" % "3.6.2"
libraryDependencies += "com.softwaremill.sttp.client3" %% "circe" % "3.6.2"
libraryDependencies += "com.softwaremill.sttp.client3" %% "json4s" % "3.6.2"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.12"
libraryDependencies += "io.circe" %% "circe-generic" % "0.15.0-M1"
