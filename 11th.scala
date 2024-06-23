object FactorialCalculation {
  
  // Function to calculate factorial of a single integer
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  
  // Function to compute factorial for each item in a collection
  def factorialForEach(collection: Iterable[Int]): Iterable[Int] = {
    collection.map(factorial)
  }
  
  def main(args: Array[String]): Unit = {
    // Example usage
    val numbers = List(3, 4, 5, 6, 7)
    val factorialResults = factorialForEach(numbers)
    
    // Print results
    println("Factorial results:")
    factorialResults.foreach(println)
  }
}
