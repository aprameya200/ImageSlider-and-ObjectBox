package com.example.objectbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import java.util.Objects

//View groups are differetn layut types cl,rl,fr,tl etc

class ImagePageAdapter(val context: Context, val imageList: List<Int>) : PagerAdapter() {

    override fun getCount(): Int {
        return imageList.size
    }

    //It checks whether the page view provided is associated with the object returned by instantiateItem.
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    // on below line we are initializing
    // our item and inflating our layout file
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val mLayoutInflater = LayoutInflater.from(context)

        val itemView: View = mLayoutInflater.inflate(R.layout.image_viewer, container, false)
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageViewer)

        imageView.setImageResource(imageList.get(position)) //sets the image
        Objects.requireNonNull(container).addView(itemView) // ads the inflated view to the containier

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) { //removes the view
        // on below line we are removing view
        container.removeView(`object` as ConstraintLayout)
    }
}