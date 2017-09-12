object ArrayDuplicates extends App
{

  val input: Array[Int] = Array(0 ,1 ,3, 2 , 10 , 9 , 11 , 10)
  var i = 0
  var counter = 0
  var duplicate = 0


  while ( i < input.size-1 && counter != 2)
  {
    counter = 0
    input.foreach(item =>if (item == i) counter += 1 )
    i += 1
    println(i)
  }
  if(counter == 2) duplicate = i
  println("the duplicated number is " + duplicate)


}
