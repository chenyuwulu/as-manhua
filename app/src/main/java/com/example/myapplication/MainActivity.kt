package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    object ojbk {
        val ACA = "message"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        function1()
    }
    fun sendMessage(view: View) {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        val message = editText1.text.toString()
        intent.putExtra(ojbk.ACA, message)
        startActivity(intent)
    }
    fun function1():Unit{
        val x = 1
        if (x ==1){
            textView2.text = this.getString(R.string.app_name)
        }else{

        }
    }
    fun tabbar(view: View){
        startActivity(Intent(this,tabbar::class.java))//跳转去tabbar页面
    }
}
