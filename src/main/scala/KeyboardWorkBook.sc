import scala.io.Source
import scala.io.StdIn.readLine

var amount: Int = readLine().toInt
val filename = "Dictionary.scala"
amount = 3


val keyInputList: List[String]= List("abcd", "qwer" ,"hjklo" )

def generateDictionary(): List[String] =
{
  val lines = Source.fromFile("C:\\Users\\Administrator\\IdeaProjects\\BrokenKeyboardScala\\Dictionary.txt").getLines().toList
  lines
}

generateDictionary().foreach(item => println(item))

val Dictionary: List[String] = generateDictionary()

def createAvailableKeylistConsole(amount: Int): List[String] =
{
  for (i <- 0 to (amount))
  {
    var newKeyInput = readLine("adada")
    keyInputList :+ newKeyInput
  }

  keyInputList
}



