package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    object ojbk {
        val ACA = "message"
        val we_sub = "string"
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

        }else{

        }
    }
    fun tabbar(view: View){
        startActivity(Intent(this,tabbar::class.java))//跳转去tabbar页面
    }
    fun we_sub_textview(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "textview")
        startActivity(intent)
    }
    fun we_sub_edittext(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "edittext")
        startActivity(intent)
    }
    fun we_sub_button(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "button")
        startActivity(intent)
    }
    fun we_sub_check_radio(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "check_radio")
        startActivity(intent)
    }
    fun we_sub_togglebutton_switch(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "togglebutton_switch")
        startActivity(intent)
    }
    fun we_sub_imageview(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "imageview")
        startActivity(intent)
    }
    fun we_sub_imagebutton(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "imagebutton")
        startActivity(intent)
    }
    fun we_sub_customview(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "customview")
        startActivity(intent)
    }
    fun we_sub_linearlayout(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "linearlayout")
        startActivity(intent)
    }
}
