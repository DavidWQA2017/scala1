import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

def findSumofNum(n: Int, amount: Int): Int=
{
  var cAmount = amount
  if (n > 0) cAmount = findSumofNum(n - 1 , amount + n)
  cAmount
}

var sumNumber = findSumofNum(5 , 0)

def productOf(n: Int, amount: Int): Int =
{
  var cAmount = amount
  if (n > 0) cAmount = productOf((n - 1) , (amount * n))
  cAmount
}

var productNumber = productOf(5, 1)

/*
def numberOfZeros(n: String, amount: Int , counter: Int): Int =
{
  var number = n.toCharArray.head.toInt
  (counter)match
  {
    case 0 => amount + 0
    case (counter)  if(number == 0) =>
      var newN: String = n.stripPrefix(n.toCharArray.head.toString)
      numberOfZeros(newN , amount + 1, counter - 1)
    case (counter) =>
      var newN: String = n.stripPrefix(n.toCharArray.head.toString)
      numberOfZeros(newN , amount, counter - 1)
  }
}
*/

var n = "100"
n = n.stripPrefix(n.toCharArray.head.toString)
var input: String = "100"
//var numberOfZeros = numberOfZeros(input,0 , input.size)


def findMinimum(arrayBuffer: ArrayBuffer[Int], counter: Int,  minimum: Int): Unit = (counter) match
{
  case 0 =>  println("the minimum value is " + minimum)
  case (counter) if(arrayBuffer.head < minimum) =>
    var minimum = arrayBuffer.head
    arrayBuffer.remove(0)
    println("the  current minimum value is " + minimum)
    findMinimum(arrayBuffer, counter -1 , minimum )
  case (counter) =>
    arrayBuffer.remove(0)
    findMinimum(arrayBuffer, counter -1 , minimum )
}

var collectionofInts = ArrayBuffer[Int](1, 2, 3 , 2)

findMinimum(collectionofInts, collectionofInts.size, collectionofInts.head)



def printAllElements(arrayBuffer: ArrayBuffer[Int], counter: Int ): Unit = (counter) match
{
  case 0 =>
  case _ => println(arrayBuffer.head)
    arrayBuffer.remove(0)
    printAllElements(arrayBuffer, counter - 1)
}

collectionofInts = ArrayBuffer[Int](1, 2, 3 , 2)

printAllElements(collectionofInts , collectionofInts.size)


def sumAllDigitsExample1(arrayBuffer: ArrayBuffer[Int], counter: Int , amount: Int ): Unit = (counter) match
{
  case 0 => print("the total amount of all the digits are " + amount)
  case _ =>
    var arrayBufferCurrent = arrayBuffer
    var cAmount = amount
    cAmount += arrayBufferCurrent.head
    arrayBufferCurrent.remove(0)
    sumAllDigitsExample1(arrayBuffer, counter -1 , cAmount)
}

val inputInt = 12345
val digitsSArray: Array[Char] = inputInt.toString.toCharArray
var digitsIArray: Array[Int] = digitsSArray.map(item => item.toInt - 48)
var digitsIArrayBuff : ArrayBuffer[Int] = new ArrayBuffer[Int]
digitsIArrayBuff
digitsIArray.foreach(item => digitsIArrayBuff += item)



sumAllDigitsExample1(digitsIArrayBuff, digitsIArray.size, 0)


/*
def sumAllDigits(n: Int): Int = (n) match
{
  case 0 =>
  case (n) if (n > 0) =>
  case (n) if()
}
*/


