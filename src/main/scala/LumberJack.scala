import java.util

import LumberJack.currentPiles

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

object LumberJack extends App
{

  var currentPiles = Array.ofDim[Int](3, 3)
  var pileAmount: Array[Int] = Array(1, 2 ,3, 4 , 5 , 6 ,7 ,8 ,9 )
  currentPiles = genrateDisplay(currentPiles, pileAmount)

  currentPiles foreach{
    case firstAryElem =>  firstAryElem foreach{secondAryElem => print(secondAryElem.toString + " ")}
      print('\n')}

  println("")
  var logAmount: Int = 7

  while(logAmount > 0 )
  {
    pileAmount = adjustLogPile(pileAmount, genrateDisplay(currentPiles, pileAmount) , logAmount)
  }
  currentPiles = genrateDisplay(currentPiles, pileAmount)
  currentPiles foreach{case a =>  a foreach{b => print(b.toString + " ")}; print('\n') }


  def adjustLogPile(pileAmount: Array[Int] , currentPiles: Array[Array[Int]] , logAmount: Int): Array[Int] =
  {

      var LogAmount = logAmount
        for (i <- 0 to pileAmount.size - 1) {
          var smallestNum = findsmallestNum(currentPiles)
          if (pileAmount(i) == smallestNum) {
            pileAmount(i) = pileAmount(i) + 1
            LogAmount = LogAmount - 1
            println("the amount of logs is " + LogAmount)
            //check the adjustment for each iteration
            println("numbers found ")
            println(logAmount)
            pileAmount foreach (a => print(a))
            print('\n')
          }
        }
      pileAmount
    }


  def findsmallestNum(currentPiles: Array[Array[Int]]): Int =
  {
    var smallestNum = currentPiles(0)(0)
    for (k <- 0 to currentPiles.size - 1 ; j <- 0 to currentPiles.size - 1 if(currentPiles(k)(j) < smallestNum ) )
    {
          smallestNum = currentPiles(k) (j)
    }
    smallestNum
  }


  def takeInput(): String =
  {
    var input = readLine()
    input
  }

  def genrateDisplay(currentPiles: Array[Array[Int]] , pileAmount: Array[Int]): Array[Array[Int]] =
  {
    for (k <- 0 to currentPiles.size - 1; j <- 0 to currentPiles.size - 1)
    {
        currentPiles(k)(j) = pileAmount((k * currentPiles.size) + j)
    }

    currentPiles
  }

}

//Recursive attempt
/*def adjustLogPile(pileAmount: Array[Int] , currentPiles: Array[Array[Int]] , logAmount: Int): Array[Int] =
{
  var counter = 0
  if (logAmount > 0)
  {
    var smallestNum = findsmallestNum(currentPiles)
    println("current logs are with smallest number " + smallestNum )
    for (i <- 0 to pileAmount.size - 1)
    {
      println("log pile per loop iteration " + (i))
      currentPiles foreach{case a =>  a foreach{b => print(b.toString + " ")}; print('\n') }
      counter= 0
      if (pileAmount(i) == smallestNum && logAmount > 0 )
      {
        pileAmount(i) = pileAmount(i) + 1
        counter = counter + 1
        println("the amount of logs is " + logAmount )
        //check the adjustment for each iteration
        println("numbers found " + counter )
        println(logAmount)
        adjustLogPile(pileAmount, genrateDisplay(currentPiles, pileAmount), logAmount - 1)
      }
    }
    pileAmount


  }

  pileAmount
}
*/