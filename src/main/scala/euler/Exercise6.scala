package euler

object Exercise6 extends App {

  //Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

  val numbers = 1 to 100
  private val sumOfSquares = numbers.map(i => math.pow(i, 2).toLong).sum
  private val squareOfSum = math.pow(numbers.sum, 2).toLong
  val answer = squareOfSum - sumOfSquares

  println(s"Answer is $answer")

}
