import sbt._, Keys._

object CompilerOptions extends AutoPlugin {
  override def trigger = allRequirements
  override lazy val projectSettings = Seq(
      scalacOptions := Seq(
        "-deprecation",
        "-encoding", "UTF-8",
        "-feature",
        "-unchecked",
        "-Xfatal-warnings",
        "-Xfuture",
        "-Ywarn-dead-code",
        "-Ywarn-value-discard"
      ) ++ (
        if (scalaVersion.value.startsWith("2.10")) Nil
        else List("-Ywarn-unused-import", "-Ywarn-numeric-widen")
      ),
      scalacOptions in (Compile, console) := Seq(
      ),
      scalacOptions in (Compile, doc) := Seq(
      )
    )
}
