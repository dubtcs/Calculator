package calculator.model.States

import calculator.model.Calculator

class FirstBuffer (curCalc: Calculator) extends CalculatorBase {

     // First buffer exists to prevent and multiplication or division being 0 or infinity

     override def displayNumber(): Double = {
          curCalc.DisplayString.toDouble
     }

     override def clearPressed(): Unit = {
          curCalc.State = new ClearCalculator(curCalc)
     }

     override def numberPressed(Number: Int): Unit = {
          curCalc.CurrentSide = 1
          curCalc.Sides(curCalc.CurrentSide) = curCalc.Sides(curCalc.CurrentSide) * 10 + Number
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString
          curCalc.State = new NewStep(curCalc)
     }

     override def decimalPressed(): Unit = {
          curCalc.Sides(0) = curCalc.Operations(curCalc.CurrentOperator)()
          curCalc.Sides(1) = 0
          curCalc.CurrentSide = 1
          curCalc.State = new DecimalPressed(curCalc)
     }

     override def equalsPressed(): Unit = {
          curCalc.State = new EqualState(curCalc)
     }

     override def dividePressed(): Unit = {
          curCalc.CurrentOperator = "/"
     }
     override def multiplyPressed(): Unit = {
          curCalc.CurrentOperator = "*"
     }
     override def subtractPressed(): Unit = {
          curCalc.CurrentOperator = "-"
     }
     override def addPressed(): Unit = {
          curCalc.CurrentOperator = "+"
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
