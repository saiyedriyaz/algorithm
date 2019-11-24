object JobTimeFinder {
  def main(args: Array[String]): Unit = {
    println("hello")
    val jobs = Array(
      Job(1, 30, Array(2, 4)),
      Job(2, 10, Array(3)),
      Job(4, 60, Array()),
      Job(3, 20, Array())
    )
    val calculated = calculateJobTime(1, jobs)
    println("calculated=" + calculated)
  }

  def calculateJobTime(id: Int, jobs: Array[Job]): Int = {
    var calculatedTime = 0
    jobs.map(job => {
      if (id == job.id) {
        calculatedTime = calculatedTime + job.jobTime
        if (!job.childJobIDs.isEmpty) {
          job.childJobIDs.map(cId => {
            calculatedTime = calculatedTime + calculateJobTime(cId, jobs)
          })
        }
      }
    })
    calculatedTime
  }

  /*def calculateJobTime(id: Int, jobs: Array[Job]): Int = {
    var calculatedTime = 0
    jobs.map(job => {
      if (id == job.id) {
        calculatedTime = calculatedTime + job.jobTime
        if (!job.childJobIDs.isEmpty) {
          job.childJobIDs.map(cId => {
            calculatedTime = calculatedTime + calculateJobTime(cId, jobs)
          })
        }
      }
    })
    calculatedTime
  }*/
  case class Job(id: Int, jobTime: Int, childJobIDs: Array[Int])

}

