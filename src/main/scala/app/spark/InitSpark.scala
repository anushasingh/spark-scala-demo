package app.spark

import java.util.Properties

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

import com.databricks.dbutils_v1.{DBUtilsV1, DBUtilsHolder}

trait InitSpark {

  type DBUtils = DBUtilsV1

  val dbutils: DBUtils = DBUtilsHolder.dbutils

  val spark: SparkSession = SparkSession.builder()
    .appName("Spark App")
    .getOrCreate()

  val sc: SparkContext = spark.sparkContext
  val sqlContext: SQLContext = spark.sqlContext

  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")

  val password: String = dbutils.secrets.get("","")
  val username: String = dbutils.secrets.get("","")

  val connectionProperties = new Properties
  connectionProperties.put("user", username)
  connectionProperties.put("password", password)
  connectionProperties.put("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver")

  val jdbc_url = "jdbc:sqlserver://{};database={}"

  def close(): Unit = {
    spark.close()
  }

}
