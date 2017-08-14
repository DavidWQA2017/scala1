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

    if ((i % 3 ) == 0 && i != 0)
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
  var i = i
  if (amount > 0 )
  {
    if (((i % 3) == 0 )&& (i != 0))
      println(message1)
    else if ((i % 5) == 0 && i != 0)
      println(message2)
    else
      println(i)

    i = i + 1
    exercise12Recursive(message1, message2, (amount -1), i)
  }

}
var i = 0
exercise12Recursive("Fizz", "Buzz" , 15, i)



//not working
def exercise11Recursive(message: String , amount: Int): Unit =
{
  var line = exercise11Recursive(message, amount - 1)
  if(amount > 0)
  {
    line = line + message

  }

  println(line)


}

exercise11Recursive("h", 4)