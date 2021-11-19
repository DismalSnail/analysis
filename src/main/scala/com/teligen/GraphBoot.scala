package com.teligen

import com.alibaba.fastjson.JSON
import com.teligen.datatype.InputData

object GraphBoot {

  /**
   * 获取最短路径
   *
   * @param jsonString 数据
   * @return
   */
  def getVerticesShortestPath(jsonString: String): String = {
    val data: InputData = JSON.parseObject(jsonString, classOf[InputData])
    shortestPath(data)

  }

  private def shortestPath(data: InputData): String = {

  }

}
