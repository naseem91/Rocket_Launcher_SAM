
import scala.scalajs.js.annotation.JSExportTopLevel

object Demo {
  val counter_Max = 10
  var model = new Model(counter_Max, false, false, false)
  var view = new View()
  var state = new State(view)
  var action = new Action

  def main(args: Array[String]): Unit = {
    view.init(model)
  }

  @JSExportTopLevel("fun2")
  def fun2(): Unit = {
    action.start(model, model.present)
  }

  @JSExportTopLevel("fun")
  def fun(): Unit = {
    action.abort(model, model.present)
  }
}
