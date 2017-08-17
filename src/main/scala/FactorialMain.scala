import scala.io.StdIn.readLine

object FactorialMain extends App
{
  println(takeInput()  + " " + findFactorial(takeInput()))





  def takeInput(): String = {
    var input = readLine()
    input
  }

  def findFactorial(input: String ): String =
  {
    var inputInt: Double = input.toInt
    println(inputInt)
    var counter = 1
    var result = ""

    while (inputInt > 1  )
    {

      counter = counter + 1
      println(inputInt)
      inputInt = inputInt / counter

    }

    if(inputInt == 1)
      result = ("= "+ counter + "!")
    else
      result = "NONE"

    result

  }
    /*
    for (i <- (1 to inputInt))
    {
      var remainder = inputInt % i
      println(remainder)
      if(remainder == 0)
      {
        inputInt = inputInt/i
        println(inputInt)
        counter = counter + 1
      }
      else
      {
        result = "NONE"
      }
    }

    if (inputInt == 1)
    {

    }
    else if (result == "NONE")
    {
      result = "NONE"
    }
    result
  }
  */


}
