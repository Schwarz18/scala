object SearchElement {
  def search(list: List[Int], target: Int): Boolean = {
    list.contains(target)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5)
    val target = 3
    println(s"Is $target in the list? ${search(list, target)}")
  }
}
