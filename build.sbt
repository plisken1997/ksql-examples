import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.ReleaseStateTransformations._

name := "ksql-examples"

scalafmtOnCompile in ThisBuild := true
scalafmtTestOnCompile in ThisBuild := true

resolvers += Resolver.bintrayRepo("cakesolutions", "maven")

lazy val commonSettings = Seq(
  scalaVersion in ThisBuild := "2.12.2",
  organization in ThisBuild := "net.plsk.ksqlExamples",
  sources in (Compile, doc) := Seq.empty
)

lazy val bd4m = (project in file("."))
  .settings(commonSettings)
  .settings(publish := {})
  .aggregate(kafkaProducer)

val dataGen = (project in file("data"))
  .settings(commonSettings: _*)

val streamGen = (project in file("stream-gen"))
  .settings(commonSettings: _*)

val exConfig = (project in file("config"))
  .settings(commonSettings: _*)

val kafkaProducer = (project in file("kafka-producer"))
  .settings(commonSettings: _*)
  .dependsOn(exConfig, streamGen, dataGen)
