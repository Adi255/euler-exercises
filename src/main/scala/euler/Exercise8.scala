package euler

import scala.io.Source

object Exercise8 extends App {

  val digits = Source.fromFile("src/main/resources/ex8.txt").getLines().mkString("").map(_.asDigit.toLong)

  assert(digits.length == 1000)

  val answer = digits.iterator.sliding(13).maxBy(seq => seq.product)

  println(s"Answer is ${answer.product} for sequence ${answer.mkString(",")}")

}
