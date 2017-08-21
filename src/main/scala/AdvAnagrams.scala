import java.util

import scala.collection.mutable.{ArrayBuffer, ListBuffer, Map => MutableMap}
import scala.io.Source
import scala.io.StdIn.readLine

object AdvAnagrams extends App
{
  var rawInput: ArrayBuffer[String] = takeInput()
  var wordListMap: Map[String, String] = createWordListmap(sortwordList(generatewordList()), generatewordList())

  var mostAnagramList: ArrayBuffer[String] = (createListOfMostAnagram
  (
    createAnagramList(createSortedinput(rawInput), wordListMap)
    , rawInput
    , findMostAngarmsNum(createAnagramList(createSortedinput(rawInput), wordListMap) , rawInput)
  ))

  findlongestWord(mostAnagramList, findlongestWordNum(mostAnagramList))





  def findlongestWordNum(foundAnagramWords: ArrayBuffer[String]):  Int =
  {
    var longestWordNum = foundAnagramWords(0).size
    for (i <- 0 to foundAnagramWords.size-1)
    {
      if(longestWordNum < foundAnagramWords(i).size)
      {
          longestWordNum = foundAnagramWords(0).size
      }
    }
    longestWordNum

  }

  def findlongestWord(foundAnagramWords: ArrayBuffer[String] , longestWordNum: Int): Unit =
  {
    foundAnagramWords.foreach(item => if(item.size == longestWordNum) println("the word with the most letters and anagrams is " + item))
  }

  def findMostAngarmsNum(anagramList: ArrayBuffer[ArrayBuffer[String]] , wordList: ArrayBuffer[String]): Int=
  {
    var mostAnagramsAmount = anagramList(0).size
    for(i <- 0 to anagramList.size - 1)
    {
      if (anagramList(i).size > mostAnagramsAmount)
      {
          mostAnagramsAmount = anagramList(i).size

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

    allWordsWithMostAnag
  }

  def createAnagramList(inputList :ArrayBuffer[String], wordListMap:Map[String, String]): ArrayBuffer[ArrayBuffer[String]]  =
  {
    var allAnagramLists: ArrayBuffer[ArrayBuffer[String]] = new ArrayBuffer[ArrayBuffer[String]]

    for (i <- 0 to inputList.size - 1)
    {
      var anagramList: ArrayBuffer[String] = new ArrayBuffer[String]
      var input: String = inputList(i)
      wordListMap.values.foreach(value => if (value == input) wordListMap.keys.foreach(k => if (wordListMap.get(k).getOrElse("", "") == value) anagramList += k))
      allAnagramLists += anagramList.distinct
    }

    allAnagramLists
  }

  def createWordListmap(sortedWordList: ArrayBuffer[String] , wordList: List[String]): Map[String , String] =
  {
    var wordListMap: Map[String, String] =  Map(1.toString -> 1.toString)
    for (i <- 0 to wordList.size - 1)
    {
          wordListMap +=  ( (wordList(i))-> (sortedWordList(i)))
    }
    wordListMap
  }

  def sortwordList(worldList: List[String]): ArrayBuffer[String] =
  {
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
    sortingWord.mkString
  }

  def generatewordList(): List[String] =
  {
    Source.fromFile("C:\\Users\\Administrator\\IdeaProjects\\untitled\\src\\main\\Resources\\WordList.txt").getLines().toList
  }

}
