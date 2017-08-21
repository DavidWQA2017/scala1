import org.w3c.dom.css.Counter

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.io.StdIn.readLine

object HangMan extends App
{
  val wordList = loadWordList()
  val wordToGuess = pickWord(wordList)
  var wordDisplay: ArrayBuffer[Char] = createWordDisplay(wordToGuess)
  var hangManGrid = Array.ofDim[String](3, 4)

  println(wordToGuess)
  println(createWordDisplay(wordToGuess).mkString)
  while( 1 != 0)
  {
    checkInput(wordToGuess ,takeInput(), wordDisplay)
  }
  //loadWordList().foreach(item => println(item))
  //val FILENAME =






  def pickWord(wordList: List[String]): String =
  {
    var rand = scala.util.Random
    var i = rand.nextInt((wordList.size -1))
    wordList(i)
  }

  def takeInput(): String = readLine()

  def checkInput(wordToGuess: String , input: String , wordDisplay: ArrayBuffer[Char] ): Boolean =
  {
    val wordToGuessCharArray  = wordToGuess.toCharArray
    var guess = false
    if (wordToGuessCharArray.contains(input.toCharArray.head))
    {
      println("i am here ")
      for(i <- 0 to wordToGuessCharArray.size -1 if (wordToGuessCharArray(i) == input.toCharArray.head))
      {
        wordDisplay(i) = input.toCharArray.head
        guess = true
      }

    }
    else guess = false
    println(wordDisplay.mkString)
    guess
  }

  def createWordDisplay(wordToGuess:String): ArrayBuffer[Char] =
  {
    var wordDisplay: ArrayBuffer[Char] = new ArrayBuffer[Char]
    for (i <- 0 to wordToGuess.length -1)
    {
      wordDisplay += '_'
    }

    wordDisplay
  }

  //def displayWord(wordDisplay: ArrayBuffer[Char]):String = wordDisplay.mkString

  def adjustHangMan(guess: Boolean ): Unit = (guess) match
  {
    case (guess) if (guess == true) => ArrayBuffer
  }

  def loadWordList(): List[String] =  Source.fromFile("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\main\\Resources\\HangManWordList.txt").getLines().toList

  def generateGrid(hangManGrid: Array[Array[String]], GridInfo: ArrayBuffer[String]): Array[Array[String]] =
  {
    /*
    for (k <- 0 to hangManGrid.size - 1; j <- 0 to hangManGrid.size - 1)
    {
      hangManGrid(k)(j) = GridInfo((k * hangManGrid.size) + j)
    }
    */
    hangManGrid

  }

}
