package calculator.model

import calculator.model.States.{CalculatorBase, ClearCalculator}

class Calculator() {

     var Sides: Array[Double] = Array(0, 0)
     var Decimal: String = ""
     var DisplayString: String = Sides(0).toString
     var Degrees: Boolean = true

     // Map of operation functions
     val Operations: Map[String, () => Double] = Map(
          "+" -> { () => this.Sides(0) + this.Sides(1) },
          "-" -> { () => this.Sides(0) - this.Sides(1) },
          "*" -> { () => this.Sides(0) * this.Sides(1) },
          "/" -> { () => this.Sides(0) / this.Sides(1) }
     )

     // TODO: EXPANSION
     val DegRad: Map[Boolean, () => Double] = Map(
          true -> { () => this.Sides(this.CurrentSide) },
          false -> { () => math.toRadians(this.Sides(this.CurrentSide)) }
     )
     val TrigOps: Map[Boolean, () => Double] = Map(
          true -> { () => math.sin(DegRad(Degrees)()) }, // DEGREE
          false -> { () => math.cos(DegRad(Degrees)()) }
     )
     // TODO: END EXPANSION

     var CurrentSide: Int = 0 // 0 for Left, 1 for Right
     var CurrentOperator: String = "+" // String to select from Operations map
     var PreviousOperator: String = "+" // Previous. duh.

     var State: CalculatorBase = new ClearCalculator(this)

     // Accessed by View. You should edit this method as you build functionality
     def displayNumber(): Double = {
          this.State.displayNumber()
     }

     def clearPressed(): Unit = {
          this.State.clearPressed()
     }

     def numberPressed(number: Int): Unit = {
          this.State.numberPressed(number)
     }

     def dividePressed(): Unit = {
          this.State.dividePressed()
     }

     def multiplyPressed(): Unit = {
          this.State.multiplyPressed()
     }

     def subtractPressed(): Unit = {
          this.State.subtractPressed()
     }

     def addPressed(): Unit = {
          this.State.addPressed()
     }

     def equalsPressed(): Unit = {
          this.State.equalsPressed()
     }

     def decimalPressed(): Unit = {
          this.State.decimalPressed()
     }

     // TODO: EXPANSION
     def negatePressed(): Unit = {
          this.State.negatePressed()
     }

     def cosPressed(): Unit = {
          this.State.cosPressed()
     }

     def sinPressed(): Unit = {
          this.State.sinPressed()
     }

     def degPressed(): Unit = {
          this.State.degPressed()
     }

}
