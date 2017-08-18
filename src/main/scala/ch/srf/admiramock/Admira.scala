package ch.srf.admiramock

import io.circe._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._

import scala.util.Random

object Admira {
  val service = HttpService {
    case POST -> Root  /"rest"/"jobs" / "jobtemplates" =>
      Ok(Json.obj("rc" -> Json.fromInt(0),"jobId" -> Json.fromInt(Math.abs(Random.nextInt()))))
  }
}
