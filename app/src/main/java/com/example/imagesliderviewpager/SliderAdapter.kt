package com.example.imagesliderviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import androidx.viewpager.widget.PagerAdapter

class SliderAdapter(var context: Context, var images: Array<Int>) : PagerAdapter() {
    lateinit var inflater: LayoutInflater


    override fun isViewFromObject(view: View, `object`: Any): Boolean =view == `object` as ConstraintLayout



    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var image:ImageView
        inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view:View = inflater.inflate(R.layout.slider_image_item,container,false)
        image=view.findViewById(R.id.Slider_image)
        image.setBackgroundResource(images[position])
        container!!.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
      container!!.removeView(`object` as ConstraintLayout)
    }
}