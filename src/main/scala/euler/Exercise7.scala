package euler

object Exercise7 extends App {

  //What is the 10 001st prime number?


  private def primeStream(s: Stream[Int]): Stream[Int] =
    Stream.cons(s.head, primeStream(s.tail filter {
      _ % s.head != 0
    }))

  private val primes = primeStream(Stream.from(2))
  val startTime = System.currentTimeMillis()

  //drop causes stack overflow error
  private val answer = primes.zipWithIndex.drop(10000).head._1

  println(s"Answer is $answer in ${System.currentTimeMillis - startTime} ms")

}
