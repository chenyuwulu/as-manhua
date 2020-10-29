package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Course_27 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_27)
        title = "图片切换"
        val mImageIds = intArrayOf(
            R.drawable.bh3_1,
            R.drawable.bh3_2,
            R.drawable.bh3_3,
            R.drawable.bh3_4,
            R.drawable.bh3_5
        )
        var mIndex = 0
        val mImageSwitcher = findViewById<ImageSwitcher>(R.id.switcher)
        mImageSwitcher.setFactory {
            val imageView = ImageView(this)
            imageView.setBackgroundColor(-0x1000000)
            // 设置填充方式
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageView.layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
            imageView
        }
        mImageSwitcher.setInAnimation(this, android.R.anim.fade_in)
        mImageSwitcher.setOutAnimation(this, android.R.anim.fade_out)
        // 为ImageSwitcher绑定监听事件
        mImageSwitcher.setOnClickListener {
            mIndex++
            if (mIndex >= mImageIds.size) {
                mIndex = 0
            }
            mImageSwitcher.setImageResource(mImageIds[mIndex])
        }

        mImageSwitcher.setImageResource(mImageIds[0])
    }
}
