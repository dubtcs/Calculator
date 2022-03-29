package calculator.controller

import calculator.model.Calculator
import javafx.event.{ActionEvent, EventHandler}

/**
 * EventHandlers for each of the button on the calculator. NumberAction takes
 * an Int representing the which number button was pressed. You may assume
 * that each of these classes has a reference to the same Calculator object.
 */

class EqualAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.equalsPressed()
}

class ClearAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.clearPressed()
}

class DecimalAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.decimalPressed()
}

class NumberAction(calculator: Calculator, number: Int) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.numberPressed(number)
}

class AdditionAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.addPressed()
}

class SubtractionAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.subtractPressed()
}

class MultiplicationAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.multiplyPressed()
}

class DivisionAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.dividePressed()
}

// TODO: EXPASNSIONS
class NegateAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.negatePressed()
}

class CosAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.cosPressed()
}

class SinAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.sinPressed()
}

class DegAction(calculator: Calculator) extends EventHandler[ActionEvent] {
     override def handle(event: ActionEvent): Unit = calculator.degPressed()
}
