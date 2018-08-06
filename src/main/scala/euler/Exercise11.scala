package euler

import scala.io.Source

object Exercise11 extends App {

  type Grid = Map[(Int, Int), Int]

  private val numberLines = Source.fromFile("src/main/resources/ex11.txt").getLines()

  private implicit val grid = numberLines.zipWithIndex.flatMap {
    case (line, row) =>
      line.split(" ").zipWithIndex.map {
        case (num, col) => (col, row) -> num.toInt
      }
  }.toMap


  private def highestProductForPos(pos: (Int, Int)): (Seq[Int], Long) = {

    pos match {
      case (x, y) if x <= 16 && y <= 3 => Seq(downProduct(x, y), downRightProduct(x, y), rightProduct(x, y)).maxBy(_._2)
      case (x, y) if x <= 16 && y <= 16 => Seq(downProduct(x, y), downRightProduct(x, y), rightProduct(x, y), upRightProduct(x, y)).maxBy(_._2)
      case (x, y) if x <= 16 && y > 16 => Seq(rightProduct(x, y), upRightProduct(x, y)).maxBy(_._2)
      case (x, y) if x > 16 && y <= 16 => downProduct(x, y)
      case _ =>
        println(s"Falling through to default for position $pos")
        (Seq(), 0L)
    }

  }

  private def downProduct(row: Int, col: Int)(implicit grid: Grid): (Seq[Int], Long) = {
    val numbers = Seq(grid((row, col)), grid((row, col + 1)), grid((row, col + 2)), grid((row, col + 3)))
    (numbers, numbers.map(_.toLong).product)
  }

  private def downRightProduct(row: Int, col: Int)(implicit grid: Grid): (Seq[Int], Long) = {
    val numbers = Seq(grid((row, col)), grid((row + 1, col + 1)), grid((row + 2, col + 2)), grid((row + 3, col + 3)))
    (numbers, numbers.map(_.toLong).product)
  }

  private def upRightProduct(row: Int, col: Int)(implicit grid: Grid): (Seq[Int], Long) = {
    val numbers = Seq(grid((row, col)), grid((row + 1, col - 1)), grid((row + 2, col - 2)), grid((row + 3, col - 3)))
    (numbers, numbers.map(_.toLong).product)
  }

  private def rightProduct(row: Int, col: Int)(implicit grid: Grid): (Seq[Int], Long) = {
    val numbers = Seq(grid((row, col)), grid((row + 1, col)), grid((row + 2, col)), grid((row + 3, col)))
    (numbers, numbers.map(_.toLong).product)
  }


  val (seq, prod) = grid.keys
    .filter { case (x, y) => x <= 16 && y <= 16 }
    .map(highestProductForPos)
    .maxBy(_._2)

  println(s"Answer is $prod for numbers ${seq.mkString(",")}")

}
