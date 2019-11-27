import org.scalatest.FunSuite

class WorkBreakSolutionTest extends FunSuite {

  test("WorkBreakSolutionTest.true") {
    val wordList = "what,an,nice,day".split(",")
    val searchString = "what"
    val contains = WordBreakSolution.wordBreak(wordList, searchString)
    assert(contains == true)
  }

  test("WorkBreakSolutionTest.false") {
    val wordList = "what,an,nice,day".split(",")
    val searchString = "dawhaty"
    val contains = WordBreakSolution.wordBreak(wordList, searchString)
    assert(contains == false)
  }

}