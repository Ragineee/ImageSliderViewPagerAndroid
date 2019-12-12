package com.example.imagesliderviewpager

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var currentPage = 0
    private var NUM_PAGES = 0

    var images:Array<Int> = arrayOf(R.drawable.flower1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5)
    var adapter:PagerAdapter = SliderAdapter(this@MainActivity,images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter=adapter

        MyTimeTask()
    }

    private fun MyTimeTask() {
        NUM_PAGES = images.size
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {

                if(currentPage==NUM_PAGES){
                    currentPage = 0
                }
                viewPager.setCurrentItem(currentPage++,true)

            }
        }

        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {

            override fun run() {
                handler.post(runnable)
            }
        }, 0, 2000)

        handler.postDelayed(runnable, 0)
    }
}



