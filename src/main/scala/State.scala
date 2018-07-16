import scala.scalajs.js.Dynamic.global

class State(view: View) {
  def representation(model: Model){
    //    var representation = "oops... something went wrong, the system is in an invalid state" ;

    if (Demo.state.ready(model)) {
      Demo.view.ready(model) ;
    }

    if (Demo.state.counting(model)) {
      Demo.view.counting(model) ;
    }

    if (Demo.state.launched(model)) {
      Demo.view.launched(model) ;
    }

    if (Demo.state.aborted(model)) {
      Demo.view.aborted(model) ;
    }
    //    Demo.view.display(representation) ;
  }

  def ready(model: Model): Boolean = {
    ((model.counter == Demo.counter_Max) && !model.started && !model.launched && !model.aborted) // === for counter
  }
  def counting(model:Model):Boolean={
    ((model.counter <= Demo.counter_Max) && (model.counter >= 0) && model.started && !model.launched && !model.aborted)
  }

  def render (model: Model): Unit ={
    Demo.state.representation(model)
    Demo.state.nextAction(model) ;//state.nextAction
  }

  def launched(model: Model):Boolean={

    ((model.counter == 0) && model.started && model.launched && !model.aborted)
  }

  def aborted(model: Model):Boolean={(
    (  model.counter <= Demo.counter_Max) && (model.counter >= 0) && model.started && !model.launched && model.aborted )
  }

  def nextAction(model:Model)={
    if (Demo.state.counting(model)) {
      if (model.counter>0) {
        Demo.action.decrement(model,model.present) ;
      }

      if (model.counter == 0) {
        Demo.action.launch(model,model.present) ;
      }
    }
  }

}
