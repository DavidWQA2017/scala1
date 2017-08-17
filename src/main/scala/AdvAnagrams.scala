import java.util

import scala.collection.mutable.{ArrayBuffer, ListBuffer, Map => MutableMap}
import scala.io.Source
import scala.io.StdIn.readLine

object AdvAnagrams extends App
{


  var rawInput: ArrayBuffer[String] = takeInput()
  var wordListMap: Map[String, String] = createWordListmap(sortwordList(generatewordList()), generatewordList())
  //println(wordListMap)
  //wordListMap.foreach(value => println(value))

  //println(findMostAngarmsNum(createAnagramList(createSortedinput(rawInput), wordListMap) , rawInput))
  var mostAnagramList: ArrayBuffer[String] = (createListOfMostAnagram
  (
    createAnagramList(createSortedinput(rawInput), wordListMap)
    , rawInput
    , findMostAngarmsNum(createAnagramList(createSortedinput(rawInput), wordListMap) , rawInput)
  ))

  //mostAnagramList.foreach(item => println(item))
  findlongestWord(mostAnagramList, findlongestWordNum(mostAnagramList))

  //val mostAnagramList =




  //def createAllAnagramLists(): List[List[String]]=
  //{

  //}

  def findlongestWordNum(arrayBuffer: ArrayBuffer[String]):  Int =
  {
    var longestWordNum = arrayBuffer(0).size
    for (i <- 0 to arrayBuffer.size-1)
    {
      if(longestWordNum < arrayBuffer(i).size)
      {
          longestWordNum = arrayBuffer(0).size
      }
    }
    longestWordNum

  }

  def findlongestWord(arrayBuffer: ArrayBuffer[String] , longestWordNum: Int): Unit =
  {
    arrayBuffer.foreach(item => if(item.size == longestWordNum) println("the word with the most letters and anagrams is " + item))
  }

  def findMostAngarmsNum(arrayBuffer: ArrayBuffer[ArrayBuffer[String]] , wordList: ArrayBuffer[String]): Int=
  {
    var mostAnagramsAmount = arrayBuffer(0).size
    //var mostAnagramsIndex = 0
    for(i <- 0 to arrayBuffer.size - 1)
    {
      if (arrayBuffer(i).size > mostAnagramsAmount)
      {
          mostAnagramsAmount = arrayBuffer(i).size
          //mostAnagramsIndex = i
      }
    }
    mostAnagramsAmount
  }

  def createListOfMostAnagram(arrayBuffer: ArrayBuffer[ArrayBuffer[String]] , wordList: ArrayBuffer[String], mostAnagramsAmount: Int): ArrayBuffer[String] =
  {

    var allWordsWithMostAnag: ArrayBuffer[String] = new ArrayBuffer[String]
    for (i <- 0 to arrayBuffer.size - 1)
    {
      if(arrayBuffer(i).size == mostAnagramsAmount)
      {
        allWordsWithMostAnag += wordList(i)
      }
    }

    //println("have the most" + allWordsWithMostAnag)
    allWordsWithMostAnag
  }

  def createAnagramList(inputList :ArrayBuffer[String], WordListMap:Map[String, String]): ArrayBuffer[ArrayBuffer[String]]  =
  {
    //println("i am here")
    var allAnagramLists: ArrayBuffer[ArrayBuffer[String]] = new ArrayBuffer[ArrayBuffer[String]]
    //var l = ListBuffer[]
    //wordListMap.values.foreach((value) =>  if(value == input) println( "and the value is" + value) else println(value) )
    for (i <- 0 to inputList.size - 1)
    {
      var anagramList: ArrayBuffer[String] = new ArrayBuffer[String]
      var input: String = inputList(i)
      wordListMap.values.foreach(value => if (value == input) wordListMap.keys.foreach(k => if (wordListMap.get(k).getOrElse("", "") == value) anagramList += k))
      allAnagramLists += anagramList.distinct
    }
    //println(allAnagramLists)
    allAnagramLists
  }


  def createWordListmap(arrayBuffer: ArrayBuffer[String] , wordList: List[String]): Map[String , String] =
  {
    var wordListMap: Map[String, String] =  Map(1.toString -> 1.toString)
    for (i <- 0 to wordList.size - 1)
    {
          wordListMap +=  ( (wordList(i))-> (arrayBuffer(i)))
    }
    wordListMap
  }


  def sortwordList(worldList: List[String]): ArrayBuffer[String] =
  {
    //worldList.foreach(item => println(item))
    var sortingWordList: ArrayBuffer[String] = new ArrayBuffer[String]
    worldList.foreach(item => sortingWordList += sortString(item))
    sortingWordList

  }

  def takeInput(): ArrayBuffer[String] = {
    var inputList: ArrayBuffer[String] = new ArrayBuffer[String]

    for (i <- 0 to 1)
    {
      var input = readLine()
      inputList += input
    }
    inputList

  }

  def createSortedinput(inputList: ArrayBuffer[String]): ArrayBuffer[String]  =
  {
    var sortedInputArray: ArrayBuffer[String] = new ArrayBuffer[String]
    for (i <- 0 to inputList.size - 1)
    {
      sortedInputArray += sortString(inputList(i))
    }

    sortedInputArray
  }

  def sortString(input: String): String  =
  {
    var sortingWord: Array[Char] = input.toCharArray()
    util.Arrays.sort(sortingWord)
    //println(sortingWord.mkString)
    sortingWord.mkString
  }

  def generatewordList(): List[String] =
  {
    val lines = Source.fromFile("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\main\\Resources\\WordList.txt").getLines().toList
    //lines.foreach(item => println(item))
    lines
  }

}
