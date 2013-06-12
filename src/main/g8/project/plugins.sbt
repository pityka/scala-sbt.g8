resolvers += Classpaths.typesafeResolver

resolvers += Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)


addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.0.1")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.2.0")


resolvers += "Private Repo" at "FILLIN"

credentials += {
      val credsFile = (Path.userHome / ".ivy2" / ".credentials")
      if (credsFile.exists) Credentials(credsFile)
      else throw new RuntimeException("now cred found")
    }

addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.6.0-pityu2.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.0.1")

addSbtPlugin("de.djini" % "xsbt-reflect" % "0.0.3")
