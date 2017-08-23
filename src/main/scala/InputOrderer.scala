import java.lang.String

import scala.Int
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine

object InputOrderer extends App
{
  var allInputedStrings = createInputList(takeInput())
  while(1 != 2)
  {
    allInputedStrings += (createInputList(takeInput()))
    allInputedStrings.foreach( item => println(item))
  }

  def createInputList[T](input: T): ArrayBuffer[T] =
  {
    var numberArrayBuffer = new ArrayBuffer[T]
    numberArrayBuffer += input
  }

  def takeInput(): Any = readLine()
}
