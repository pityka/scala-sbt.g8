
val commonsettings = Seq(
  version := "$version$",
  organization := "$organization$",
  scalaVersion := "$scala_version$")

lazy val shared = crossProject.crossType(CrossType.Pure).in(file("shared")).
  settings(commonsettings:_*).
  settings(name:="$name$_shared")
  .settings(
  libraryDependencies ++= Seq(
    "com.lihaoyi" %%% "scalarx" % "0.3.1",
    "com.lihaoyi" %%% "upickle" % "0.4.0"
  ))

lazy val sharedJVM = shared.jvm

lazy val sharedJS = shared.js

lazy val js = project.in(file("js"))
  .settings(commonsettings:_*)
  .settings(name:="$name$_js")
  .settings(libraryDependencies ++=Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.0",
    "com.lihaoyi" %%% "scalatags" % "0.5.5",
    "com.lihaoyi" %%% "utest" % "0.4.3" % "test"
  ))
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(sharedJS)

lazy val jvm = project.in(file("jvm"))
  .settings(commonsettings:_*)
    .settings(name:="$name$_jvm")
  .settings(libraryDependencies+= "org.scalatest" %% "scalatest" % "2.1.5" % "test")
  .dependsOn(sharedJVM,js)

onLoad in Global := (Command.process("project jvm", _: State)) compose (onLoad in Global).value