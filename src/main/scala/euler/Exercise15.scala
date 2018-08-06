package euler

object Exercise15 extends App {

  //The number of permutations of n objects with n1 identical objects of type 1, n2 identical objects of type 2 and nk identical objects of type k...
  // = n!/n1!*n2!*...nk!

  private val numerator = (1l to 40l).map(_.toDouble).product
  private val denominator = (1l to 20l).map(_.toDouble).product
  val answer = (numerator / math.pow(denominator, 2)).toLong


  println(s"Answer is $answer")
}
