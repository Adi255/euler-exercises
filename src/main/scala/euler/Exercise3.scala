package euler

object Exercise3 extends App {

  private def factorize(num: Long): Long = {
    def recurse(x: Long, a: Long): Long = {
      (a * a < x, x % a) match {
        case (true, 0l) => recurse(x / a, a)
        case (true, _) => recurse(x, a + 1)
        case (false, _) => x
      }
    }
    recurse(num, 2)
  }

  private val input = 600851475143L
  private val answer = factorize(input)
  println(s"Answer is $answer")

}
