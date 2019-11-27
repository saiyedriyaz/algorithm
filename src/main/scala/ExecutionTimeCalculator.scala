
/**
 * / Given a job struct definition below write a function that takes 2 inputs:
 * // * ID of a job to run
 * // * a slice/array/list of known job descriptions
 * // and return a total execution time of job with ID=ID and all of its
 * children
 * // recursively.
 * //
 * // We can assume that there are no cycles in the dependency graph and job
 * // descriptions in the slice/array/list are unique i.e. there are no
 * duplicates.
 * //
 * // Add a couple of tests to prove your solution.
 * // Use whatever language you feel most comfortable with but please include
 * // instructions on how to compile it and run the tests.
 * //
 * // For the exemplar 'jobs' slice below:
 * // * given ID=4 the function should return 60 - just a single job's duration
 * // without any dependencies
 * // * given ID=2 the function should return 30 - duration of jobs 2 and 3
 * // * given ID=1 the function should return 120 - duration of jobs 1, 2, 3
 * and 4
 *
 * type Job struct {
 * ID int
 * jobTime int
 * childJobIDs []int
 * }
 *
 * var jobs = []Job{
 * Job{1, 30, []int{2, 4}},
 * Job{2, 10, []int{3}},
 * Job{4, 60, []int{}},
 * Job{3, 20, []int{}},
 * }
 *
 */
object ExecutionTimeCalculator {
  def main(args: Array[String]): Unit = {
    val jobId = if (args != null && !args.isEmpty) args(0).toInt else 1
    val jobs = getDefaultInput()
    try {
      val calculated = calculateJobTime(jobId, jobs)
      println("total execution time = " + calculated + " for job id =" + jobId)
    } catch {
      case s: NumberFormatException => println("Invalid Id provided.")
    }
  }

  case class Job(id: Int, jobTime: Int, childJobIDs: Array[Int])

  def calculateJobTime(id: Int, jobs: Array[Job]): Int = {
    var calculatedTime = 0
    jobs.map(job => {
      if (id == job.id) {
        calculatedTime = calculatedTime + job.jobTime
        if (!job.childJobIDs.isEmpty) {
          job.childJobIDs.map(cId => {
            if (id == cId) {
              throw new IllegalArgumentException("Cyclic Job Found")
            }
            calculatedTime = calculatedTime + calculateJobTime(cId, jobs)
          })
        }
      }
    })
    calculatedTime
  }

  def getDefaultInput(): Array[Job] = {
    Array(
      Job(1, 30, Array(2, 4)),
      Job(2, 10, Array(3)),
      Job(4, 60, Array()),
      Job(3, 20, Array())
    )
  }
}