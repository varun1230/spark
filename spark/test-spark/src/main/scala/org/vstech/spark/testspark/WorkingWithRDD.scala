package org.vstech.spark.testspark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.util.Random

object WorkingWithRDD {
  
  def main(args: Array[String]): Unit = {
    
    
    val sparkConf = new SparkConf().setAppName("Working With RDD").setMaster("local")
    val sc = new SparkContext(sparkConf)
    
    val textFileRDD = sc.textFile("sample.txt", 2);
    val wordRDD = textFileRDD.flatMap(x => x.split(" "))
    println("Word of text file sample.txt"+wordRDD.collect().toList)
    val wordCountRDD = wordRDD.map(word => (word, 1))
//    println("Word count of each from file sample.txt"+wordCountRDD.collect().toList)
    val reduceWordCount = wordCountRDD.reduceByKey((x, y) => (x+y))
    reduceWordCount.saveAsTextFile("output"+Random.nextInt()+".txt")
    
    
//    println("Number of working in text file sample.txt"+reduceWordCount.collect().toList)
    
    
    
    
    val numrdd = sc.parallelize(List(1, 2, 3,4, 5, 6), 2)
    
    println("number from RDD")
    numrdd.foreach(x => print(x))
    
    val colorRDD = sc.parallelize(List("red", "blue", "greem", "yellow", "red", "black"), 2)
 
    println("Colors from RDD")
    colorRDD.foreach(x => print(x))
    
    val colorMapRDD = colorRDD.map(x => (x.length, x))
    println(" Color Map RDD as a list "+ colorMapRDD.collect().toList)
    println("Color Map rdd looping individually")
    colorMapRDD.foreach(x => print(x ))
    
    case class Employee( id:String, fname:String, lname:String)
    
    
  }
}