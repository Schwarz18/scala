import org.apache.spark.{SparkConf, SparkContext}

object RDDConstruction {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDConstruction").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // Example collection
    val data = List(11, 34, 45, 67, 3, 4, 90)

    // Create RDD with 3 partitions
    val rdd = sc.parallelize(data, numSlices = 3)

    // i. Illustrate how Spark context constructs RDD
    println("RDD Construction:")
    rdd.glom().collect().zipWithIndex.foreach { case (part, index) =>
      println(s"Partition $index contents: ${part.mkString(", ")}")
    }

    // ii. Using mapPartitionsWithIndex to increment each element by 1
    val incrementedRDD = rdd.mapPartitionsWithIndex { (index, iter) =>
      iter.map(num => num + 1)
    }

    // Display incremented values
    println("\nAfter incrementing each element by 1:")
    incrementedRDD.collect().foreach(println)

    sc.stop()
  }
}
