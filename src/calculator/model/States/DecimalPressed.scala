package calculator.model.States

import calculator.model._

class DecimalPressed(curCalc: Calculator) extends CalculatorBase {

     curCalc.Decimal = "" // Set it to _ so I don't have to every time it's called

     def UpdateString(): Unit = {
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString
     }

     override def displayNumber(): Double = {
          curCalc.DisplayString.toDouble
     }

     override def numberPressed(Number: Int): Unit = {
          curCalc.Decimal = curCalc.Decimal + Number.toString
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toInt.toString + "." + curCalc.Decimal
          println(curCalc.DisplayString)
          curCalc.Sides(curCalc.CurrentSide) = curCalc.DisplayString.toDouble
     }

     override def equalsPressed(): Unit = {
          curCalc.State = new EqualState(curCalc)
     }

     override def clearPressed(): Unit = {
          curCalc.State = new ClearCalculator(curCalc)
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

     // Not used
     override def decimalPressed(): Unit = {
          // None
     }

     // EXPANSION

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
