package com.example.root.insta_image_filter.Utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.IOException
import java.io.InputStream

object BitmapUtils {
    fun getBitmapFromAssets(context: Context, fileName: String, width: Int, height: Int): Bitmap? {
        val assetManager = context.assets
        val inputStream: InputStream
        val bitmap: Bitmap? = null
        try {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            inputStream = assetManager.open(fileName)

            options.inSampleSize = calculateInSampleSize(options, width, height)
            options.inJustDecodeBounds = false
            return BitmapFactory.decodeStream(inputStream, null, options)
        } catch (e: IOException) {
            Log.e("DEBUG", e.message)
        }

    }

    private fun calculateInSampleSize(options: BitmapFactory.Options, regwidth: Int, regheight: Int) {
        val height = options.outHeight
        val width = options.outWidth
        val inSampleSize = 1

    }
}