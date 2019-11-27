object LongestPalindrome {
  private var longest = ""

  def main(args: Array[String]): Unit = {
    println(">>" + longestPalindrome("acdtopspotsdf")) // acdtopspotsdf forgeeksskeegfor
  }

  def longestPalindrome(s: String): String = {
    if (s.length == 0) return ""
    var start = 0
    var end = 0
    var i = 0
    while ( {
      i < s.length
    }) {
      val len1 = helper(s, i, i)
      val len2 = helper(s, i, i + 1)
      val final_len = Math.max(len1, len2)
      if (final_len > end - start) {
        start = i - (final_len - 1) / 2
        end = i + final_len / 2
      }

      {
        i += 1;
        i - 1
      }
    }
    s.substring(start, end + 1)
  }

  def helper(s: String, left: Int, right: Int): Int = {
    var l = left
    var r = right
    while ( {
      l >= 0 && r < s.length && s.charAt(l) == s.charAt(r)
    }) {
      l -= 1
      r += 1
    }
    r - l - 1
  }

  def longestPalindrome2(s: String): String = {
    if (s != null && s.length > 0) {
      var i = 0
      while ( {
        i < s.length
      }) {
        var j = s.length
        while ( {
          j > i
        }) {
          val toCheck = s.substring(i, j)
          if (isPelindrom(toCheck) && toCheck.length > longest.length) longest = toCheck

          {
            j -= 1;
            j + 1
          }
        }

        {
          i += 1;
          i - 1
        }
      }
    }
    longest
  }

  private def isPelindrom(s: String): Boolean = {
    if (s != null) {
      val b = new StringBuilder(s)
      return s == b.reverse.toString
    }
    false
  }
}