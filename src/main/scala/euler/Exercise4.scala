package euler

object Exercise4 extends App {

  def isPalindrome(num: Int): Boolean = {
    val digits = num.toString.toCharArray
    digits.zip(digits.reverse).forall(pair => pair._1 == pair._2)
  }

  private val products = for (
    i <- 100 to 999;
    j <- 100 to 999
  ) yield (i, j, i * j)

  val answer = products.filter(t => isPalindrome(t._3)).maxBy(_._3)

  println(s"Answer is ${answer._3} with factors ${answer._1} and ${answer._2}")

}
