package com.example.rxjava_rxandroid_demo

class DataSource {
     companion object{
         fun createTasksList():List<Task>{
            var list = ArrayList<Task>()
             list.add(Task("Take out the trash",true,3))
             list.add(Task("Walk the dog",false,2))
             list.add(Task("Make my Bed",true,1))
             list.add(Task("Unload the dishwasher",true,0))
             list.add(Task("Make dinner",true,5))
             return list
         }
     }
}