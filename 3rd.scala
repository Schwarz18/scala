object BookCount {
  def main(args: Array[String]): Unit = {
    val books = List(
      ("Dr. Seuss", "How the Grinch Stole Christmas!"),
      ("Jon Stone", "Monsters at the End of This Book"),
      ("Dr. Seuss", "The Lorax"),
      ("Jon Stone", "Big Bird in China"),
      ("Dr. Seuss", "One Fish, Two Fish, Red Fish, Blue Fish")
    )

    val bookCount = books.groupBy(_._1).mapValues(_.size)
    
    bookCount.foreach { case (author, count) => println(s"$author: $count books") }
  }
}
