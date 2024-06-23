object FunctionalQuickSort {
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail =>
      val (smaller, greater) = tail.partition(_ < head)
      quickSort(smaller) ::: head :: quickSort(greater)
  }

  def main(args: Array[String]): Unit = {
    val list = List(3, 6, 8, 10, 1, 2, 1)
    val sortedList = quickSort(list)
    println(sortedList.mkString(", "))
  }
}
