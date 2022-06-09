
scalaVersion := "2.13.8"

organization := "com.assembly"
name := "gitlab"
version := "1.0"


libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"

// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.6.7"
libraryDependencies += "org.springframework.boot" % "spring-boot-configuration-processor" % "2.6.7"

libraryDependencies += "com.squareup.retrofit2" % "retrofit" % "2.9.0"
libraryDependencies += "com.squareup.retrofit2" % "converter-gson" % "2.9.0"


