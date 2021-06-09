name := "spark-scala-demo"

version := "0.1"

scalaVersion := "2.12.12"

val sparkVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
   "com.microsoft.sqlserver" % "mssql-jdbc" % "7.2.1.jre8"
)