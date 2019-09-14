package com.chenyuwulu.ViewComic

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


class CircleProgressBar : View {
    private var mBackPaint: Paint? = null
    private var mFrontPaint: Paint? = null
    private var mTextPaint: Paint? = null
    private val mStrokeWidth = 50f
    private val mHalfStrokeWidth = mStrokeWidth / 2
    private val mRadius = 200f
    private var mRect: RectF? = null
    private var mProgress = 0
    private val mTargetProgress = 90
    private val mMax = 100
    private var mWidth: Int = 0
    private var mHeight: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    // 完成相关参数初始化
    private fun init() {
        mBackPaint = Paint()
        mBackPaint!!.setColor(Color.WHITE)
        mBackPaint!!.setAntiAlias(true)
        mBackPaint!!.setStyle(Paint.Style.STROKE)
        mBackPaint!!.setStrokeWidth(mStrokeWidth)
        mFrontPaint = Paint()
        mFrontPaint!!.setColor(Color.GREEN)
        mFrontPaint!!.setAntiAlias(true)
        mFrontPaint!!.setStyle(Paint.Style.STROKE)
        mFrontPaint!!.setStrokeWidth(mStrokeWidth)
        mTextPaint = Paint()
        mTextPaint!!.setColor(Color.GREEN)
        mTextPaint!!.setAntiAlias(true)
        mTextPaint!!.setTextSize(80F)
        mTextPaint!!.setTextAlign(Paint.Align.CENTER)
    }

    // 重写测量大小的onMeasure方法和绘制View的核心方法onDraw()
    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = getRealSize(widthMeasureSpec)
        mHeight = getRealSize(heightMeasureSpec)
        setMeasuredDimension(mWidth, mHeight)
    }

    protected override fun onDraw(canvas: Canvas) {
        initRect()
        val angle = mProgress / mMax.toFloat() * 360
        canvas.drawCircle((mWidth / 2).toFloat(), (mHeight / 2).toFloat(), mRadius, mBackPaint)
        canvas.drawArc(mRect, (-90).toFloat(), angle, false, mFrontPaint)
        canvas.drawText(
            "$mProgress%", mWidth / 2 + mHalfStrokeWidth,
            mHeight / 2 + mHalfStrokeWidth, mTextPaint
        )
        if (mProgress < mTargetProgress) {
            mProgress += 1
            invalidate()
        }
    }

    fun getRealSize(measureSpec: Int): Int {
        var result = 1
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        if (mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED) {
            //自己计算
            result = (mRadius * 2 + mStrokeWidth).toInt()
        } else {
            result = size
        }
        return result
    }

    private fun initRect() {
        if (mRect == null) {
            mRect = RectF()
            val viewSize = (mRadius * 2).toInt()
            val left = (mWidth - viewSize) / 2
            val top = (mHeight - viewSize) / 2
            val right = left + viewSize
            val bottom = top + viewSize
            mRect!!.set(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
        }
    }
}