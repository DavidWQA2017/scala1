import org.w3c.dom.css.Counter

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source
import scala.io.StdIn.readLine

object HangMan extends App
{
  val wordList = loadWordList()
  val wordToGuess = pickWord(wordList)
  var wordDisplay: ArrayBuffer[Char] = createWordDisplay(wordToGuess)
  val hangManPieces = setHangManPiecies()
  var hangManDisplay: ListBuffer[String] = new ListBuffer[String]
  var correctGuesses = 0
  var counterMain = 0

  while( counterMain < 14 && correctGuesses < wordToGuess.length )
  {
    println("please enter a character" )
    checkInput(wordToGuess ,takeInput(), wordDisplay)
    hangManDisplay.reverse.foreach(item => println(item))
  }

  if (correctGuesses == wordToGuess.length) println("Well done you have guessed the word " + wordToGuess)














  def pickWord(wordList: List[String]): String = wordList(scala.util.Random.nextInt(wordList.size -1))

  def takeInput(): String = readLine()

  def checkInput(wordToGuess: String , input: String , wordDisplay: ArrayBuffer[Char] ): Unit =
  {
    val wordToGuessCharArray  = wordToGuess.toCharArray
    var guess = false
    if (wordToGuessCharArray.contains(input.toCharArray.head))
    {
      for(i <- 0 to wordToGuessCharArray.size -1 if (wordToGuessCharArray(i) == input.toCharArray.head))
      {
        wordDisplay(i) = input.toCharArray.head
        guess = true
        if (wordDisplay(i) != input.toCharArray.head) correctGuesses += 1
      }
    }
    else guess = false
    println(wordDisplay.mkString)
    counterMain = adjustHangManPiece(guess)
    if (guess == false) addHangManPiece(counterMain)
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

  def adjustHangManPiece(guess: Boolean ): Int =
  {
    var counter = counterMain
    (guess) match {
      case (guess) if (guess == false) => counter += 1
      case _ =>
    }
    counter
  }

  def addHangManPiece(piecePlace: Int): Unit = (piecePlace) match
  {
    case (piecePlace) if (piecePlace <= 7) => hangManDisplay += hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 8) =>
      hangManDisplay((piecePlace - 3))= hangManDisplay((piecePlace - 3)) + hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 9) =>
      hangManDisplay((piecePlace - 5))= hangManDisplay((piecePlace - 5)) + hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 10) =>
      hangManDisplay((piecePlace - 7))= hangManDisplay((piecePlace - 7)) + hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 11) =>
      hangManDisplay((piecePlace - 8))= hangManDisplay((piecePlace - 8)) + hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 12) =>
      hangManDisplay((piecePlace - 9))= hangManDisplay((piecePlace - 9)) + hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 13) =>
      hangManDisplay((piecePlace - 11))= hangManDisplay((piecePlace - 11)) + hangManPieces((piecePlace - 1))
    case (piecePlace) if (piecePlace == 14) =>
      hangManDisplay((piecePlace - 12))= hangManDisplay((piecePlace - 12)) + hangManPieces((piecePlace - 1))
      println ("you lose")
    case _ => hangManPieces((piecePlace - 1))
  }

  def loadWordList(): List[String] =  Source.fromFile("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\main\\Resources\\HangManWordList.txt").getLines().toList

  def generateGrid(hangManGrid: Array[Array[String]], GridInfo: ArrayBuffer[String]): Array[Array[String]] =
  {
    hangManGrid
  }

  def setHangManPiecies(): List[String] =
  {
    val hangManPieces: List[String] = List(
      "___", " | ", " | ", " | ", " | ", " | ", " |-------- ", "     |", "     O", "    /", "|", "\\", "    / ", "\\")
    hangManPieces
  }

  def hangMan(hangManPieces: List[String]): Unit =
  {
    println(hangManPieces(6))
    println(hangManPieces(5) +  hangManPieces(7) )
    println(hangManPieces(4) + hangManPieces(8))
    println(hangManPieces(3) + hangManPieces(9) + hangManPieces(10) +  hangManPieces(11))
    println(hangManPieces(2) + hangManPieces(12) + hangManPieces(13))
    println(hangManPieces(1))
    println(hangManPieces(0))
  }
}
