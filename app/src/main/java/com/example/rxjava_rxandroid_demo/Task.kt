package com.example.rxjava_rxandroid_demo

 class Task {
   private var description: String? = null
     private var isComplete: Boolean?= false
     private var priority: Int?=0

     constructor(description: String?, isComplete: Boolean?, priority: Int?) {
         this.description = description
         this.isComplete = isComplete
         this.priority = priority
     }

     public fun getDescription():String?{
         return description
     }

     public fun isComplete():Boolean?{
         return isComplete
     }
 }