lazy val commonSettings = Seq(
  organization := "$organization$",
  scalaVersion := "$scala_version$",
  version      := "$version$"
) ++ reformatOnCompileSettings

lazy val root = (project in file(".")).
  settings(commonSettings:_*).
  settings(
    name := "$name$",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "$scalatest_version$" % "test")
  )
