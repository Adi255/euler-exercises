package euler

object Exercise1 extends App {

  private val intStream = (1 until 1000).toStream
  private val answer = intStream.filter(i => i % 3 == 0 || i % 5 == 0).sum

  println(s"The answer is $answer") //233168
}

