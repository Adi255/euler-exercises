package euler

import scala.annotation.tailrec

object Exercise12 extends App {

  def factorCount(newTotal: Int): Int = {
    (for(i <- 1 to math.sqrt(newTotal).floor.toInt if newTotal % i == 0) yield 2).sum
  }

  @tailrec
  def triangleRecurse(pos: Int, total: Int): Int = {
    val newTotal = pos + total
    val numFactors = factorCount(newTotal)
    if(numFactors >= 500)
      newTotal
    else
      triangleRecurse(pos + 1, newTotal)
  }

//  val triangleNumStream = Stream.from(1).map(i => (i to 1 by -1).sum)
//
//  triangleNumStream.take(5).foreach(println)

  val answer = triangleRecurse(2, 1)

  println(s"Answer is $answer")

}
