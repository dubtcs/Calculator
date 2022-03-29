package calculator.model.States

import calculator.model._

class ClearCalculator(curCalc: Calculator) extends CalculatorBase {

     // Reset variables
     curCalc.Sides = Array(0.0, 0.0)
     curCalc.CurrentSide = 0
     curCalc.Decimal = ""
     curCalc.DisplayString = curCalc.Sides(0).toString

     def UpdateString(): Unit = {
          curCalc.DisplayString = curCalc.Sides(0).toString
     }

     override def displayNumber(): Double = {
          curCalc.DisplayString.toDouble
     }

     override def numberPressed(Number: Int): Unit = {
          curCalc.Sides(curCalc.CurrentSide) = curCalc.Sides(curCalc.CurrentSide) * 10 + Number
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString // Set display string to currently active side
     }

     override def decimalPressed(): Unit = {
          curCalc.State = new DecimalPressed(curCalc)
     }

     override def clearPressed(): Unit = {
          curCalc.State = new ClearCalculator(curCalc)
     }

     override def addPressed(): Unit = {
          curCalc.PreviousOperator = curCalc.CurrentOperator
          curCalc.CurrentOperator = "+"
          curCalc.State = new FirstBuffer(curCalc)
     }

     override def subtractPressed(): Unit = {
          curCalc.PreviousOperator = curCalc.CurrentOperator
          curCalc.CurrentOperator = "-"
          curCalc.State = new FirstBuffer(curCalc)
     }

     override def multiplyPressed(): Unit = {
          curCalc.PreviousOperator = curCalc.CurrentOperator
          curCalc.CurrentOperator = "*"
          curCalc.State = new FirstBuffer(curCalc)
     }

     override def dividePressed(): Unit = {
          curCalc.PreviousOperator = curCalc.CurrentOperator
          curCalc.CurrentOperator = "/"
          curCalc.State = new FirstBuffer(curCalc)
     }

     override def equalsPressed(): Unit = {
          // None
     }

     // TODO: EXPANSION
     override def negatePressed(): Unit = {
          curCalc.Sides(curCalc.CurrentSide) *= -1
          curCalc.DisplayString = curCalc.Sides(0).toString
     }

     override def cosPressed(): Unit = {
          curCalc.Sides(curCalc.CurrentSide) = curCalc.TrigOps(false)()
          UpdateString()
     }

     override def degPressed(): Unit = {
          curCalc.Degrees = !curCalc.Degrees
     }

     override def sinPressed(): Unit = {
          curCalc.Sides(curCalc.CurrentSide) = curCalc.TrigOps(true)()
          UpdateString()
     }

}
