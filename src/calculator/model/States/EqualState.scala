package calculator.model.States

import calculator.model._

class EqualState(curCalc: Calculator) extends CalculatorBase {

     println(curCalc.Sides(0))
     println(curCalc.CurrentOperator)
     println(curCalc.Sides(1))

     curCalc.Sides(0) = curCalc.Operations(curCalc.CurrentOperator)()
     curCalc.Sides(1) = 0
     curCalc.CurrentSide = 1
     curCalc.DisplayString = curCalc.Sides(0).toString

     // Local method
     def ResetCalculator(): Unit = {
          curCalc.Sides = Array( 0.0, 0.0 )
          curCalc.CurrentSide = 0
          curCalc.Decimal = ""
          curCalc.DisplayString = curCalc.Sides(0).toString
     }

     override def displayNumber(): Double = {
          curCalc.DisplayString.toDouble
     }

     override def numberPressed(Number: Int): Unit = {
          ResetCalculator()
          curCalc.Sides(curCalc.CurrentSide) = curCalc.Sides(curCalc.CurrentSide) * 10 + Number
          curCalc.DisplayString = curCalc.Sides(curCalc.CurrentSide).toString // Set display string to currently active side
          curCalc.State = new NewStep(curCalc)
     }

     override def clearPressed(): Unit = {
          curCalc.State = new ClearCalculator(curCalc)
     }

     override def decimalPressed(): Unit = {
          ResetCalculator()
          curCalc.State = new DecimalPressed(curCalc)
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
     override def equalsPressed(): Unit = {
          // We just hit equals tf you doing?
     }

     // TODO: EXPANSION
     def UpdateString(): Unit = {
          curCalc.DisplayString = curCalc.Sides(0).toString
     }

     override def negatePressed(): Unit = {
          curCalc.Sides(curCalc.CurrentSide) *= -1
          curCalc.DisplayString = curCalc.Sides(0).toString
     }

     override def cosPressed(): Unit = {
          curCalc.CurrentSide = 0
          curCalc.Sides(curCalc.CurrentSide) = curCalc.TrigOps(false)()
          UpdateString()
          curCalc.CurrentSide = 1
     }

     override def degPressed(): Unit = {
          curCalc.Degrees = !curCalc.Degrees
     }

     override def sinPressed(): Unit = {
          curCalc.CurrentSide = 0
          curCalc.Sides(curCalc.CurrentSide) = curCalc.TrigOps(true)()
          UpdateString()
          curCalc.CurrentSide = 1
     }

}
