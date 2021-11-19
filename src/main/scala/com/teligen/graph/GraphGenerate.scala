package com.teligen.graph

import GraphType._
import com.teligen.GraphBoot
import com.teligen.datatype.InputData
import scalax.collection.Graph
import scalax.collection.GraphEdge.{DiEdge, EdgeLike, HyperEdge, UnDiEdge}
import scalax.collection.GraphPredef.{EdgeLikeIn, Param}
import scalax.collection.edge.{WDiEdge, WUnDiEdge}

object GraphGenerate {
  /**
   * 从给定带边集合创建图
   *
   * @param kind
   * @param jsonData
   * @tparam N
   * @tparam E
   */
  def generateGraphFromEdge[N, E](data:InputData):Graph[String,HyperEdge] = {

    val edges: List[Param[String, HyperEdge]] = data.kind match {
      case DirectedGraph => GraphGenerate.generateDiEdge(data.node1, data.node2)
      case WeightedDirectedGraph => GraphGenerate.generateWDiEdge(data.node1, data.node2, data.weight)
      case UnDirectedGraph => GraphGenerate.generateEdge(data.node1, data.node2)
      case WeightedUndirectedGraph => GraphGenerate.generateWeightEdge(data.node1, data.node2, data.weight)
    }
    Graph(edges: _*)
  }

  /**
   * 通过两个节点的集合构造无向边集合
   *
   * @param node1 节点1
   * @param node2 节点2
   * @return 返回无向图边集合
   */
  def generateEdge(node1: Seq[String], node2: Seq[String]): List[Param[String, UnDiEdge]] = {
    if (node1.nonEmpty) {
      UnDiEdge(node1.head, node2.head) :: generateEdge(node1.tail, node2.tail)
    } else {
      Nil
    }
  }

  /**
   * 通过两个节点集合构造带权的边集合
   *
   * @param node1  节点1
   * @param node2  节点2
   * @param weight 权重
   * @return 带权重带无向图边集合
   */
  def generateWeightEdge(node1: Seq[String], node2: Seq[String], weight: Seq[Double]): List[Param[String, WUnDiEdge]] = {
    if (node1.nonEmpty) {
      WUnDiEdge(node1.head, node2.head)(weight.head) :: generateWeightEdge(node1.tail, node2.tail, weight.tail)
    } else {
      Nil
    }
  }

  /**
   * 通过两个节点构造有向边带集合
   *
   * @param from 起点
   * @param to   终点
   * @return 不带权重带有向边集合
   */
  def generateDiEdge(from: Seq[String], to: Seq[String]): List[Param[String, DiEdge]] = {
    if (from.nonEmpty) {
      DiEdge(from.head, to.head) :: generateDiEdge(from.tail, to.tail)
    } else {
      Nil
    }
  }

  /**
   * 通过两个节点构造有向带权边
   *
   * @param from   起点
   * @param to     终点
   * @param weight 权重
   * @return 带权有向边集合
   */
  def generateWDiEdge(from: Seq[String], to: Seq[String], weight: Seq[Double]): List[Param[String, WDiEdge]] = {
    if (from.nonEmpty) {
      WDiEdge(from.head, to.head)(weight.head) :: generateWDiEdge(from.tail, to.tail, weight.tail);
    } else {
      Nil
    }
  }


}

class GraphGenerate {

}
