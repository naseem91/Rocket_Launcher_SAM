import scala.scalajs.js
import js.Dynamic.global

class Model(var counter: Int,var started: Boolean, var launched: Boolean,var aborted: Boolean) {

  def present(data:Model ) {
    if (Demo.state.counting(Demo.model)) {
      if (Demo.model.counter == 0) {
        Demo.model.launched = data.launched || false
      }
      else {
        Demo.model.aborted = data.aborted || false
        if (data.counter != null) {
          Demo.model.counter = data.counter
        }
      }
    }else{
      if (Demo.state.ready(Demo.model)) {
        Demo.model.started = data.started || false
      }
    }
    Demo.state.render(Demo.model)
    return false

  }

}
