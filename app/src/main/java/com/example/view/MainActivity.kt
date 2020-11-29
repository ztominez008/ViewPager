package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    private val viewpager: Any

    //actionbar
    private lateinit var actionBar: ActionBar;

    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init actionbar
        actionBar = this.supportActionBar!!

        loadCards()

        //add page change listener
        viewpager.addOnPageChangeListener(object: viewpager.OnPageChangeListener)
        
        override fun OnPageScrollStateChanged(state: Int){
            val position
            position: Int,
            positionOffset: Float
            positionOffsetPixels: Int

        }
        // change title of actionbar
        val title = myModelList[position].title
        actionBar.title = title

    }

    private fun loadCards() {
        //init list
        myModelList = ArrayList()

        // add items/data to list
        myModelList.add(MyModel(
                "Kotlin Edition",
                "Description",
                "July 17, 2017", R.drawable.android_e))
        myModelList.add(MyModel(
                "Kotlin Blueprints",
                "Description",
                "December 8, 2017", R.drawable.android_q))
        myModelList.add(MyModel(
                "Java",
                "Description",
                "January 12, 2016", R.drawable.android_w))

        //setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to viewpager
        val viewpager
        viewpager.adapter = myAdapter
        //set default padding
        viewpager.setPadding(100, 0 , 100, 0)

    }
}