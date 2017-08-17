import scala.io.Source

object Keyboardbroken {

  def main(args: Array[String]): Unit =
  {
    val dictionary = generateDictionary()
    //dictionary.foreach(item => println(item))

    //var amount: Int= readLine().toInt
    val keyInputList: List[String] = List("abcd" )
    println(keyInputList)
    var word1: Array[String] = genrateWordslist(dictionary ,keyInputList)
    var longestword: String = findbiggestWord(word1)
    println(longestword)

  }

//
  //
//  val filename = "Dictionary.scala"
//  amount = 3


  def genrateWordslist(dictionary :List[String], keyInputList :List[String]): Array[String]=
  {
    var word1: Array[String] = new Array(18)
    var keyInputCharArray: Array[Char] = keyInputList(0).toCharArray()

    var cWordFound = 0
    for (k <- 0 to dictionary.size - 1)
      {
    var currentWord: String = dictionary(k)
    var currentWordCArray: Array[Char] = currentWord.toCharArray

    //total characters that match
    var tNum = 0
    for (i  <- 0 to currentWord.size - 1)
    {
      //println(currentWord)
      for  (j <- 0 to keyInputCharArray.size - 1)
      {
        if (keyInputCharArray(j) == currentWordCArray(i))
        {
          tNum = tNum + 1
        }

      }
    }

    if (tNum == currentWord.toCharArray.size)
    {
       word1.update(cWordFound, currentWord)
      cWordFound = cWordFound + 1
      println("found one")
    }
        println(cWordFound)
    //println(word1(2))
      }

    word1
  }

  def generateDictionary(): List[String] =
  {
    val lines = Source.fromFile("C:\\Users\\Administrator\\IdeaProjects\\BrokenKeyboardScala\\Dictionary.txt").getLines().toList
    lines
  }

  def findbiggestWord(word1: Array[String]):String =
  {
    println(word1(0))
    var maxWordSize = word1(0).size
    var longestWord = word1(0)
    println (word1.size)
    for(i <-0 to word1.length - 1)
    {
      println(word1(i))
      if (maxWordSize < word1(i).size)
        {
          println(word1(i))
          longestWord = word1(i)
          maxWordSize = word1(i).size
        }
    }
    longestWord
  }

// def createAvailableKeylistConsole(amount: Int): List[String] =
// {

 //  for (i <- 0 to (amount))
  // {
   //   var newKeyInput = readLine()
  //    val keyInputList :+ newKeyInput
 //  }
  // keyInputList
// }


}
