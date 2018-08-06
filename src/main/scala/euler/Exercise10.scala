package euler

object Exercise10 extends App {

  // Input: an integer n > 1.
  //
  // Let A be an array of Boolean values, indexed by integers 2 to n,
  // initially all set to true.
  //
  // for i = 2, 3, 4, ..., not exceeding √n:
  //   if A[i] is true:
  //     for j = i^2, i^2+i, i^2+2i, i^2+3i, ..., not exceeding n:
  //       A[j] := false.
  //
  // Output: all i such that A[i] is true.
  //

  def getPrimes(max: Int): Seq[Long] = {
    val flags = (2 to max).map(_ => true).toArray
    val nums: Seq[Int] = 2 to math.sqrt(max).floor.toInt
    nums.foreach {
      i =>
        if(flags(i - 2)){
          (i*i to max by i).foreach(j => flags(j - 2) = false)
        }
    }
    flags.zipWithIndex.filter(_._1 == true).map(t => t._2 + 2l)
  }

  val primes = getPrimes(2000000)
  val answer = primes.sum

  println(s"Answer is $answer")

}
