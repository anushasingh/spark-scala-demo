package app.spark.expense

import app.spark.InitSpark
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

trait ExpenseOutputComponent extends InitSpark  {
  this: ExpenseInputComponent =>
  val outputExpenseCollection :OutputExpenseCollection

  class OutputExpenseCollection {
    val getEducationCategoryExpenses: DataFrame = {
      val df = inputExpenseCollection.getInputDataFrame
      df.filter(col("category") === "education")
      df
    }
  }
}
