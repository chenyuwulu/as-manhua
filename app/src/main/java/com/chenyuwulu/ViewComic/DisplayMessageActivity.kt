package com.chenyuwulu.ViewComic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_message.*




class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        val intent = intent
        val message = intent.getStringExtra(MainActivity.ojbk.ACA)
        function1(message)
    }

    fun function1(x:String):Unit{
        textView.text = x
    }
}
