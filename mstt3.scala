import akka.actor.{Actor, ActorSystem, Props}

class HelloActor(myName: String) extends Actor {
  def receive: Receive = {
    case "hello" => println("hello from %s".format(myName))
    case _       => println("'what?', said %s".format(myName))
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props(new HelloActor("Fred")), name = "helloactor")
  helloActor ! "hello"
  helloActor ! "bonjour"
}