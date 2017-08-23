def findSumofNum(n: Int, amount: Int): Int=
{
  if (n > 0)
  {
    println(n + " is amount being added")
    findSumofNum((n - 1) , (amount + n))
    println("value of sum" + amount)
  }
  amount
}

findSumofNum(4 , 1)

var number = 0
