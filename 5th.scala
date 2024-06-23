object ImperativeQuickSort {
  def quickSort(arr: Array[Int]): Array[Int] = {
    def sort(start: Int, end: Int): Unit = {
      if (start < end) {
        val pivotIndex = partition(start, end)
        sort(start, pivotIndex - 1)
        sort(pivotIndex + 1, end)
      }
    }

    def partition(start: Int, end: Int): Int = {
      val pivot = arr(end)
      var i = start - 1
      for (j <- start until end) {
        if (arr(j) <= pivot) {
          i += 1
          val temp = arr(i)
          arr(i) = arr(j)
          arr(j) = temp
        }
      }
      val temp = arr(i + 1)
      arr(i + 1) = arr(end)
      arr(end) = temp
      i + 1
    }

    sort(0, arr.length - 1)
    arr
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(3, 6, 8, 10, 1, 2, 1)
    val sortedArr = quickSort(arr)
    println(sortedArr.mkString(", "))
  }
}
