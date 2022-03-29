package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestFullFunctionality extends FunSuite {

     val EPSILON: Double = 0.000001
     def equalDoubles(d1: Double, d2: Double): Boolean = {
          (d1 - d2).abs < EPSILON
     }

     test("3*+4="){

          val calc: Calculator = new Calculator()

          calc.numberPressed(3)
          assert(calc.displayNumber() == 3)

          calc.multiplyPressed()
          assert(calc.displayNumber() == 3)
          calc.addPressed()
          assert(calc.displayNumber() == 3)

          calc.numberPressed(4)
          assert(calc.displayNumber() == 4)

          calc.equalsPressed()
          assert(calc.displayNumber() == 7)

     }

     test("1+2*.8="){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          assert(calc.displayNumber() == 1)
          calc.addPressed()
          calc.numberPressed(2)
          assert(calc.displayNumber() == 2)
          calc.multiplyPressed()
          calc.decimalPressed()
          calc.numberPressed(8)
          assert(calc.displayNumber() == 0.8)
          calc.equalsPressed()
          assert(equalDoubles(calc.displayNumber(), 2.4), calc.displayNumber())

     }

     test("1+1=3"){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          assert(calc.displayNumber() == 1)
          calc.addPressed()
          assert(calc.displayNumber() == 1)

          calc.numberPressed(1)
          assert(calc.displayNumber() == 1)

          calc.equalsPressed()
          assert(calc.displayNumber() == 2)

          calc.numberPressed(3)
          assert(calc.displayNumber() == 3)

     }

     test("1+1 c 2+3= +4="){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          assert(calc.displayNumber() == 1)
          calc.addPressed()
          calc.numberPressed(1)
          assert(calc.displayNumber() == 1)

          calc.clearPressed()
          assert(calc.displayNumber() == 0)

          calc.numberPressed(2)
          assert(calc.displayNumber() == 2)
          calc.addPressed()
          calc.numberPressed(3)
          assert(calc.displayNumber() == 3)
          calc.equalsPressed()
          assert(calc.displayNumber() == 5)
          calc.addPressed()
          calc.numberPressed(4)
          assert(calc.displayNumber() == 4)
          calc.equalsPressed()
          assert(calc.displayNumber() == 9)

     }

     test("Clear"){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          calc.addPressed()
          calc.numberPressed(1)

          calc.clearPressed()

          assert(calc.displayNumber() == 0)

          calc.addPressed()
          calc.numberPressed(1)
          assert(calc.displayNumber() == 1)

     }

     test("Clear?"){

          val calc: Calculator = new Calculator()

          calc.numberPressed(1)
          calc.clearPressed()
          assert(calc.displayNumber() == 0)
          calc.numberPressed(3)
          calc.addPressed()
          calc.numberPressed(1)
          calc.equalsPressed()
          assert(calc.displayNumber() == 4)

          calc.clearPressed()
          calc.addPressed()
          calc.numberPressed(5)
          calc.equalsPressed()
          assert(calc.displayNumber() == 5)

     }

}
