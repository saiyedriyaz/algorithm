

object Solution {

  // Complete the findNumber function below.
  def findNumber(arr: Array[Int], k: Int): String = {
    val filtered = arr.filter(num => num == k);
    if (!filtered.isEmpty) {
      "YES"
    }
    else {
      "NO"
    }
  }

  /*def oddNumbers(l: Int, r: Int): Array[Int] = {
    var fruits = Array[Int]()
    for {
      i <- 1 to 3
      if (i % 2 = 1)println(i)
    }
    // print(data)
      fruits
  }*/

  def main(args: Array[String]) {
    //println(findNumber(Array(1, 2, 3, 4), 7))
    //println(oddNumbers(1, 4))
  }
}