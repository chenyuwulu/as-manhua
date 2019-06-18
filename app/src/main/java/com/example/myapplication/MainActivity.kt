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
    fun we_sub_gravity_layout_gravity(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "gravity_layout_gravity")
        startActivity(intent)
    }
    fun we_sub_padding_margin(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "padding_margin")
        startActivity(intent)
    }
    fun we_sub_relativelayout(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "relativelayout")
        startActivity(intent)
    }
    fun we_sub_tablelayout(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "tablelayout")
        startActivity(intent)
    }
    fun we_sub_framelayout(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "framelayout")
        startActivity(intent)
    }
    fun we_sub_absolutelayout(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "absolutelayout")
        startActivity(intent)
    }
    fun we_sub_gridlayout(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "gridlayout")
        startActivity(intent)
    }
    fun we_sub_33(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "33")
        startActivity(intent)
    }
    fun we_sub_34(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "34")
        startActivity(intent)
    }
    fun we_sub_35(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "35")
        startActivity(intent)
    }
    fun we_sub_36(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "36")
        startActivity(intent)
    }
    fun we_sub_listview(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "listview")
        startActivity(intent)
    }
    fun we_sub_adapter(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "adapter")
        startActivity(intent)
    }
    fun we_sub_listactivity(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "listactivity")
        startActivity(intent)
    }
    fun we_sub_arrayadapter(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "arrayadapter")
        startActivity(intent)
    }
    fun we_sub_simpleadapter(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "simpleadapter")
        startActivity(intent)
    }
    fun we_sub_baseadapter(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "baseadapter")
        startActivity(intent)
    }
    fun list_youhua(view:View){

    }
    fun we_sub_listview_apply(view: View){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "listview_apply")
        startActivity(intent)
    }
    fun we_sub_gridview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"gridview")
        startActivity(intent)
    }
    fun we_sub_spinner(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"spinner")
        startActivity(intent)
    }
    fun we_sub_autocomplete_textview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"autocomplete_textview")
        startActivity(intent)
    }
    fun we_sub_expandlist(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"expandlist")
        startActivity(intent)
    }
    fun we_sub_adapterview_filpper(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"adapterview_filpper")
        startActivity(intent)
    }
    fun we_sub_stackview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"stackview")
        startActivity(intent)
    }
    fun we_sub_progressbar(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"progressbar")
        startActivity(intent)
    }
    fun we_sub_custom_progressbar(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"custom_progressbar")
        startActivity(intent)
    }
    fun we_sub_seekbar_ratingbar(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"seekbar_ratingbar")
        startActivity(intent)
    }
    fun we_sub_viewswitcher(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewswitcher")
        startActivity(intent)
    }
    fun we_sub_imageswitcher(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"imageswitcher")
        startActivity(intent)
    }
    fun we_sub_textswitcher(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"textswitcher")
        startActivity(intent)
    }
    fun we_sub_viewflipper(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewflipper")
        startActivity(intent)
    }
}
