package com.example.root.insta_image_filter.Utils

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.widget.Scroller

class NonSwipeableViewPager : ViewPager {
    constructor(context: Context) : super(context) {
        setMyScroller()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        setMyScroller()
    }

    private fun setMyScroller() {
        try {
            val viewPager = ViewPager::class.java
            val scroller = viewPager.getDeclaredField("mScroller")
            scroller.isAccessible = true
            scroller.set(this, MyScroller(context))

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun MyScroller(context: Context): Scroller(context,) {

    }
}