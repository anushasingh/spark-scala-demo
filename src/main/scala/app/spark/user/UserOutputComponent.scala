package app.spark.user

import app.spark.InitSpark
import app.spark.expense.ExpenseOutputComponent
import org.apache.spark.sql.{DataFrame, Dataset, Row}
import org.apache.spark.sql.functions._


trait UserOutputComponent extends InitSpark {
  this: UserInputComponent with ExpenseOutputComponent =>
  val userOutputCollection: UserOutputCollection

  class UserOutputCollection {
    def buildTransformations: DataFrame = {
      val userDF = userInputCollection.getInputDataFrame
      val expenseDF = outputExpenseCollection.getEducationCategoryExpenses

      val df = userDF
        .join(expenseDF, userDF.col("id") === expenseDF.col("userId"))
        .groupBy("city").agg(avg("amount").alias("avgAmount")).orderBy(desc("avgAmount"))
      df
    }
  }

}
