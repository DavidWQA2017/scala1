

import scala.collection.mutable.{Map => MutableMap}
import scala.io.StdIn.readLine

object CipherMain extends App {

  var word: String = readLine()
  println(decode(word ,createAtBashCipher()))
  println()


  def createAtBashCipher(): Map[Char, Char] = {
    var cipher = Map('a' -> 'z')
    var key: Int = 'a'
    var value: Int = 'z'
    for (i <- 0 to 25)
    {
      //println((key + i).toChar)
      //println((value -i).toChar)
      //key = (key + i ).toChar
      //println(key.toChar)
      //value = (value - i).toChar
     //println(value.toChar)

      cipher = cipher + ((key + i).toChar -> (value - i).toChar)

    }
    //cipher.foreach( key =>println(key))
    cipher

  }

  def decode(input: String, cipher: Map[Char, Char]): String =
  {
    var wordAsAArray: Array[Char] = word.toCharArray
    for (i <- 0 to word.size - 1)
    {
      var a: Char = wordAsAArray(i)
      var b: Char = cipher(a)
      wordAsAArray(i) = b
      println(wordAsAArray(i))
      //word = word.replace(a , b) // will not work replaces each letter as it passes
    }
    //word
    wordAsAArray.mkString
  }
}