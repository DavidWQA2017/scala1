import scala.io.StdIn.readLine

object RockPaperScissors extends App {
  println("please enter the amount of games you wish to play")
  var totalGames = takeInput().toInt
  var scissorsWeight = 0
  var rockWeight = 0
  var paperWeight = 0
  println("please enter the mode ou wish to enter" )

  //player vs computer
  /*
  while (totalGames > 0)
  {

    var moveAI = commitAImove(generateAIMove(), scissorsWeight, rockWeight, paperWeight)
    var movePlayer = takeInput()
    weightAdjustmentCheck(movePlayer)
    println(determineWinner(moveAI, movePlayer ))
    println("genrated Ai move " + moveAI)
    println(rockWeight)
    totalGames -= 1
  }
  */

  //computer vs computer
  while (totalGames > 0)
  {

    var moveAI = commitAImove(generateAIMove(), scissorsWeight, rockWeight, paperWeight)
    var movePlayer = commitAImove(generateAIMove(), scissorsWeight, rockWeight, paperWeight)
    weightAdjustmentCheck(movePlayer)
    println(determineWinner(moveAI, movePlayer ))
    println("genrated Ai move " + moveAI)
    println(rockWeight)
    totalGames -= 1
  }

  def takeInput(): String = readLine()

  def generateAIMove(): Int =
  {
    var rand = scala.util.Random
    var i = rand.nextInt(45)
    i
  }

  def commitAImove(genratedNumber: Int , weightedSc: Int, weightedRock: Int ,weightedPaper: Int): String = (genratedNumber) match
  {
    case (a) if ( 0 < genratedNumber && genratedNumber <= (15 - weightedRock - weightedSc + weightedPaper)) => "scissor"
    case (a) if ( 15 < genratedNumber && genratedNumber <= (30 - weightedPaper - weightedSc + weightedRock)) => "paper"
    case (a) if ( 30 < genratedNumber && genratedNumber <= (45 - weightedPaper - weightedRock +weightedSc)) => "rock"
    case  _ =>  commitAImove(generateAIMove(), weightedSc , weightedRock , weightedPaper)
  }

  def weightAdjustmentCheck(input: String): Unit = (input) match
  {
    case (input) if( input == "rock") => rockWeight += 1
    case (input) if(input == "paper") =>  paperWeight += 1
    case (input) if(input == "scissor") => scissorsWeight += 1
  }


  def determineWinner(moveAI: String, movePlayer: String): String = (moveAI) match
  {
    case(a) if(moveAI == movePlayer) => "draw"
    case(a) if(moveAI == "paper" && movePlayer == "rock") => "lose"
    case(a) if(moveAI == "rock" && movePlayer == "scissor") => "lose"
    case(a) if(moveAI == "scissor" && movePlayer == "paper") => "lose"
    case(a) if(moveAI == "rock" && movePlayer == "paper" ) => "win"
    case(a) if(moveAI == "scissor" && movePlayer =="rock" ) => "win"
    case(a) if(moveAI == "paper"&& movePlayer == "scissor") => "win"

  }

}
