package org.vstech.spark.testspark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WorkingWithPairRDD {
  def main(): Unit = {
    val conf = new SparkConf().setAppName("Working With PairRDD").setMaster("local")
    val sc = new SparkContext(conf)
    
    /*
     Transformations 
     flatMap
     map
     join
     cogroup
     union
     intersection
     subtract
     */
    
    val pairRddx = sc.parallelize(List((1,2), (3, 4), (3, 6)), 1)
    val pairRddy = sc.parallelize(List((1, 8), (4, 9)), 1)
    
//    val flatMapRdd = pairRddx.flatMapValues(x => (x, 1))
    
    
//    Seq(1, 2, 3, 4)  flatmap { x => Seq (x, -x)}
    
    
  }
}