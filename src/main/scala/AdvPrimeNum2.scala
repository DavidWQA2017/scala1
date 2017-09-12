import scala.collection.mutable

object AdvPrimeNum2 extends App
{
  val minNumb: Int = 0
  val maxNumb: Int = 50000000
  val startTime = System.currentTimeMillis()
  val allNumbers = generateNonPrimeNumbers(maxNumb, minNumb)
  val endTime = System.currentTimeMillis()
  var duration = (endTime - startTime)
  //allNumbers.values.foreach(item => println(item))
  println("the amount of prime numbers are: " + calculateAmountofPrimes(allNumbers))
  duration = (endTime - startTime)
  println("program finished  in " + duration/1000 + " seconds" )
  println("program finished  in " + duration + " milli seconds" )


  def generateNonPrimeNumbers(maxNumb: Int , minNumb: Int): mutable.HashMap[Int , Int] =
  {
    var allPrimeNumbers = new mutable.HashMap[Int, Int]
    allPrimeNumbers += 1 -> 1
    for (i <- 4 to  maxNumb by 2)
    {
      allPrimeNumbers += i -> i
    }


    for (j <- 3 to math.sqrt(maxNumb).toInt by 2; i  <- (j * 2)  to maxNumb by j )
    {
      allPrimeNumbers += i -> i
    }

    //allPrimeNumbers.keys.foreach(key => if(key == 0 || key ==1 ) allPrimeNumbers -= key )
    allPrimeNumbers

  }


  def calculateAmountofPrimes(allPrimeNumebrs: mutable.HashMap[Int, Int]): Int =
  {
    maxNumb - allPrimeNumebrs.size
  }


}
