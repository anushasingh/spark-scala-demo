package app.spark

import org.apache.spark.sql.{DataFrame, SaveMode}


trait DataFrameComponent extends InitSpark {
  def read(tableName: String): DataFrame = {
    spark.read.jdbc(jdbc_url, tableName, connectionProperties).toDF()
  }

  def write(tableName: String, df: DataFrame): Unit = {
    df.write.mode(SaveMode.Overwrite).jdbc(jdbc_url, tableName, connectionProperties)
  }
}