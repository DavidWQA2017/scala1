import scala.collection.mutable.ArrayBuffer

object AdvPrimeNumbers extends App
{
    val maxNumb: Int = 30
    var allNumbers = generateNumbers(maxNumb)
    allNumbers.foreach(item => println(item))


    def generateNumbers(maxNumb: Int): Map[Int , Int] =
    {
      var numberArrayBuffer: Map[Int , Int] = Map(1 -> 1)
      numberArrayBuffer -= 1
      for (i <- 0 to maxNumb)
      {
        numberArrayBuffer += (i -> i)
      }
      numberArrayBuffer
    }

    def removeNonPrimeNumbers(): ArrayBuffer[Int] =
    {

      primeNumberArrayBuffer
    }
}
