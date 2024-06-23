object WordLength {
  def wordLengths(words: Array[String]): Array[(String, Int)] = {
    words.map(word => (word, word.length))
  }

  def main(args: Array[String]): Unit = {
    val words = Array("apple", "banana", "cherry")
    val lengths = wordLengths(words)
    lengths.foreach { case (word, length) => println(s"$word: $length") }
  }
}
