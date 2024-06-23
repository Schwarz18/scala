object WordLength {
  def wordLengths(words: Array[String]): (String, Int) = {
    val wordLengths = words.map(word => (word, word.length))
    val maxLengthWord = wordLengths.maxBy(_._2)
    maxLengthWord
  }

  def main(args: Array[String]): Unit = {
    val words = Array("games", "television", "rope", "table")
    val (maxWord, maxLength) = wordLengths(words)
    println(s"Word with the highest length: $maxWord, Length: $maxLength")
  }
}
