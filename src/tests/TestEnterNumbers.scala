package tests

import calculator.model.Calculator
import org.scalatest.FunSuite

class TestEnterNumbers extends FunSuite {

     val EPSILON: Double = 0.000001

     def equalDoubles(d1: Double, d2: Double): Boolean = {
          (d1 - d2).abs < EPSILON
     }

     // Example test case
     test("Enter Numbers Test") {
          val calculator: Calculator = new Calculator()

          calculator.numberPressed(1)
          calculator.numberPressed(2)
          calculator.numberPressed(5)

          assert(equalDoubles(calculator.displayNumber(), 125.0), calculator.displayNumber())
     }

     test("0-9") {

          val calc: Calculator = new Calculator()

          calc.numberPressed(6)
          assert(calc.displayNumber() == 6)
          calc.numberPressed(8)
          assert(calc.displayNumber() == 68)
          calc.numberPressed(9)
          assert(calc.displayNumber() == 689)

     }

     test("417") {
          val C: Calculator = new Calculator()

          C.numberPressed(4)
          assert(C.displayNumber() == 4)
          C.numberPressed(1)
          assert(C.displayNumber() == 41)
          C.numberPressed(7)
          assert(C.displayNumber() == 417)

     }

     test("00002.3") {
          val calc: Calculator = new Calculator()

          calc.numberPressed(0)
          calc.numberPressed(0)
          calc.numberPressed(0)
          calc.numberPressed(0)
          calc.numberPressed(2)
          assert(calc.displayNumber() == 2)
          calc.decimalPressed()
          assert(calc.displayNumber() == 2)
          calc.numberPressed(3)
          assert(equalDoubles(calc.displayNumber(), 2.3), calc.displayNumber())

     }

     test("2..3.5") {

          var calc: Calculator = new Calculator()

          calc.numberPressed(2)
          assert(calc.displayNumber() == 2)
          calc.decimalPressed()
          calc.decimalPressed()
          assert(calc.displayNumber() == 2)
          calc.numberPressed(3)
          assert(equalDoubles(calc.displayNumber(), 2.3), calc.displayNumber())
          calc.decimalPressed()
          calc.numberPressed(5)
          assert(equalDoubles(calc.displayNumber(), 2.35), calc.displayNumber())

     }

     test(".000.5") {

          val calc: Calculator = new Calculator()

          calc.decimalPressed()
          calc.numberPressed(0)
          assert(calc.displayNumber() == 0.0)
          calc.numberPressed(0)
          assert(calc.displayNumber() == 0.00)
          calc.numberPressed(0)
          assert(calc.displayNumber() == 0.000)
          calc.decimalPressed()
          assert(calc.displayNumber() == 0.000)
          calc.numberPressed(5)
          assert(calc.displayNumber() == 0.0005)

     }

}
