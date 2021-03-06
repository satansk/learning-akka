name := "akkademy-db"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.12",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.12" % Test,
  "org.scalactic"     %% "scalactic" % "3.0.5",
  "org.scalatest"     %% "scalatest" % "3.0.5" % "test",

  "junit"             % "junit" % "4.12" % "test",
  "com.novocode"      % "junit-interface" % "0.11" % "test"
)