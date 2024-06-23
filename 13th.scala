object BinarySearch {
  def binarySearch(list: List[Int], target: Int): Boolean = {
    def binarySearchRecursive(list: List[Int], start: Int, end: Int): Boolean = {
      if (start > end) false
      else {
        val mid = start + (end - start) / 2
        list(mid) match {
          case `target` => true
          case x if x > target => binarySearchRecursive(list, start, mid - 1)
          case _ => binarySearchRecursive(list, mid + 1, end)
        }
      }
    }
    binarySearchRecursive(list.sorted, 0, list.length - 1)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 3, 5, 7, 9)
    val target = 5
    println(s"Is $target in the list? ${binarySearch(list, target)}")
  }
}
