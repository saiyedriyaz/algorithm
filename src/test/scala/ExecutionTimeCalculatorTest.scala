import ExecutionTimeCalculator.{Job, calculateJobTime}
import org.scalatest.FunSuite

class ExecutionTimeCalculatorTest extends FunSuite {

  val testData1: Array[Job] = ExecutionTimeCalculator.getDefaultInput()

  val testData2 = Array(
    Job(1, 30, Array(2)),
    Job(2, 10, Array(2))
  )

  test("ExecutionTimeCalculator.calculateJobTime.1") {
    val calculated = calculateJobTime(1, testData1)
    println("total execution time = " + calculated + " for job id =1")
    assert(calculated == 120)
  }

  test("ExecutionTimeCalculator.calculateJobTime.2") {
    val calculated = calculateJobTime(2, testData1)
    println("total execution time = " + calculated + " for job id =2")
    assert(calculated == 30)
  }

  test("ExecutionTimeCalculator.calculateJobTime.3") {
    val calculated = calculateJobTime(3, testData1)
    println("total execution time = " + calculated + " for job id =3")
    assert(calculated == 20)
  }

  test("ExecutionTimeCalculator.calculateJobTime.4") {
    val calculated = calculateJobTime(4, testData1)
    println("total execution time = " + calculated + " for job id =4")
    assert(calculated == 60)
  }

  test("ExecutionTimeCalculator.calculateJobTime.5") {
    intercept[IllegalArgumentException] {
      calculateJobTime(2, testData2)
    }
  }
}