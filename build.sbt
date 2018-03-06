name := "TCS-test"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  //ScalaTest
  "org.scalactic" %% "scalactic" % "3.0.4",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "junit" % "junit" % "4.10" % Test,

)