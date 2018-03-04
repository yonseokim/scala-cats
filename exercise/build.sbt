scalaVersion := "2.12.4"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.0"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification"
)

mainClass := Some("ys.ex1_4_6.Runner")
