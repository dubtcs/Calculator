package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFourFunctions extends FunSuite {

     val EPSILON: Double = 0.000001
     def equalDoubles(d1: Double, d2: Double): Boolean = {
          (d1 - d2).abs < EPSILON
     }

     test("5*4="){

          val calc: Calculator = new Calculator()

          calc.numberPressed(5)
          assert(calc.displayNumber() == 5)

          calc.multiplyPressed()
          assert(calc.displayNumber() == 5)

          calc.numberPressed(4)
          assert(calc.displayNumber() == 4)

          calc.equalsPressed()
          assert(calc.displayNumber() == 20)

     }

     test("3+4.3="){

          val calc: Calculator = new Calculator()

          calc.numberPressed(3)
          assert(calc.displayNumber() == 3)

          calc.addPressed()
          assert(calc.displayNumber() == 3)

          calc.numberPressed(4)
          assert(calc.displayNumber() == 4)
          calc.decimalPressed()
          assert(calc.displayNumber() == 4)
          calc.numberPressed(3)
          assert( equalDoubles(calc.displayNumber(), 4.3), calc.displayNumber() )

          calc.equalsPressed()
          assert( equalDoubles(calc.displayNumber(), 7.3), calc.displayNumber() )

     }

     test("div sub"){

          val calc: Calculator = new Calculator()

          calc.numberPressed(10)
          calc.dividePressed()
          calc.numberPressed(2)
          calc.equalsPressed()
          assert(calc.displayNumber() == 5)

          calc.clearPressed()

          calc.numberPressed(5)
          calc.subtractPressed()
          calc.numberPressed(2)
          calc.equalsPressed()
          assert(calc.displayNumber() == 3)

     }

     test("Rhs dec"){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          calc.addPressed()
          calc.decimalPressed()
          calc.numberPressed(1)
          assert(equalDoubles(calc.displayNumber(), 0.1), calc.displayNumber())

          calc.equalsPressed()
          assert(equalDoubles(calc.displayNumber(), 1.1), calc.displayNumber())

          calc.addPressed()
          calc.decimalPressed()
          calc.numberPressed(1)
          calc.equalsPressed()

          assert(equalDoubles(calc.displayNumber(), 1.2), calc.displayNumber())

     }

     test("RHS"){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          calc.decimalPressed()
          calc.numberPressed(1)
          assert(equalDoubles(calc.displayNumber(), 1.1), calc.displayNumber())
          calc.addPressed()
          calc.numberPressed(1)
          calc.decimalPressed()
          calc.numberPressed(1)
          calc.decimalPressed()
          calc.numberPressed(1)
          calc.equalsPressed()
          assert(equalDoubles(calc.displayNumber(), 2.21), calc.displayNumber())

     }

}
