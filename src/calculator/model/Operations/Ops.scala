package calculator.model.Operations

object Ops {

     def mult(numbers: Array[Double]): Double = {
          numbers(0) * numbers(1)
     }

     def add(numbers: Array[Double]): Double = {
          println(numbers(0) + numbers(1))
          numbers(0) + numbers(1)
     }

     def sub(numbers: Array[Double]): Double = {
          numbers(0) - numbers(1)
     }

     def div(numbers: Array[Double]): Double = {
          numbers(0) / numbers(1)
     }

}
