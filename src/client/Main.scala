import lilith.protocol.Schema._
import sttp.client.quick._

object Main extends App {
  val x = Query.GenreCollection
    .toRequest(uri"https://graphql.anilist.co")
    .send()

  println(x)
}
