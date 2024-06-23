object ItemOperations {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("ItemOperations")
      .master("local[*]")
      .getOrCreate()

    val sc = spark.sparkContext

    var items = sc.parallelize(Seq(("Butter", 20), ("Bun", 10), ("Egg", 7), ("Biscuit", 25), ("Bread", 15)))

    // i. Display item-name and quantity
    items.collect().foreach{ case (item, qty) => println(s"$item: $qty") }

    // ii. Display sum of quantity and total number of items
    val totalQuantity = items.map(_._2).sum()
    val totalItems = items.count()
    println(s"Total quantity: $totalQuantity, Total items: $totalItems")

    // iii. Add 3 Buns to the collection
    items = items.map { case (item, qty) =>
      if (item == "Bun") (item, qty + 3) else (item, qty)
    }

    // iv. Add new item "Cheese" with quantity 12 to the collection
    items = items.union(sc.parallelize(Seq(("Cheese", 12))))

    // Display updated collection
    items.collect().foreach{ case (item, qty) => println(s"$item: $qty") }

    spark.stop()
  }
}
