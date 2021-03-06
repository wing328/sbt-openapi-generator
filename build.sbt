enablePlugins(SbtPlugin)

organization := "org.upstartcommerce"
name := "sbt-openapi-generator"
version := "0.1-SNAPSHOT"

licenses in ThisBuild += ("Apache-2.0", url("https://bintray.com/upstartcommerce"))

scalaVersion := "2.12.8"

sbtPlugin := true
logLevel := Level.Warn

val openapiGeneratorCli = "org.openapitools" % "openapi-generator-cli" % "4.1.0"
libraryDependencies ++= Seq(openapiGeneratorCli)

scriptedLaunchOpts += ("-Dplugin.version=" + version.value)
scriptedBufferLog := false

wartremoverWarnings ++= Seq(Wart.TraversableOps, Wart.Var, Wart.While)
wartremoverErrors ++= Seq(
  Wart.ArrayEquals,
  Wart.AsInstanceOf,
  Wart.EitherProjectionPartial,
  Wart.ExplicitImplicitTypes,
  Wart.FinalCaseClass,
  Wart.IsInstanceOf,
  Wart.LeakingSealed,
  Wart.Null,
  Wart.OptionPartial,
  Wart.PublicInference,
  Wart.Return,
  Wart.StringPlusAny
)

resolvers in Global += Resolver.url(
  "upstartcommerce",
  url("https://upstartcommerce.bintray.com/nochannel")
)(Resolver.ivyStylePatterns)

bintrayOmitLicense := true
bintrayOrganization := Some("upstartcommerce")
bintrayRepository := "generic"
bintrayReleaseOnPublish in ThisBuild := false
publishMavenStyle := false
