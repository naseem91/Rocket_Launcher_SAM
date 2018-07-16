import org.scalajs.dom.document

import scala.scalajs.js.Dynamic.global

class View {
  def init(model: Model): Unit = {
    Demo.view.ready(model)
  }

  def ready(model: Model) {
    val btn = global.document.createElement("input")
    btn.setAttribute("type", "button")
    btn.setAttribute("id", "btn")
    var counter = document.getElementById("counter")
    counter.innerHTML = "Counter : " + model.counter
    btn.setAttribute("value", "start")
    btn.setAttribute("onclick", "fun2()")
    global.document.body.appendChild(btn)
  }

  def counting(model: Model){
    var counter = document.getElementById("counter")
    counter.innerHTML = "Counter down : " + model.counter
    var input = document.getElementById("btn")
    input.setAttribute("value", "Abort")
    //    input.setAttribute("onclick", Demo.action.abort(model,model.present))
    input.setAttribute("onclick", "fun()")
  }

  def aborted(model: Model) {
    var input = document.getElementById("btn")
    global.document.body.removeChild(input)
    var counter = document.getElementById("counter")
    counter.innerHTML = "Aborted at Counter:" + model.counter
  }

  def launched(model: Model) {
    var counter = document.getElementById("counter")
    counter.innerHTML = "Launched"
    var input = document.getElementById("btn")
    global.document.body.removeChild(input)
  }

  // TOCheck
  //  def display(represnation: String) = {
  //    var stateRepresentation = document.getElementById("counter");
  //    stateRepresentation.innerHTML = represnation;
  //  }
}
