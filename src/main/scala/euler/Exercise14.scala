package euler

import scala.annotation.tailrec
import scala.collection.mutable

object Exercise14 extends App {

  private val searchRange = 1l to 1000000l
  private val chainMap = mutable.Map[Long, Long]()

  def collatzChain(num: Long): Long = {
    @tailrec
    def recurse(current: Long, chain: List[Long]): Long = {
      current match {
        case 1l =>
          chain.length
        case i =>
          val next = if (i % 2 == 0) i / 2l else 3l * i + 1l
          chainMap.get(next) match {
            case Some(existingChainLength) =>
              chain.zipWithIndex.foreach{case (e, idx) => chainMap.put(e, existingChainLength + idx + 1)}
              chain.length + existingChainLength
            case None => recurse(next, next +: chain)
          }
      }
    }

    if(!chainMap.contains(num)) {
      val len = recurse(num, List(num))
      chainMap.put(num, len)
      len
    }
    else chainMap(num)
  }

  val start = System.currentTimeMillis()
  private val chainLengths = searchRange.map(i => (i, collatzChain(i)))
  val (answer, answerChain) =  chainLengths.maxBy(_._2)

  println(s"Answer is $answer with chain of length $answerChain in ${System.currentTimeMillis() - start} ms")
}
