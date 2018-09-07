package org.vstech.spark.textanalyzer

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object TextAnalyzer {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setAppName("Text Analyzer").setMaster("local")
    val sc = new SparkContext(conf)
    
    
    
    
  }
}