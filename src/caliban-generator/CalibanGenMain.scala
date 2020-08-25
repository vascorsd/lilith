import caliban.tools._
import zio._
import zio.console._
import zio.system._

object CalibanGenMain extends App {

  val program =
    env("MODULE_PATH").orDie.someOrFailException.flatMap { p =>
      Codegen.generate(
        Options(
          schemaPath = s"${p}/src/protocol/schema.graphql",
          toPath = s"${p}/src/protocol/Schema.scala",
          None,
          None,
          packageName = Some("lilith.protocol"),
          None
        ),
        ClientWriter.write
      )
    }

  def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    putStrLn("Generating 'scala' code/files from 'schema' file.") *>
      envs.orDie.flatMap(m => putStrLn(m.toList.sortBy(_._1).mkString("\n"))) *>
      program.catchAll(reason => putStrLn(reason.toString)).exitCode
  }
}
