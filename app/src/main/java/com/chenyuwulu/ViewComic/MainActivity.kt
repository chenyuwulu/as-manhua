package com.chenyuwulu.ViewComic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import android.os.Build
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    object ojbk {
        val ACA = "message"
        val we_sub = "string"
    }
    /** 抽屉视图  */
    private var mDrawerLayout: DrawerLayout? = null
    /** 侧滑菜单视图  */
    private var mMenuNv: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val files: Array<File>
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            files = getExternalFilesDirs(Environment.MEDIA_MOUNTED)
            for (file in files) {
                Log.e("main", file.toString())
            }
        }
        function1()
        initUI()
        initListener()
    }
    fun sendMessage() {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        val message = editText1.text.toString()
        intent.putExtra(ojbk.ACA, message)
        startActivity(intent)
    }
    /**
     * 初始化界面
     */
    private fun initUI() {
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mMenuNv = findViewById(R.id.nv_layout)
//        mOpenMenuTv = findViewById(R.id.tv_open)
    }

    /**
     * 初始化监听
     */
    private fun initListener() {
        // 设置侧滑菜单点击事件监听
        mMenuNv!!.setNavigationItemSelectedListener { item ->
            selectItem(item.itemId)
            // 关闭侧滑菜单
//            mDrawerLayout!!.closeDrawers()
            true
        }
    }

    /**
     * 响应item点击事件
     * @param itemid
     */
    private fun selectItem(itemid: Int) {
        when (itemid) {
            R.id.menu_mon -> Toast.makeText(this@MainActivity, "点击Mon", Toast.LENGTH_SHORT).show()
            R.id.menu_tues -> Toast.makeText(this@MainActivity, "点击Tues", Toast.LENGTH_SHORT).show()
            R.id.menu_wed -> Toast.makeText(this@MainActivity, "点击Wed", Toast.LENGTH_SHORT).show()
            R.id.menu_thurs -> Toast.makeText(this@MainActivity, "点击Thurs", Toast.LENGTH_SHORT).show()
            R.id.menu_fri -> Toast.makeText(this@MainActivity, "点击Fri", Toast.LENGTH_SHORT).show()
            R.id.menu_sat -> Toast.makeText(this@MainActivity, "点击 Sat", Toast.LENGTH_SHORT).show()
            R.id.menu_sun -> Toast.makeText(this@MainActivity, "点击 Sun", Toast.LENGTH_SHORT).show()
            else -> {
            }
        }
    }
    /**
     * 不显示滚动条
     */
    private fun removeNavigationViewScrollbar(navView: NavigationView?) {
        if (navView != null) {
            val navigationMenuView = navView.getChildAt(0)
            navigationMenuView.isVerticalScrollBarEnabled = false
        }
    }
    fun function1():Unit{
        val x = 1
        if (x ==1){

        }else{

        }
    }
    fun tabbar(){
        startActivity(Intent(this,tabbar::class.java))//跳转去tabbar页面
    }
    fun we_sub_textview(){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "textview")
        startActivity(intent)
    }
    fun we_sub_edittext() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "edittext")
        startActivity(intent)
    }
    fun we_sub_button() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "button")
        startActivity(intent)
    }
    fun we_sub_check_radio(){
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "check_radio")
        startActivity(intent)
    }
    fun we_sub_togglebutton_switch() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "togglebutton_switch")
        startActivity(intent)
    }
    fun we_sub_imageview() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "imageview")
        startActivity(intent)
    }
    fun we_sub_imagebutton() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "imagebutton")
        startActivity(intent)
    }
    fun we_sub_customview() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "customview")
        startActivity(intent)
    }
    fun we_sub_linearlayout() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "linearlayout")
        startActivity(intent)
    }
    fun we_sub_gravity_layout_gravity() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "gravity_layout_gravity")
        startActivity(intent)
    }
    fun we_sub_padding_margin() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "padding_margin")
        startActivity(intent)
    }
    fun we_sub_relativelayout() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "relativelayout")
        startActivity(intent)
    }
    fun we_sub_tablelayout() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "tablelayout")
        startActivity(intent)
    }
    fun we_sub_framelayout() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "framelayout")
        startActivity(intent)
    }
    fun we_sub_absolutelayout() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "absolutelayout")
        startActivity(intent)
    }
    fun we_sub_gridlayout() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "gridlayout")
        startActivity(intent)
    }
    fun we_sub_33() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "33")
        startActivity(intent)
    }
    fun we_sub_34() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "34")
        startActivity(intent)
    }
    fun we_sub_35() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "35")
        startActivity(intent)
    }
    fun we_sub_36() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "36")
        startActivity(intent)
    }
    fun we_sub_listview() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "listview")
        startActivity(intent)
    }
    fun we_sub_adapter() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "adapter")
        startActivity(intent)
    }
    fun we_sub_listactivity() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "listactivity")
        startActivity(intent)
    }
    fun we_sub_arrayadapter() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "arrayadapter")
        startActivity(intent)
    }
    fun we_sub_simpleadapter() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "simpleadapter")
        startActivity(intent)
    }
    fun we_sub_baseadapter() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "baseadapter")
        startActivity(intent)
    }
    fun list_youhua() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "list_youhua")
        startActivity(intent)
    }
    fun we_sub_listview_apply() {
        val intent = Intent(this, we_sub::class.java)
        intent.putExtra(ojbk.we_sub, "listview_apply")
        startActivity(intent)
    }
    fun we_sub_gridview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"gridview")
        startActivity(intent)
    }
    fun we_sub_spinner() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"spinner")
        startActivity(intent)
    }
    fun we_sub_autocomplete_textview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"autocomplete_textview")
        startActivity(intent)
    }
    fun we_sub_expandlist() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"expandlist")
        startActivity(intent)
    }
    fun we_sub_adapterview_filpper() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"adapterview_filpper")
        startActivity(intent)
    }
    fun we_sub_stackview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"stackview")
        startActivity(intent)
    }
    fun we_sub_progressbar() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"progressbar")
        startActivity(intent)
    }
    fun we_sub_custom_progressbar() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"custom_progressbar")
        startActivity(intent)
    }
    fun we_sub_seekbar_ratingbar() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"seekbar_ratingbar")
        startActivity(intent)
    }
    fun we_sub_viewswitcher() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewswitcher")
        startActivity(intent)
    }
    fun we_sub_imageswitcher() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"imageswitcher")
        startActivity(intent)
    }
    fun we_sub_textswitcher() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"textswitcher")
        startActivity(intent)
    }
    fun we_sub_viewflipper() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewflipper")
        startActivity(intent)
    }
    fun we_sub_datepicker() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"datepicker")
        startActivity(intent)
    }
    fun we_sub_timepicker() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"timepicker")
        startActivity(intent)
    }
    fun we_sub_numberpicker() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"numberpicker")
        startActivity(intent)
    }
    fun we_sub_clock() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"clock")
        startActivity(intent)
    }
    fun we_sub_calendarview_chronnmeter() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"calendarview_chronnmeter")
        startActivity(intent)
    }
    fun we_sub_scrollview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"scrollview")
        startActivity(intent)
    }
    fun we_sub_searchview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"searchview")
        startActivity(intent)
    }
    fun we_sub_tabhosttab() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"tabhosttab")
        startActivity(intent)
    }
    fun we_sub_recyclerview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview")
        startActivity(intent)
    }
    fun we_sub_recyclerview_divider() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_divider")
        startActivity(intent)
    }
    fun we_sub_recyclerview_click() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_click")
        startActivity(intent)
    }
    fun we_sub_recyclerview_apply() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_apply")
        startActivity(intent)
    }
    fun we_sub_recyclerview_header_and_footer() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"recyclerview_header_and_footer")
        startActivity(intent)
    }
    fun we_sub_viewpager() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewpager")
        startActivity(intent)
    }
    fun we_sub_viewpager_tabhost() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"viewpager_tabhost")
        startActivity(intent)
    }
    fun we_sub_cardview() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"cardview")
        startActivity(intent)
    }
    fun we_sub_swiperefreshlayout() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"swiperefreshlayout")
        startActivity(intent)
    }
    fun we_sub_activity_rumen() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_rumen")
        startActivity(intent)
    }
    fun we_sub_activity_on_off() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_on_off")
        startActivity(intent)
    }
    fun we_sub_activity_life_cycle() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_life_cycle")
        startActivity(intent)
    }
    fun we_sub_activity_save_h_or_v() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_save_h_or_v")
        startActivity(intent)
    }
    fun we_sub_activity_stack_start() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_stack_start")
        startActivity(intent)
    }
    fun we_sub_intent() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"intent")
        startActivity(intent)
    }
    fun we_sub_intent_property_top() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"intent_property_top")
        startActivity(intent)
    }
    fun we_sub_intent_property_bottom() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"intent_property_bottom")
        startActivity(intent)
    }
    fun we_sub_activity_transmit() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_transmit")
        startActivity(intent)
    }
    fun we_sub_activity_return() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_return")
        startActivity(intent)
    }
    fun we_sub_activity_data_sub() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"activity_data_sub")
        startActivity(intent)
    }
    fun we_sub_fragment() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment")
        startActivity(intent)
    }
    fun we_sub_fragment_play() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_play")
        startActivity(intent)
    }
    fun we_sub_fragment_life_cycle() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_life_cycle")
        startActivity(intent)
    }
    fun we_sub_fragment_add_delete() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_add_delete")
        startActivity(intent)
    }
    fun we_sub_fragment_display() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_display")
        startActivity(intent)
    }
    fun we_sub_fragment_back() {
        val intent = Intent(this,we_sub::class.java)
        intent.putExtra(ojbk.we_sub,"fragment_back")
        startActivity(intent)
    }
}
