package com.chenyuwulu.ViewComic

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class MyStackAdapter(context: Context, imageIds: IntArray) : BaseAdapter() {
    private var mContext: Context? = null
    private var mImageIds: IntArray? = null

    init {
        this.mContext = context
        this.mImageIds = imageIds
    }

    override fun getCount(): Int {
        return mImageIds!!.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 该方法返回的View代表了每个列表项
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val cts = convertView
        val imageView: ImageView?
        if (null == cts) {
            // 创建一个ImageView
            imageView = ImageView(mContext)
            // 设置ImageView的缩放类型
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            // 为imageView设置布局参数
            imageView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        } else {
            imageView = cts as ImageView?
        }

        // 给ImageView设置图片资源
        imageView!!.setImageResource(mImageIds!![position])

        return imageView
    }
}