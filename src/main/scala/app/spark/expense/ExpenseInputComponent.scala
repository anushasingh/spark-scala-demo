package app.spark.expense

import app.spark.DataFrameComponent
import org.apache.spark.sql.DataFrame

trait ExpenseInputComponent extends DataFrameComponent {

  val inputExpenseCollection :InputExpenseCollection

    class InputExpenseCollection {
        val getInputDataFrame: DataFrame = {
          val df = read("Expense")
          df
        }
    }
}
