package com.example.rxjava_rxandroid_demo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskObservable: Observable<Task> =Observable
            .fromIterable(DataSource.createTasksList())
            .subscribeOn(Schedulers.io())
            .filter(Predicate {
                try{
                    Thread.sleep(1000)
                }catch (e:InterruptedException){
                    e.printStackTrace()
                }
                return@Predicate it.isComplete()!!
            }
            )
            .observeOn(AndroidSchedulers.mainThread())

       taskObservable.subscribe(
           {value-> println("debug: on Next ${value.getDescription()}")},
           {error->println("debug: on Error")},
           { println("debug: On Complete")}
       )

    }
}