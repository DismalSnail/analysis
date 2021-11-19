import scalax.collection.Graph
import scalax.collection.GraphPredef._
import scalax.collection.GraphEdge._

object GraphInit {

  def generateEdge(starts: Seq[Int], end: Seq[Int]): List[Param[Int, HyperEdge]] = {
    if (starts.nonEmpty) {
      List(starts.head ~ end.head) ::: generateEdge(starts.tail, end.tail)
    } else {
      Nil
    }
  }

  def main(args: Array[String]): Unit = {
    val start = List(1, 2, 3, 4, 5, 6)
    val end = List(2, 3, 4, 5, 6, 7)
    val value: Graph[Int, HyperEdge] = Graph(generateEdge(start, end): _*)
    value.nodes.foreach(println)

  }
}