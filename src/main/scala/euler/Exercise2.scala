package euler

import scala.annotation.tailrec

object Exercise2 extends App {

  private val fourMillion = 4000000

  @tailrec
  def fibSum(previousPrevious: Int, previous: Int, sum: Int): Int = {
    val next = previous + previousPrevious
    if(next > fourMillion)
      sum
    else {
      val newSum = if(next % 2 == 0) next + sum else sum
      fibSum(previous, next, newSum)
    }
  }

  private val answer = fibSum(0, 1, 0)
  println(s"Answer is $answer") //4613732

}
