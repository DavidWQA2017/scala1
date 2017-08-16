val test = "blah"
println(test)

def exercise1(): Unit = println("hello world")
exercise1()

var helloWorld = "Hello World"
def exercise2(): Unit = println(helloWorld)
exercise2()


def exercise3(helloWorld: String): String =
{
  var helloWorld = "goodbye world"
  helloWorld
}
println(helloWorld)
println(exercise3(helloWorld))

def exercise4(test4a: Any) = test4a
println(exercise4(2.0))

def exercise5(test5a: Int, test5b: String): String = test5b.substring((test5a - 1), test5b.length)
println(exercise5(3 , "hello"))

def exercise6(test6a: String, test6b: String, test6c: Char , test6d: Char): String =
{
  var newstring = test6a.concat(test6b)
  newstring.replace(test6c,test6d)
}

println(exercise6("ha","llo" ,'a', 'e'))

def exercise7(number1: Int , number2: Int ): Int = number1 + number2
println(exercise7(1, 2))

def exercise8(number1: Int , number2: Int, switch: Boolean ): Int =
{
  if (switch == true)
  exercise7(number1,  number2)
  else
    number1 * number2
}
println(exercise8(1 , 2 , false))

def exercise9(number1: Int , number2: Int, switch: Boolean ): Int =
{
  var number3 = 0
 if (number1 == 0 && number2 == 0)
 {
   number3 = 0
 }
 else if ( number1 == 0 || number2 == 0 )
 {
   number3 = number1 + number2
 }
 else {
   number3 = exercise8(number1, number2, switch)
 }

  number3
}
println(exercise9(1 , 2 , false))

def exercise10(message: String , Amount: Int): Unit =
{
  for (i <- 0 to (Amount - 1))
  {
    println(message )
  }
}
println(exercise10("hi" , 3))

def exercise11(message: String , amount: Int): Unit =
{
  for (j <- 0 to amount-1)
  {
    var line = ""
    for (i <- 0 to (amount - 1)) {
      line = line + message
    }
    println(line)
  }
}
exercise11("h" , 4)

def exercise12(message1: String, message2: String,  amount: Int): Unit =
{
  for (i <- 0 to amount)
  {
    if (i == 0)
      println(i)
    else if (((i % 3) == 0 )&& (i % 5) == 0)
    println(message1.concat(message2))
    else if ((i % 3 ) == 0 && i != 0)
      println(message1)
    else if((i % 5) == 0 && i != 0)
      println(message2)
    else
      println(i)

  }
}


exercise12("Fizz" ,"Buzz", 15)

def exercise10Recursive(message: String , amount: Int): Unit =
{
 if (amount == 0)
   return
    else
   println(message)
   exercise10Recursive(message , amount = amount - 1)
    return
}

exercise10Recursive("hi", 3)





def exercise12Recursive(message1: String, message2: String,  amount: Int, i: Int): Unit =
{
  if (amount >= 0 )
  {
    if (i == 0)
      println(i)
    else if (((i % 3) == 0 )&& (i % 5) == 0)
      println(message1.concat(message2))
    else if (((i % 3) == 0 )&& (i != 0))
      println(message1)
    else if ((i % 5) == 0 && i != 0)
      println(message2)
    else
      println(i)

    exercise12Recursive(message1, message2, (amount -1), i + 1)
  }
}


var i = 0
exercise12Recursive("Fizz", "Buzz" , 15, i)



//not working
def exercise11Recursive(message: String , amount: Int , counter: Int): Unit =
{
  if(counter > 0)
  {
    exercise11Recursive(message, amount, counter - 1)
    println(message * amount)
  }


}

exercise11Recursive("h", 4 , 4)


def exercise8PatternMatch(number1: Int , number2: Int, switch: Boolean ): Int = (switch) match
{
  case true => exercise7(number1, number2)
  case false => number1 * number2
}

exercise8PatternMatch(2, 3 , false)

def exercise9PatternMatch(number1: Int , number2: Int, switch: Boolean ): Int = (number1 , number2) match
{
  case(number1 , number2)  if(number1 == 0 && number2 ==0) => 0
  case(number1 , number2)  if(number1 == 0 || number2 == 0) => (number1 + number2)
  case(number1, number2) => exercise8PatternMatch(number1, number2 ,switch )

}

exercise9PatternMatch(2 , 1 , false)


def exercise12RecursivePatternMatch(message1: String, message2: String,  amount: Int, i: Int): Unit = (amount) match
{
  case (amount) if (i ==0 && amount > 0 ) => println(i); exercise12Recursive(message1, message2, (amount - 1), i + 1)
  case (amount) if (((i % 3) == 0 )&& (i % 5) == 0 && amount > 0) => println(message1.concat(message2));  exercise12Recursive(message1, message2, (amount - 1), i + 1)
  case (amount) if (((i % 3) == 0 )&& (i != 0) && amount > 0) => println(message1); exercise12Recursive(message1, message2, (amount - 1), i + 1)
  case (amount) if ((i % 5) == 0 && i != 0 && amount > 0) => println(message2);  exercise12Recursive(message1, message2, (amount - 1), i + 1)
  case (amount) if (amount > 0) => println(i);  exercise12Recursive(message1, message2, (amount - 1), i + 1)

}

i = 0
exercise12RecursivePatternMatch("Fizz", "Buzz" , 15, i)


def exercise13PatternMatch(anything: Any): Unit = (anything) match
{
  //case input1: Int => var a =input2 ; var b = input1; println(a,b)
  case Array(a @d, b @c) => println(c, d);
  case List(a @d, b @c) => println(c, d);
}
val testPatternList: List[Int] = List (2,1)
var testPatternArray: Array[Int] = Array(2, 1)

exercise13PatternMatch(testPatternList)


def exercise14Functional(): Array[String] = java.util.TimeZone.getAvailableIDs ().map (value => value.split("/")).flatten


var functiontest: Array[String] = exercise14Functional()