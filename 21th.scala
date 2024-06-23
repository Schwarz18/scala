import org.apache.spark.sql.SparkSession

object PartitionEmployee {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("PartitionEmployee")
      .master("local[*]")
      .getOrCreate()

    // Load Employee table (example data)
    val employeeDF = spark.read.json("employee.json") // Example: load from JSON file

    // Partition by Dept and create hashed partitions
    val partitionedDF = employeeDF.repartition(4, $"Dept")

    // Write partitioned data to storage (e.g., HDFS, local disk)
    partitionedDF.write.partitionBy("Dept").json("partitionedEmployee")

    spark.stop()
  }
}
