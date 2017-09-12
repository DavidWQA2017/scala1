import scala.io.StdIn.readLine

object bottlesbeerOnwall extends App
{

  println( "please type in how many bottles of beer on the wall")
  var numberOfBeersOnWall = readLine().toInt
  val lineOne = " Bottles of Beer on the wall "
  val lineTwo = " Bottles of Beer "
  val lineThree = "take one down pass it around "
  val lineFour = "No more bottles of beer on the wall, no more bottles of beer go to the store buy some more "
  val lineFive = " more Bottles of Beer on the wall"
  outputNumberOfBeersOnWall(numberOfBeersOnWall)


  def takeInput(): String = readLine()

  def outputNumberOfBeersOnWall(numbBeers: Int): Unit =(numbBeers) match
  {
    case (numBeer)  if(numbBeers > 1)=>
      println(numbBeers + lineOne + numbBeers + lineTwo + lineThree + (numbBeers - 1) + lineOne)
      outputNumberOfBeersOnWall(numbBeers - 1)
    case (numBeer)  if(numbBeers == 1) =>
      println
      (numbBeers + lineOne.replace('s' , ' ') + numbBeers + lineTwo.replace('s' , ' ') + lineThree + (numbBeers - 1) + lineOne)
      outputNumberOfBeersOnWall(numbBeers - 1)
    case (numBeer)  if(numbBeers == 0) => println(lineFour  + numberOfBeersOnWall + " more Bottles of Beer on the wall" )
    case  _ =>

  }
}
