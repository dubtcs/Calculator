package calculator.model.States

import calculator.model._

class NewStep(curCalc: Calculator) extends CalculatorBase {

     // Mostly the same as ClearCalculator without variable reset

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

     override def equalsPressed(): Unit = {
          curCalc.State = new EqualState(curCalc)
     }

     override def addPressed(): Unit = {
          curCalc.CurrentOperator = "+"
          curCalc.State = new OperatorBuffer(curCalc)
     }
     override def subtractPressed(): Unit = {
          curCalc.CurrentOperator = "-"
          curCalc.State = new OperatorBuffer(curCalc)
     }
     override def multiplyPressed(): Unit = {
          curCalc.CurrentOperator = "*"
          curCalc.State = new OperatorBuffer(curCalc)
     }
     override def dividePressed(): Unit = {
          curCalc.CurrentOperator = "/"
          curCalc.State = new OperatorBuffer(curCalc)
     }

     // EXPANSION

     def UpdateString(): Unit = {
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString
     }

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
