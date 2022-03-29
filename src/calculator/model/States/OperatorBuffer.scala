package calculator.model.States

import calculator.model._

class OperatorBuffer(curCalc: Calculator) extends CalculatorBase {

     override def displayNumber(): Double = {
          curCalc.DisplayString.toDouble
     }

     override def clearPressed(): Unit = {
          curCalc.State = new ClearCalculator(curCalc)
     }

     override def numberPressed(Number: Int): Unit = {
          //println(curCalc.Sides(0).toString + " " + curCalc.PreviousOperator + " " +curCalc.Sides(1))
          curCalc.Sides(0) = curCalc.Operations(curCalc.PreviousOperator)()
          curCalc.Sides(1) = 0
          curCalc.CurrentSide = 1
          curCalc.Sides(curCalc.CurrentSide) = curCalc.Sides(curCalc.CurrentSide) * 10 + Number
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString
          curCalc.State = new NewStep(curCalc)
     }

     override def decimalPressed(): Unit = {
          curCalc.Sides(0) = curCalc.Operations(curCalc.PreviousOperator)()
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

     // TODO: EXPANSION
     def UpdateString(): Unit = {
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString
     }

     override def negatePressed(): Unit = {

     }

     override def cosPressed(): Unit = {

     }

     override def degPressed(): Unit = {

     }

     override def sinPressed(): Unit = {

     }

}
