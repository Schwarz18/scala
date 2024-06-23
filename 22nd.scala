import org.apache.spark.sql.SparkSession

object AverageOfItems {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("AverageOfItems")
      .master("local[*]")
      .getOrCreate()

    // Load data from CSV file
    val itemsDF = spark.read.option("header", "true").csv("items.csv")

    // Convert column to RDD and compute average
    val itemsRDD = itemsDF.select("value").rdd.map(row => row.getString(0).toInt)
    val average = itemsRDD.sum() / itemsRDD.count().toDouble

    // Display average
    println(s"Average of items: $average")

    spark.stop()
  }
}
