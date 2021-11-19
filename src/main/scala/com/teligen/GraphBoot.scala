package com.teligen

import com.alibaba.fastjson.JSON
import scalax.collection.edge.Implicits._
import com.teligen.datatype.InputData
import com.teligen.graph.GraphGenerate
import scalax.collection.{Graph, GraphEdge}

object GraphBoot {

  /**
   * 获取最短路径
   *
   * @param jsonString 数据
   * @return
   */
  def getVerticesShortestPath(jsonString: String): String = {
    val data: InputData = JSON.parseObject(jsonString, classOf[InputData])
    var value: Graph[String, GraphEdge.HyperEdge] = GraphGenerate.generateGraphFromEdge(data)
     val maybePath: Option[Graph[String, GraphEdge.HyperEdge]#Path] = value.get("A") shortestPathTo value.get("B")
    maybePath.toString
  }

  private def shortestPath(data: InputData): String = {
  }

}
