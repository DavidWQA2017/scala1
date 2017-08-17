import java.util

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

object LumberJack extends App
{

  val grid = takeInput().toInt
  val logAmount = takeInput().toInt
  //var currentPiles: Array[Int][Int][Int]
  //{ (0, 0 , 1) (0, 0 , 1) (0 , 0 , 1) }




  def takeInput(): String =
  {
    var input = readLine()
    input
  }

}
