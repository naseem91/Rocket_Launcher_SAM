import scala.scalajs.js.timers._

class Action {
  def start(data: Model, present: (Model) => Unit) {
    data.started = true
    present(data)
//    return false;
  }

  def decrement(data: Model, present: (Model => Unit)) {
    setTimeout(1000) {
      data.counter = data.counter - 1
      present(data)
    }
  }

  def launch(data: Model, present: (Model => Unit)) {
    data.launched = true
    present(data)
  }

  def abort(data: Model, present: (Model => Unit)): Boolean = {
    data.aborted = true
    present(data)
    return false
  }

}
