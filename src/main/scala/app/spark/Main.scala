package app.spark

import org.apache.spark.sql.functions.{avg, col, desc}

object Main extends InitSpark {
  def main(args: Array[String]): Unit = {

    import app.spark.ApplicationComponentRegistry._
    reportRegistryService.runReports()
  }
}