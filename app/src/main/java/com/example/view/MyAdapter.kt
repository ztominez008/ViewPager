package com.example.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter


class MyAdapter(private val context: Context, private val myModelArrayList: ArrayList<MyModel>) : PagerAdapter() {
    override fun getCount(): Int {
        return myModelArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //inflate layout card.xml
        val view = LayoutInflater.from(context).inflate(R.layout.card, container,false)

        //get date
        val model = myModelArrayList[position]
        val title = model.title
        val description = model.description
        val date = model.date
        val image = model.image

        //set dat to UI view
         view.bannerIv.SetImageResource(image)
         view.titleTv.text = text
         view.descriptionTv.text = description
         view.datetv.text = date

        //handle item/card click
        view.setOnClickListener{
            Toast.makeText(context,"$title \n $description \n $date", Toast.LENGTH_SHORT).show()
        }

        //add view to container
        container.addView(view, position)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}