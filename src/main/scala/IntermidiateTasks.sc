def blackJackExercise(input1: Int, input2: Int): Unit = (input1 ,input2) match
{
  case(input1 , input2) if(input1 >= 21 && input2 >= 21) => println(0)
  case(input1 , input2) if((21 - input1) < (21 - input2) ) => println(input1)
  case(input1, input2) if((21 - input1) > (21 - input2) ) => println(input2)
}

blackJackExercise(18,20)

def uniqueSum(input1: Int , input2: Int, input3: Int): Int =
{
  var sum= 0
  val numbersToSum = List(input1, input2, input3)
  numbersToSum.distinct.foreach(sum +=_)
  sum
}
uniqueSum(1,2,2)

def tooHot(temp: Int, isSummer: Boolean): Boolean = (temp, isSummer)match
{
  case (temp, isSummer) if(isSummer == false &&  60 <= temp && temp <= 90) => true
  case (temp , isSummer) if(isSummer == true && 60 <= temp && temp <= 100) => true
  case (temp, isSummer)=> false

}

println(tooHot(32, false))