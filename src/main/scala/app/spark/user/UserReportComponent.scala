package app.spark.user

import app.spark.DataFrameComponent

trait UserReportComponent  extends DataFrameComponent{
  this: UserOutputComponent =>

  val userExpenseReportService: UserExpenseReportService

  class UserExpenseReportService {
    def generateReport(): Unit = {

      val transformations = userOutputCollection.buildTransformations
      transformations.show()
      write("user_expense", transformations)
    }
  }
}


