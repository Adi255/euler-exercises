package euler

import scala.annotation.tailrec
import scala.io.Source

object Exercise13 extends App {

  private val columns = Source.fromFile("src/main/resources/ex13.txt").getLines()
    //start with units, tens, hundreds etc....
    .map(_.reverse).toList
    //columns to rows
    .transpose
    .map(_.map(_.asDigit))

  @tailrec
  def recurseSum(remainingNums: List[List[Int]], carry: Int, digitsSoFar: List[Int]): List[Int] = {
    remainingNums match {
      case col :: tail =>
        val sum = col.sum + carry
        recurseSum(tail, sum / 10, sum % 10 :: digitsSoFar)
      case Nil => carry :: digitsSoFar
    }
  }

  private val totalDigits = recurseSum(columns, 0, Nil)
  val answer = totalDigits.mkString.take(10)

  println(s"Answer is ${answer.mkString}")

}
