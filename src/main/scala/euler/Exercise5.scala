package euler

object Exercise5 extends App {

  private val intStream = Stream.from(20, 20)
  private val divisors = Seq(19, 18, 17, 16, 15, 14, 13, 12, 11)
  private val startTime = System.currentTimeMillis()
  private val answer = intStream.find(i => divisors.forall(d => i % d == 0))
  println(s"Answer is ${answer.get} in ${(System.currentTimeMillis() - startTime)/1000.0}s")

}
