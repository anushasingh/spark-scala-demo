package app.spark.user

import app.spark.DataFrameComponent
import org.apache.spark.sql.DataFrame

trait UserInputComponent extends DataFrameComponent {

  val userInputCollection :UserInputCollection

    class UserInputCollection {
        val getInputDataFrame: DataFrame = {
          val df = read("Users")
          df
        }
    }
}
