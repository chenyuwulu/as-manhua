package com.chenyuwulu.chenyu_demo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Course_41 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_41)
        title = "CardView简单实现卡片式布局"
        val mCardView = findViewById<CardView>(R.id.cardview)
        mCardView.radius = 20F
        mCardView.cardElevation = Color.BLUE.toFloat()
        mCardView.cardElevation = 10F
        mCardView.setContentPadding(10,10,10,10)
    }
}