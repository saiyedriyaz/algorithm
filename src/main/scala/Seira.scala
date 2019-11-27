object Seira {

  def main(args: Array[String]): Unit = {
    println(shortestPalindrome("aacecaaa"))
  }

  def shortestPalindrome(s: String): Int = {
    // Write your code here
    var ss = s
    var cnt = 0
    var flag = 0
    while (ss.length() > 0 && flag == 0) {
      // if string becomes palindrome then break
      if (isPalindrome(s)) {
        flag = 1;
      } else {
        cnt = cnt + 1;
        // erase the last element of the string
        ss = ss.substring(0, ss.length() - 1);
        //s.erase(s.begin() + s.length() - 1);
      }
    }

    // print the number of insertion at front
    if (flag == 1) {
      System.out.println(cnt);
    }
    cnt
  }

  def isPalindrome(s: String): Boolean = {
    println(s.reverse)
    s.trim.reverse.equalsIgnoreCase(s.trim)
  }
}
