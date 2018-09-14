package org.vstech.spark.textanalyzer

object FilteredExam extends App{
  
  for(ln <- scala.io.StdIn.readLine())  {
    var str:String = ln.toString();
    println(powerOf2(str.toDouble))
  }
   def powerOf2(x:Double): Int = {
     println("Coming here 1 "+x)
     if(x == 0 ) {
       return 0
     } else if(x ==1){
       return 1
     }
     println("Coming here 2 "+x)  
      if(x<0) {
        //Should work differently
        var newVal:Double = multipleyBy2(x)
        if(newVal == 1.0) {
          return 1
        }
      }
     if(x%2 !=0 ) {
        return 0 
     } else {
       
       for(i <- 0 to x.toInt ) {
         if(Math.pow(2, i) == x) {
           return 1
         }
       }
     }
        
    return 0;
  }
   
   def multipleyBy2(x: Double) : Double = {
     var z:Double = x * 2;
     
     if(z.toInt < 1) {
       multipleyBy2(z)
     }
     return z
   }
}