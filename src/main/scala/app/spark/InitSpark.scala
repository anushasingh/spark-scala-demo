package app.spark

import java.util.Properties

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}


trait InitSpark {
  val spark: SparkSession = SparkSession.builder()
    .appName("Spark App")
    .master("local[*]")
    .getOrCreate()

  val sc: SparkContext = spark.sparkContext
  val sqlContext: SQLContext = spark.sqlContext

  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")

  val connectionProperties = new Properties
  connectionProperties.put("user", "sa")
  connectionProperties.put("password", "password")
  connectionProperties.put("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver")

  val jdbc_url = "jdbc:sqlserver://localhost:1433;database=db2"

  def close(): Unit = {
    spark.close()
  }

}
