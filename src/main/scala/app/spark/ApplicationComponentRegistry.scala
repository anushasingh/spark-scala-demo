package app.spark

import app.spark.expense.{ExpenseInputComponent, ExpenseOutputComponent}
import app.spark.user.{UserInputComponent, UserOutputComponent, UserReportComponent}

object ApplicationComponentRegistry extends UserInputComponent
  with UserOutputComponent
  with UserReportComponent
  with ExpenseInputComponent
  with ExpenseOutputComponent
  with ReportRegistryComponent {
  override val inputExpenseCollection: ApplicationComponentRegistry.InputExpenseCollection = new InputExpenseCollection()
  override val userInputCollection: ApplicationComponentRegistry.UserInputCollection = new UserInputCollection()

  override val userOutputCollection: ApplicationComponentRegistry.UserOutputCollection = new UserOutputCollection()
  override val outputExpenseCollection: ApplicationComponentRegistry.OutputExpenseCollection = new OutputExpenseCollection()

  override val userExpenseReportService: ApplicationComponentRegistry.UserExpenseReportService = new UserExpenseReportService()

  override val reportRegistryService: ApplicationComponentRegistry.ReportRegistryService = new ReportRegistryService()
}
