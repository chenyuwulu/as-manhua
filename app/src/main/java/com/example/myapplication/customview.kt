package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

/**
 * @创建者 鑫鱻
 * @描述 Android零基础入门到精通系列教程，欢迎关注微信公众ShareExpert
 */

class customview(context: Context, attrs: AttributeSet) : View(context, attrs) {
    // 定义画笔
    private val mPaint: Paint
    // 用于获取文字的宽和高
    private val mBounds: Rect
    // 计数值，每点击一次本控件，其值增加1
    private var mCount = 0

    init {

        // 初始化画笔、Rect
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mBounds = Rect()
        // 本控件的点击事件
        setOnClickListener {
            mCount++

            // 重绘
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.BLUE
        // 绘制一个填充色为蓝色的矩形
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)

        mPaint.color = Color.YELLOW
        mPaint.textSize = 50f
        val text = mCount.toString()
        // 获取文字的宽和高
        mPaint.getTextBounds(text, 0, text.length, mBounds)
        val textWidth = mBounds.width().toFloat()
        val textHeight = mBounds.height().toFloat()

        // 绘制字符串
        canvas.drawText(text, width / 2 - textWidth / 2, height / 2 + textHeight / 2, mPaint)
    }
}
