package euler

object Exercise9 extends App {

  private val maxPossibleC = 1000

  private val squareSums = (for (
    a <- 1 to maxPossibleC;
    b <- 1 to maxPossibleC
  ) yield (a, b, math.sqrt(math.pow(a, 2) + math.pow(b, 2))))
    .filter { case (_, _, c) => math.floor(c) == c }

  val answer = squareSums.find {
    case (a, b, c) => a + b + c == 1000
  } match {
    case Some(ans) => Seq(ans._1, ans._2, ans._3.toInt)
    case None => throw new IllegalStateException("No solution found!")
  }

  println(s"Answer is ${answer.product} for $answer")
}
