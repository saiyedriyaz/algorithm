/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 */

object ShortestPelindrome {

  def main(args: Array[String]): Unit = {
    println(shortestPalindrome("aacecaaa"))
  }

  // TODO implement
  def shortestPalindrome(s: String): Int = {
    // Write your code here
    isPalindrome(s)
    0
  }

  def isPalindrome(s: String): Boolean = {
    println(s.reverse)
    s.trim.reverse.equalsIgnoreCase(s.trim)
  }
}
