import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Merchant {
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    val groups = ar.groupBy(_.intValue())
    var pairs = 0
    for ((k, v) <- groups) {
      if (v.length > 0) {
        println("Key=" + k + " values length=" + v.length)
        if (v.length % 2 == 0) {
          pairs = pairs + v.length / 2
        }
        else if (v.length - 1 >= 2) {
          pairs = pairs + (v.length - 1) / 2
        }
      }
    }
    pairs
  }
  def testMe(n: Int, ar: Array[Int]): Unit = {
    //val list = List(15, 10, 5, 8, 20, 12)
    val x = ar.groupBy(_ > 2)
    val y = ar.partition( _ % 2 ==0 )
    println(x(true))// + ", "+ x(false).isDefinedAt(1))
    y._1.foreach(println)
    println("--")
    y._2.foreach(println)
  }

  def main(args: Array[String]) {
    /*val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    println(n)
    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    ar.foreach(print)*/
    var result = testMe(2, Array(11,21,11,31,51,301,301,41))
    //result = sockMerchant(2, Array(10, 20, 20, 10, 10 ,30 ,50 ,10 ,20))

    //printWriter.println(result)

    //printWriter.close()
  }
}
