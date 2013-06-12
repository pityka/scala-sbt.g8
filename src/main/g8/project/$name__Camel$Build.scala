import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtStartScript


object $name;format="Camel"$Build extends Build {

  lazy val $name;format="camel"$ = Project(
    id = "$name;format="norm"$",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "$name$",
      organization := "$organization$",
      version := "$version$",
      scalaVersion := "$scala_version$",
      
      scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-language:implicitConversions","-language:postfixOps","-language:reflectiveCalls","-language:existentials"),

      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "$scalatest_version$" % "test" cross CrossVersion.binaryMapped {
            case "2.9.0" => "2.9.0" // remember that pre-2.10, binary=full
            case "2.9.1" => "2.9.0" // remember that pre-2.10, binary=full
            case "2.9.2" => "2.9.0" // remember that pre-2.10, binary=full
            case "2.10" => "2.10" // useful if a%b was released with the old style
            case "2.10.0" => "2.10"
            case "2.10.1" => "2.10"
            case "2.10.2" => "2.10"
          }
        ),

      resolvers  ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
)
      // add other settings here
    ) ++ seq(SbtStartScript.startScriptForClassesSettings: _*) ++ seq(SbtStartScript.runscriptScriptForClassesSettings: _*)  ++seq(SbtStartScript.runappScriptForClassesSettings: _*) 
  )
}
