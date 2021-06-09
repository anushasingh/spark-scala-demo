package app.spark

import app.spark.user.UserReportComponent

trait ReportRegistryComponent {
  this: UserReportComponent =>
  val reportRegistryService: ReportRegistryService

  class ReportRegistryService {
    def runReports(): Unit = {
      userExpenseReportService.generateReport()
      spark.close()
    }
  }

}
