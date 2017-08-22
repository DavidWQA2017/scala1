import java.lang.String
import java.util

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.{Map => MutableMap}
import scala.io.StdIn.readLine

object RockPaperScissors extends App {
  println("please enter the amount of games you wish to play")
  var totalGames = takeInput().toInt
  var scissorsWeight = 0
  var rockWeight = 0
  var paperWeight = 0
  val weightGroupsSizeO  = createGroupSizeForWeights
  var winning: Int = 0
  var totalNumberOfAI = 100
  println("please enter the mode you wish to enter" )
  var playMode = takeInput().toInt

  if (playMode  == 1)
    runAIVSPlayer(totalGames)
    else if(playMode == 2)
    runAIVSAI(totalGames)
    else if(playMode == 3)
    runLotsOfAI()





  def takeInput(): String = readLine()

  def generateAIMove(): Int = scala.util.Random.nextInt(totalGames * 10)

  def createGroupSizeForWeights: Int = (totalGames * 10)/ 3


  def commitAImove
  (genratedNumber: Int , weightedSc: Int, weightedRock: Int ,weightedPaper: Int ,weightGroupsSizeO: Int ): String =
    (genratedNumber) match
  {
    case (a)
      if ( 0 < genratedNumber && genratedNumber <= (
        weightGroupsSizeO - weightedRock - weightedSc + weightedPaper)) => "scissor"
    case (a)
      if ( weightGroupsSizeO < genratedNumber && genratedNumber <= (
        (weightGroupsSizeO * 2) - weightedPaper - weightedSc + weightedRock)) => "paper"
    case (a)
      if ( (weightGroupsSizeO * 2)  < genratedNumber && genratedNumber <= (
        (weightGroupsSizeO * 3)  - weightedPaper - weightedRock +weightedSc)) => "rock"
    case  _ =>  commitAImove(generateAIMove(), weightedSc , weightedRock , weightedPaper ,weightGroupsSizeO)
  }

  def weightAdjustmentCheck(input: String): Unit = (input) match
  {
    case (input) if( input == "rock") => rockWeight += 1
    case (input) if(input == "paper") =>  paperWeight += 1
    case (input) if(input == "scissor") => scissorsWeight += 1
  }


  def determineWinner(moveAI: String, movePlayer: String): String = (moveAI) match
  {
    case(a) if(moveAI == movePlayer) => "draw against first A.I"
    case(a) if(moveAI == "paper" && movePlayer == "rock") => winning -= 1; "lose against first A.I"
    case(a) if(moveAI == "rock" && movePlayer == "scissor") => winning -= 1; "lose against first A.I"
    case(a) if(moveAI == "scissor" && movePlayer == "paper") => winning -= 1;  "lose against first A.I"
    case(a) if(moveAI == "rock" && movePlayer == "paper" ) => winning += 1; "win against first A.I"
    case(a) if(moveAI == "scissor" && movePlayer =="rock" ) => winning += 1; "win against first A.I"
    case(a) if(moveAI == "paper"&& movePlayer == "scissor") =>  winning += 1; "win against first A.I"

  }

  def determineOveralWinner(): Unit =
  {
     if(winning > 0) println("first player has won by " + winning)
     else if (winning < 0) println("first player has lost by " + winning)
     else println("neither player lost or won")
  }

  def runAIVSAI(totalGames: Int) =
  {
    var totalGamesInFunction = totalGames
    while (totalGamesInFunction > 0)
    {
      var moveAI = commitAImove(generateAIMove(), scissorsWeight, rockWeight, paperWeight ,weightGroupsSizeO )
      var movePlayer = commitAImove(generateAIMove(), scissorsWeight, rockWeight, paperWeight, weightGroupsSizeO )
      weightAdjustmentCheck(movePlayer)
      println(determineWinner(moveAI, movePlayer ))
      println("genrated Ai move " + moveAI)
      totalGamesInFunction -= 1
    }
    determineOveralWinner()
  }

  def runAIVSPlayer (totalGames: Int) =
  {
    var totalGamesInFunction = totalGames
    while (totalGamesInFunction > 0)
    {
      var moveAI = commitAImove(generateAIMove(), scissorsWeight, rockWeight, paperWeight , weightGroupsSizeO)
      var movePlayer = takeInput()
      weightAdjustmentCheck(movePlayer)
      println(determineWinner(moveAI, movePlayer))
      println("genrated Ai move " + moveAI)
      totalGamesInFunction -= 1
    }
    determineOveralWinner()
  }


  //functions for multiple AI players
  def determinWinnerMulipleAI(allCommitedMoves: Map[Int, String]): Map[Int, String] =
  {
      var currentAllCommitedMoves: Map[Int , String]  = allCommitedMoves
      currentAllCommitedMoves.values.foreach(item => println("generated Items" + item))
      var scissorCount = 0
      var rockCount = 0
      var paperCount = 0
      allCommitedMoves.values.foreach(item =>
        if(item  == "scissor") scissorCount += 1
        else if (item == "rock") rockCount += 1
        else if(item == "paper") paperCount += 1  )

      (scissorCount) match  //move to own function when everything is 100% working
      {
        case (scissor) if(paperCount == 0 && scissorCount > 0 && rockCount > 0
          )=> currentAllCommitedMoves.values.foreach(item => if(item == "scissor")
          currentAllCommitedMoves.keys.foreach(k => if (currentAllCommitedMoves.get(k).getOrElse("", "") == item) {
            currentAllCommitedMoves -= k;
            totalNumberOfAI -= 1
            println("AI " + k  + " has lost")
          })); println("scissor is the losing choice") ; println(scissorCount); println(paperCount); println(rockCount)
        case _ =>
      }

      (rockCount) match //move to own function when everything is 100% working
      {
        case (rock) if(scissorCount == 0 && rockCount > 0 && paperCount > 0
          )=> currentAllCommitedMoves.values.foreach(item => if(item == "rock")
          currentAllCommitedMoves.keys.foreach(k => if (currentAllCommitedMoves.get(k).getOrElse("", "") == item) {
            currentAllCommitedMoves -= k
            totalNumberOfAI -= 1
            println("AI " + k  + " has lost")
          })); println("rock is the losing choice")
        case _ =>
      }

      (paperCount) match //move to own function when everything is 100% working
      {
        case (paper) if(rockCount == 0 && paperCount > 0 && scissorCount  > 0 && currentAllCommitedMoves.size > 1
          )=> currentAllCommitedMoves.values.foreach(item => if(item == "paper")
          currentAllCommitedMoves.keys.foreach(k => if (currentAllCommitedMoves.get(k).getOrElse("", "") == item) {
            currentAllCommitedMoves -= k
            totalNumberOfAI -= 1
            println("AI " + k  + " has lost")
          })); println("paper is the losing choice")
        case _ =>
      }

      currentAllCommitedMoves
  }

  def generateAllAIMoves(weightedSc: Int, weightedRock: Int ,weightedPaper: Int): Map[Int , String] =
  {
    var allCommitedMoves: Map[Int , String]  = Map(-1 -> "na")
    allCommitedMoves -=  -1
    for (i <- 0 to (totalNumberOfAI - 1))
    {
      allCommitedMoves +=((i) -> commitAImove(generateAIMove(), weightedSc , weightedRock , weightedPaper ,weightGroupsSizeO))
    }
    allCommitedMoves
  }

  def runLotsOfAI(): Unit =
  {
    var allAI: Map[Int , String]  = Map(-1 -> "na")
    allAI -= -1
    do
    {
      allAI = determinWinnerMulipleAI(generateAllAIMoves(scissorsWeight, rockWeight, paperWeight))
      allAI.values.foreach(value => println("after winner has been determined " + value))
      println("number of AI still in the game " +  totalNumberOfAI)
    }
    while( 1 < allAI.size)

  }
}
