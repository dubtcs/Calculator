package calculator.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Button

class CalculatorButton(display: String, action: EventHandler[ActionEvent], xScale: Double = 1.0, yScale: Double = 1.0) extends Button {
     val buttonSize: Int = 85
     minWidth = buttonSize * xScale
     minHeight = buttonSize * yScale
     onAction = action
     text = display
     style = "-fx-font: 30 ariel;"
}
