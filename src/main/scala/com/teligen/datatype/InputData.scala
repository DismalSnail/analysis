package com.teligen.datatype

/**
 * 输入数据格式
 * @param kind 图种类
 * @param node1 节点集合1
 * @param node2 节点集合2
 * @param weight 权重集合
 */
case class InputData(kind: String, node1: Seq[String], node2: Seq[String], weight: Seq[Double])
