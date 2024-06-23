object CapitalizeWords {
  def capitalizeWords(sentence: String): String = {
    sentence.split(" ").map(_.capitalize).mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    val sentence = "hello world from scala"
    val capitalizedSentence = capitalizeWords(sentence)
    println(capitalizedSentence)
  }
}
