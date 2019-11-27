import org.scalatest.FunSuite

class LongestPalindromeTest extends FunSuite {

  test("LongestPalindromeTest.acdtopspotsdf") {
    val contains = LongestPalindrome.longestPalindrome("acdtopspotsdf")
    assert(contains.equals("topspot"))
  }

  test("LongestPalindromeTest.forgeeksskeegfor") {
    val contains = LongestPalindrome.longestPalindrome("forgeeksskeegfor")
    assert(contains.equals("geeksskeeg"))
  }

}