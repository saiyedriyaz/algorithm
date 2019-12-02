/**
 * /**
 * # # # # # # # # /TASK 1. Given a non-empty string s and a list wordList containing a list of non-empty tokens, determine if s can be represented as a
 * concatenation of tokens from the list (where each token may be used several times). You may assume the dictionary does not contain duplicate tokens.
 * # # # # # # #
 * # # # # #
 * # # # # #
 * # # # # #
 * # # # # # # # #
 * # # # # # # # # s = "whataniceday";
 * # # # # # # # # wordList = ["a", "what", "an", "nice", "day"];
 * # # # # # # # # -> true
 * # # # # # # # #
 * # # # # # # # # s = "dawhaty",
 * # # # # # # # # wordList = ["a", "what", "an", "nice", "day"].
 * # # # # # # # # -> false
 * # # # # # # # #
 * # # # # # # # # s = "abc",
 * # # # # # # # # wordList = ["a", "ab", "bc"].
 * # # # # # # # # -> true
 */
 */
object WordBreakSolution {

  /**
   * arg[0] = comma separated word list for dictionary e.g. what,an,nice,day
   * arg[1] = word to be searched against dictionary e.g. whataniceday
   *
   * @param args program arguments
   */
  def main(args: Array[String]): Unit = {
    var searchString = ""
    var wordBreakSolution: Array[String] = Array.empty
    if (args != null && args.length == 2) {
      wordBreakSolution = args(0).split(",")
      searchString = args(1)
    }
    else { // run with sample/default test case
      wordBreakSolution = "what,an,nice,day".split(",")
      searchString = "what"
    }
    val found = wordBreak(wordBreakSolution, searchString)
    println("found all=" + found)
  }

  /**
   * Returns true if the word can be represented as token that each token is part of dictionary
   *
   * @param word work to be searched against the dictionary
   * @return true or false
   */
  def wordBreak(wordList: Array[String], word: String): Boolean = {
    if (word.length == 0) return true
    var i = 1
    while ( {
      i <= word.length
    }) {
      if (wordList.contains(word.substring(0, i)) && wordBreak(wordList, word.substring(i))) return true

      {
        i += 1;
        i - 1
      }
    }
    false
  }

}