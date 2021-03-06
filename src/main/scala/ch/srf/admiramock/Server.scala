package ch.srf.admiramock

import java.util.concurrent.{ExecutorService, Executors}

import scala.util.Properties.envOrNone

import scalaz.concurrent.Task

import org.http4s.server.{Server, ServerApp}
import org.http4s.server.blaze.BlazeBuilder


object BlazeExample extends ServerApp {

  val port : Int              =  8089
  val ip   : String           = "0.0.0.0"
  val pool : ExecutorService  = Executors.newCachedThreadPool()

  override def server(args: List[String]): Task[Server] =
    BlazeBuilder
      .bindHttp(port, ip)
      .mountService(Admira.service)
      .withServiceExecutor(pool)
      .start
}
