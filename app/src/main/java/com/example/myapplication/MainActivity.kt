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
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "list_youhua")
        startActivity(intent)
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
    fun we_sub_datepicker(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"datepicker")
        startActivity(intent)
    }
    fun we_sub_timepicker(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"timepicker")
        startActivity(intent)
    }
    fun we_sub_numberpicker(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"numberpicker")
        startActivity(intent)
    }
    fun we_sub_clock(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"clock")
        startActivity(intent)
    }
    fun we_sub_calendarview_chronnmeter(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"calendarview_chronnmeter")
        startActivity(intent)
    }
    fun we_sub_scrollview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"scrollview")
        startActivity(intent)
    }
    fun we_sub_searchview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"searchview")
        startActivity(intent)
    }
    fun we_sub_tabhosttab(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"tabhosttab")
        startActivity(intent)
    }
    fun we_sub_recyclerview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview")
        startActivity(intent)
    }
    fun we_sub_recyclerview_divider(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_divider")
        startActivity(intent)
    }
    fun we_sub_recyclerview_click(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_click")
        startActivity(intent)
    }
    fun we_sub_recyclerview_apply(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_apply")
        startActivity(intent)
    }
    fun we_sub_recyclerview_header_and_footer(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_header_and_footer")
        startActivity(intent)
    }
    fun we_sub_viewpager(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewpager")
        startActivity(intent)
    }
    fun we_sub_viewpager_tabhost(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewpager_tabhost")
        startActivity(intent)
    }
    fun we_sub_cardview(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"cardview")
        startActivity(intent)
    }
    fun we_sub_swiperefreshlayout(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"swiperefreshlayout")
        startActivity(intent)
    }
    fun we_sub_activity_rumen(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_rumen")
        startActivity(intent)
    }
    fun we_sub_activity_on_off(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_on_off")
        startActivity(intent)
    }
    fun we_sub_activity_life_cycle(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_life_cycle")
        startActivity(intent)
    }
    fun we_sub_activity_save_h_or_v(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_save_h_or_v")
        startActivity(intent)
    }
    fun we_sub_activity_stack_start(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_stack_start")
        startActivity(intent)
    }
    fun we_sub_intent(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"intent")
        startActivity(intent)
    }
    fun we_sub_intent_property_top(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"intent_property_top")
        startActivity(intent)
    }
    fun we_sub_intent_property_bottom(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"intent_property_bottom")
        startActivity(intent)
    }
    fun we_sub_activity_transmit(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_transmit")
        startActivity(intent)
    }
    fun we_sub_activity_return(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_return")
        startActivity(intent)
    }
    fun we_sub_activity_data_sub(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_data_sub")
        startActivity(intent)
    }
    fun we_sub_fragment(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment")
        startActivity(intent)
    }
    fun we_sub_fragment_play(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_play")
        startActivity(intent)
    }
    fun we_sub_fragment_life_cycle(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_life_cycle")
        startActivity(intent)
    }
    fun we_sub_fragment_add_delete(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_add_delete")
        startActivity(intent)
    }
    fun we_sub_fragment_display(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_display")
        startActivity(intent)
    }
    fun we_sub_fragment_back(view: View){
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_back")
        startActivity(intent)
    }
}
