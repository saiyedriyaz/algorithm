import scala.collection.mutable._

object Solution {

  def main(args: Array[String]) {
    //println(findNumber(Array(1, 2, 3, 4), 3))
    oddNumbers(3, 90).foreach(println)
  }

  // Complete the findNumber function below.
  def findNumber(arr: Array[Int], k: Int): String = {
    if (arr.exists(a => a == k)) "YES" else "NO"
  }

  def oddNumbers(l: Int, r: Int): Array[Int] = {
    val results = new ArrayBuffer[Int]
    for (number <- l to r) {
      if (number % 2 == 1) {
        results += number
      }
    }
    results.toArray
  }

}