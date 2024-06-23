import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf

object StreamingWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("StreamingWordCount").setMaster("local[*]")
    val ssc = new StreamingContext(conf, Seconds(5))

    // Create a DStream that will connect to localhost:9999
    val lines = ssc.socketTextStream("localhost", 9999)

    // Split each line into words
    val words = lines.flatMap(_.split("\\s+"))

    // Map each word to (word, 1) and then reduce by key to count occurrences
    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _)

    // Print the word counts
    wordCounts.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
