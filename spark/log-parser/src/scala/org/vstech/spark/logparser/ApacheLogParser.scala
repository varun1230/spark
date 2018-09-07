package org.vstech.spark.logparser

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object ApacheLogParser {
  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Apache Log parser").setMaster("local")
    val sc = new SparkContext(conf)
    
    sc.setLogLevel("WARN")
    
    val input_log_file = sc.textFile("web.log", 1)
    
    val warnline = input_log_file.filter{ x => x.toString().toUpperCase().contains("WARN") }
    
    val errorLine = input_log_file.filter(x => x.toString().toUpperCase().contains("ERROR"))
    
    println("Transformation is applied now applying actions to evaluate the warlines and error lines RDD")
    
    
    println("Warning Lines are "+warnline.count())
    
    println("10 sample Warning message " + warnline.take(10).foreach(println))
    
    println("Error Lines are "+errorLine.count())
    
    println("10 sample Error messages "+errorLine.take(10).foreach(println))
  
  }
  
  
  
}