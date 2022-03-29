package calculator.model.States

abstract class CalculatorBase {

     def displayNumber(): Double
     def clearPressed(): Unit
     def numberPressed(Number: Int): Unit
     def dividePressed(): Unit
     def multiplyPressed(): Unit
     def addPressed(): Unit
     def subtractPressed(): Unit
     def equalsPressed(): Unit
     def decimalPressed(): Unit
     def negatePressed(): Unit
     def cosPressed(): Unit
     def sinPressed(): Unit
     def degPressed(): Unit

}
