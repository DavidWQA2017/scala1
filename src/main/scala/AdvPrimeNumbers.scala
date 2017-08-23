import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object AdvPrimeNumbers extends App
{
    val minNumb: Int = 0
    val maxNumb: Int = 2000000
    var startTime = System.currentTimeMillis()
    var allNumbers = generateNumbers(maxNumb, minNumb)
    var endTime = System.currentTimeMillis()
    var duration = (endTime - startTime)
    startTime = System.currentTimeMillis()
    println("program finished  in " + duration/1000 + " seconds" )
    //allNumbers.values.foreach(item => println(item))
    allNumbers =  removeNonPrimeNumbers(allNumbers)
    endTime = System.currentTimeMillis()
    //allNumbers.values.foreach(item => println("prime number" + item))
    println("the amount of prime numbers are: " + calculateAmountofPrimes(allNumbers))
    duration = (endTime - startTime)
    println("program finished  in " + duration/1000 + " seconds" )
    println("program finished  in " + duration + " milli seconds" )


    def generateNumbers(maxNumb: Int , minNumb: Int): mutable.HashMap[Int , Int] =
    {
      var numberArrayBuffer = new mutable.HashMap[Int, Int]
      numberArrayBuffer -= 1
      for (i <- minNumb to maxNumb )
      {
        numberArrayBuffer += (i -> i)
      }
      numberArrayBuffer
    }

    def removeNonPrimeNumbers(primeNumbers: mutable.HashMap[Int, Int]): mutable.HashMap[Int, Int] =
    {
      var allPrimeNumbers = primeNumbers
      for (i <- 4 to  maxNumb by 2)
      {
        allPrimeNumbers -= i
      }

      for (j <- 3 to math.sqrt(maxNumb).toInt by 2; i  <- (j * 2)  to maxNumb by j )
      {
            allPrimeNumbers -= i
      }

      allPrimeNumbers -= 0
      allPrimeNumbers -= 1
      //allPrimeNumbers.keys.foreach(key => if(key == 0 || key ==1 ) allPrimeNumbers -= key )
      allPrimeNumbers
    }

    def calculateAmountofPrimes(allPrimeNumebrs: mutable.HashMap[Int, Int]): Int =
    {
      allPrimeNumebrs.size
    }
}
