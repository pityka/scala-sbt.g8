import AssemblyKeys._ 
import eu.diversit.sbt.plugin.WebDavPlugin._


scalariformSettings

seq(sbtassembly.Plugin.assemblySettings: _*)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case x if x.matches("META-INF/*") => MergeStrategy.first
    case x => old(x)
  }
  }

seq(WebDav.globalSettings : _*)
