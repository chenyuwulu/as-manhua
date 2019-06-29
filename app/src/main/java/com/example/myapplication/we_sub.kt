package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.Toast
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import android.widget.GridView
import android.widget.SimpleAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.ExpandableListView
import android.graphics.drawable.AnimationDrawable
import android.os.Handler
import android.os.SystemClock
import android.support.v4.view.PagerTabStrip
import android.support.v4.view.ViewPager
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.*
import android.util.Log
import android.widget.SeekBar
import android.widget.ViewSwitcher
import com.example.myapplication.we_sub.ViewSwitchers.NUMBER_PER_SCREEN
import com.example.myapplication.we_sub.ViewSwitchers.screenCount
import android.widget.ImageSwitcher
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView.ScaleType
import android.widget.ImageView
import android.widget.SearchView


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class we_sub : AppCompatActivity(){

    object ViewSwitchers {
        var screenNo = -1
        // 定义一个常量，用于显示每屏显示的应用程序数
        val NUMBER_PER_SCREEN = 12
        // 记录当前正在显示第几屏的程序

        // 保存程序所占的总屏数
        var screenCount: Int = 0
    }
    private var mAdapter: ViewSwitcherBaseAdapter? = null
    // 保存系统所有应用程序的List集合
    private val mItemDatas = ArrayList<ViewSwitcherItemData>()

    //82课时的变量
    private var mLifePb: ProgressBar? = null
    private var mAttackPb: ProgressBar? = null
    private var mSpeedPb: ProgressBar? = null
    private var mLifeTV: TextView? = null
    private var mAttackTV: TextView? = null
    private var mSpeedTV: TextView? = null

    @SuppressLint("InflateParams", "SetJavaScriptEnabled", "CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = intent.getStringExtra(MainActivity.ojbk.we_sub)
        when (message) {
            "textview" -> {
                setContentView(R.layout.we_sub_textview)
                title = "文本框展示"
            }
            "edittext" -> {
                setContentView(R.layout.we_sub_edittext)
                title = "可编辑文本框展示"
            }
            "button" -> {
                setContentView(R.layout.we_sub_button)
                title = "按钮展示"
                val mNameEt = findViewById<EditText>(R.id.name_et)
                val mPasswordEt = findViewById<EditText>(R.id.pwd_et)
                val mLoginBtn = findViewById<Button>(R.id.login_btn)
                mLoginBtn.setOnClickListener{
                    if(TextUtils.isEmpty(mNameEt.text) || TextUtils.isEmpty(mPasswordEt.text)){
                        Toast.makeText(this,"帐号或密码为空",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"用户名：" + mNameEt.text + "\n密码：" + mPasswordEt.text,Toast.LENGTH_SHORT).show()
                    }

                }
            }
            "check_radio" -> {
                setContentView(R.layout.we_sub_check_radio)
                title = "复选和单选框展示"
                val mShanghaiCb = findViewById<CheckBox>(R.id.shanghai_cb)
                val mBeijingCb = findViewById<CheckBox>(R.id.beijing_cb)
                val mChongqingCb = findViewById<CheckBox>(R.id.chongqing_cb)
                val mMaleRb = findViewById<RadioButton>(R.id.male_rb)
                val mFemaleRb = findViewById<RadioButton>(R.id.female_rb)
                val mSexRg = findViewById<RadioGroup>(R.id.sex_rg)
                fun showSelectCity(compoundButton: CompoundButton) {
                    val city = compoundButton.text.toString()
                    val text = if (compoundButton.isChecked) "选中$city" else "取消选中$city"
                    Toast.makeText(
                        this,
                        text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                mShanghaiCb.setOnCheckedChangeListener { compoundButton, b ->
                    // 提示用户选择的城市
                    showSelectCity(compoundButton)
                }
                mBeijingCb.setOnCheckedChangeListener { compoundButton, b ->
                    // 提示用户选择的城市
                    showSelectCity(compoundButton)
                }
                mChongqingCb.setOnCheckedChangeListener { compoundButton, b ->
                    // 提示用户选择的城市
                    showSelectCity(compoundButton)
                }
                mSexRg.setOnCheckedChangeListener { radioGroup, checkedId ->
                    // 获取用户选中的性别
                    var sex = ""
                    when (checkedId) {
                        R.id.male_rb -> sex = mMaleRb.text.toString()
                        R.id.female_rb -> sex = mFemaleRb.text.toString()
                        else -> {}
                    }
                    // 消息提示
                    Toast.makeText(
                        this,
                        "选择的性别是：$sex",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "togglebutton_switch" -> {
                setContentView(R.layout.we_sub_togglebutton_switch)
                title = "开关按钮展示"
                val mLikeTb = findViewById<ToggleButton>(R.id.like_tb)
                val mBluetoothSwitch = findViewById<Switch>(R.id.bluetooth_switch)
                mLikeTb.setOnCheckedChangeListener { compoundButton, b ->
                    // 消息提示
                    val tb_text = if(compoundButton.isChecked) "喜欢Android开发" else "不喜欢Android开发"
                    Toast.makeText(
                        this,
                        tb_text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                mBluetoothSwitch.setOnCheckedChangeListener { compoundButton, b ->
                    val switch_text = if(compoundButton.isChecked) "打开蓝牙" else "关闭蓝牙"
                        Toast.makeText(
                            this,
                            switch_text,
                            Toast.LENGTH_SHORT
                        ).show()
                }

            }
            "imageview" -> {
                setContentView(R.layout.we_sub_imageview)
                title = "图片视图展示"
            }
            "imagebutton" -> {
                setContentView(R.layout.we_sub_imagebutton)
                title = "图片按钮展示"
                val mControlIb = findViewById<ImageButton>(R.id.control_ib)
                var mFlag = false
                val mMinusZb = findViewById<ZoomButton>(R.id.minus_zb)
                val mPlusZb = findViewById<ZoomButton>(R.id.plus_zb)
                val mControlZc = findViewById<ZoomControls>(R.id.control_zc)
                mControlIb.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View) {
                        // 根据记录的控制状态进行图标切换
                        if (mFlag) {
                            Toast.makeText(this@we_sub, "暂停", Toast.LENGTH_SHORT).show()
                            mControlIb.setImageResource(R.drawable.bh3_2)
                            mFlag = false
                        } else {
                            Toast.makeText(this@we_sub, "快进", Toast.LENGTH_SHORT).show()
                            mControlIb.setImageResource(R.drawable.bh3_3)
                            mFlag = true
                        }
                    }
                })
                // 为缩小按钮绑定OnClickListener监听器
                mMinusZb.setOnClickListener { Toast.makeText(this, "缩小", Toast.LENGTH_SHORT).show() }
                // 为放大按钮绑定OnClickListener监听器
                mPlusZb.setOnClickListener { Toast.makeText(this, "放大", Toast.LENGTH_SHORT).show() }
                // 为缩放组件绑定OnZoomInClickListener监听器
                mControlZc.setOnZoomInClickListener {
                    Toast.makeText(this, "放大", Toast.LENGTH_SHORT).show()
                }
                // 为缩放组件绑定OnZoomOutClickListener监听器
                mControlZc.setOnZoomOutClickListener {
                    Toast.makeText(this, "缩小", Toast.LENGTH_SHORT).show()
                }
            }
            "customview" -> {
                setContentView(R.layout.we_sub_customview)
                title = "自定义view展示"
            }
            "linearlayout" -> {
                setContentView(R.layout.we_sub_linearlayout)
                title = "线性布局展示"
            }
            "gravity_layout_gravity" -> {
                setContentView(R.layout.we_sub_gravity_layout_gravity)
                title = "布局重心展示"
            }
            "padding_margin" -> {
                setContentView(R.layout.we_sub_padding_margin)
                title = "padding&margin展示"
            }
            "relativelayout" -> {
                setContentView(R.layout.we_sub_relativelayout)
                title = "相对布局展示"
            }
            "tablelayout" -> {
                setContentView(R.layout.we_sub_tablelayout)
                title = "表格布局展示"
            }
            "framelayout" -> {
                setContentView(R.layout.we_sub_framelayout)
                title = "帧布局展示"
            }
            "absolutelayout" -> {
                setContentView(R.layout.we_sub_absolutelayout)
                title = "绝对布局展示"
            }
            "gridlayout" -> {
                setContentView(R.layout.we_sub_gridlayout)
                title = "网格布局展示"
            }
            "33" -> {
                setContentView(R.layout.we_sub_33)
                title = "Android事件展示"
                val button = findViewById<Button>(R.id.button)
                button.setOnClickListener {
                    Toast.makeText(
                        this,
                        "触发了点击事件",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "34"->{
                setContentView(R.layout.we_sub_34)
                title = "Android事件监听展示"
            }
            "35"->{
                setContentView(R.layout.we_sub_35)
                title = "Android回调事件展示"
            }
            "36"->{
                setContentView(R.layout.we_sub_36)
                title = "Android系统事件展示"
                val configurationTv = findViewById<TextView>(R.id.configuration_tv)

                // 获取系统的Configuration对象
                val cfg = resources.configuration

                // 获取系统的配置信息
                val status = StringBuffer()
                status.append("屏幕密度：" + cfg.densityDpi + "\n")
                status.append("字体缩放因子：" + cfg.fontScale + "\n")
                status.append("硬键盘是否可见：" + cfg.hardKeyboardHidden + "\n")
                status.append("键盘类型：" + cfg.keyboard + "\n")
                status.append("当前键盘是否可用：" + cfg.keyboardHidden + "\n")
                status.append("语言环境：" + cfg.locale + "\n")
                status.append("移动信号的国家码：" + cfg.mcc + "\n")
                status.append("移动信号的网络码：" + cfg.mnc + "\n")
                status.append("方向导航设备的类型：" + cfg.navigation + "\n")
                status.append("方向导航设备是否可用：" + cfg.navigationHidden + "\n")
                status.append("系统屏幕的方向：" + cfg.orientation + "\n")
                status.append("屏幕可用高：" + cfg.screenHeightDp + "\n")
                status.append("屏幕可用宽：" + cfg.screenWidthDp + "\n")
                status.append("系统触摸屏的触摸方式：" + cfg.touchscreen + "\n")
                status.append("screenLayout：" + cfg.screenLayout + "\n")
                status.append("smallestScreenWidthDp：" + cfg.smallestScreenWidthDp + "\n")
                status.append("uiMode：" + cfg.uiMode + "\n")

                // 配置信息输出
                configurationTv.text = status.toString()


            }
            "listview"->{
                setContentView(R.layout.we_sub_listview)
                title = "listview展示"
            }
            "adapter"->{
                setContentView(R.layout.we_sub_adapter)
                title = "adapter展示"
                // 获取界面ListView组件
                val listView = findViewById<ListView>(R.id.listview)

                // 定义一个数组
                val books = arrayOf(
                    "初识Android开发",
                    "Android初级开发",
                    "Android中级开发",
                    "Android高级开发",
                    "Android开发进阶",
                    "Android项目实战",
                    "Android企业级开发",
                    "初识Android开发",
                    "Android初级开发",
                    "Android中级开发",
                    "Android高级开发",
                    "Android开发进阶",
                    "Android项目实战",
                    "Android企业级开发",
                    "初识Android开发",
                    "Android初级开发",
                    "Android中级开发",
                    "Android高级开发",
                    "Android开发进阶",
                    "Android项目实战",
                    "Android企业级开发",
                    "初识Android开发",
                    "Android初级开发",
                    "Android中级开发",
                    "Android高级开发",
                    "Android开发进阶",
                    "Android项目实战",
                    "Android企业级开发"
                )
                // 将数组包装成ArrayAdapter
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1, books
                )
                // 为ListView设置Adapter
                listView.adapter = adapter

                // 为ListView绑定列表项点击事件监听器
                listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
                    Toast.makeText(
                        this,
                        "点击了" + books[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "listactivity"->{
                setContentView(R.layout.we_sub_listactivity)
                title = "listactivity监听展示"
                // 获取界面ListView组件
                val listView = findViewById<ListView>(R.id.listview)

                // 定义一个List集合
                val components = ArrayList<String>()
                components.add("TextView")
                components.add("EditText")
                components.add("Button")
                components.add("CheckBox")
                components.add("RadioButton")
                components.add("ToggleButton")
                components.add("ImageView")

                // 将List包装成ArrayAdapter
                val adapter = ArrayAdapter<String>(
                    this,
                    R.layout.we_sub_listactivity_custom, R.id.content_tv, components
                )

                // 为ListView设置Adapter
                listView.adapter = adapter

                // 为ListView列表项绑定点击事件监听器
                listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
                    Toast.makeText(
                        this@we_sub,
                        components.get(position),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "arrayadapter"->{
                setContentView(R.layout.we_sub_arrayadapter)
                title = "arrayadapter展示"
                // 获取界面组件
                val listView = findViewById<ListView>(R.id.listview)

                // 定义要显示的数组
                val contents = arrayOf("Android", "demo", "Edit", "APP", "excel", "dota", "Button", "Circle", "excel", "back")

                // 将数组包装为自定义MyArrayAdapter
                val adapter = MyArrayAdapter(this, R.layout.we_sub_arrayadapter_custom_item, contents)

                // 为ListView设置Adapter
                listView.adapter = adapter

            }
            "simpleadapter"->{
                setContentView(R.layout.we_sub_simpleadapter)
                title = "simpleadapter展示"
                fun getData(): List<Map<String, Any>> {
                    val list = ArrayList<Map<String, Any>>()
                    var map: MutableMap<String, Any> = HashMap()
                    map["img"] = R.drawable.bh3_1
                    map["title"] = "小宗"
                    map["info"] = "电台DJ"
                    list.add(map)

                    map = HashMap()
                    map["img"] = R.drawable.bh3_2
                    map["title"] = "貂蝉"
                    map["info"] = "四大美女"
                    list.add(map)

                    map = HashMap()
                    map["img"] = R.drawable.bh3_3
                    map["title"] = "奶茶"
                    map["info"] = "清纯妹妹"
                    list.add(map)

                    map = HashMap()
                    map["img"] = R.drawable.bh3_4
                    map["title"] = "大黄"
                    map["info"] = "是小狗"
                    list.add(map)

                    map = HashMap()
                    map["img"] = R.drawable.bh3_5
                    map["title"] = "hello"
                    map["info"] = "every thing"
                    list.add(map)

                    map = HashMap()
                    map["img"] = R.drawable.bh3_6
                    map["title"] = "world"
                    map["info"] = "hello world"
                    list.add(map)

                    return list
                }
                val listView = findViewById<ListView>(R.id.listview)
                val adapter = SimpleAdapter(
                    this,
                    getData(),
                    R.layout.we_sub_simpleadapter_item,
                    arrayOf("img", "title", "info"),
                    intArrayOf(R.id.icon_img, R.id.title_tv, R.id.info_tv)
                )
                listView.adapter = adapter
            }
            "baseadapter" -> {
                setContentView(R.layout.we_sub_baseadapter)
                title = "baseadapter展示"
                fun getData(): List<Data> {
                    val datas = ArrayList<Data>()
                    datas.add(Data(R.drawable.bh3_1, "小宗", "电台DJ"))
                    datas.add(Data(R.drawable.bh3_2, "貂蝉", "四大美女"))
                    datas.add(Data(R.drawable.bh3_3, "奶茶", "清纯妹妹"))
                    datas.add(Data(R.drawable.bh3_4, "大黄", "是小狗"))
                    datas.add(Data(R.drawable.bh3_5, "hello", "every thing"))
                    datas.add(Data(R.drawable.bh3_6, "world", "hello world"))
                    return datas
                }
                val listView = findViewById<ListView>(R.id.listview)

                // 将数组包装为自定义MyBaseAdapter
                val adapter = MyBaseAdapter(this, getData(), R.layout.we_sub_baseadapter_item)

                // 为ListView设置Adapter
                listView.adapter = adapter

            }
            "listview优化暂为空"->{
            }
            "listview_apply"->{
                setContentView(R.layout.we_sub_listview_apply)
                title = "重写类，所以没内嵌在里面，放在外面UpdateDataActivity这个类里"
                // 获取界面组件
                val mListView = findViewById<ListView>(R.id.listview)
                val mAddBtn = findViewById<Button>(R.id.add_btn)
                val mUpdateBtn = findViewById<Button>(R.id.update_btn)
                val mDeleteBtn = findViewById<Button>(R.id.delete_btn)
                val mClearBtn = findViewById<Button>(R.id.clear_btn)
                val mAdapter:MyUpdateAdapter
                // 添加列表控内容视图
                val emptyView = findViewById<View>(R.id.empty_tv)
                mListView.emptyView = emptyView
                // 初始化列表
                val datas = LinkedList<UpdateData>()
                mAdapter = MyUpdateAdapter(this, datas)
                mListView.adapter = mAdapter
                // 设置按钮点击事件监听器
                //获取列表随机位置
                fun getRandomPosition(): Int {
                    val count = mAdapter.count
                    return (Math.random() * count).toInt()
                }
                //获取100以内的随机数
                fun getRandomNumber(): Double {
                    return Math.random() * 100
                }
                mAddBtn.setOnClickListener{
                    val position = getRandomPosition()
                    mAdapter.add(position, UpdateData(R.mipmap.ic_launcher, "随机添加$position"))
                }
                mUpdateBtn.setOnClickListener {
                    val position = getRandomPosition()
                    mAdapter.update(position, UpdateData(R.mipmap.ic_launcher, "更新" + getRandomNumber()))
                }
                mDeleteBtn.setOnClickListener {
                    val position = getRandomPosition()
                    mAdapter.remove(position)
                }
                mClearBtn.setOnClickListener {
                    mAdapter.clear()
                }
//                mUpdateBtn.setOnClickListener(this)
//                mDeleteBtn.setOnClickListener(this)
//                mClearBtn.setOnClickListener(this)
            }
            "gridview"->{
                setContentView(R.layout.we_sub_gridview)
                title = "GridView简单使用"
                // 应用图标
                val mAppIcons = intArrayOf(
                    R.drawable.bh3_1,
                    R.drawable.bh3_2,
                    R.drawable.bh3_3,
                    R.drawable.bh3_4,
                    R.drawable.bh3_5,
                    R.drawable.bh3_6,
                    R.drawable.bh3_7,
                    R.drawable.bh3_8,
                    R.drawable.bh3_9
                )
                // 应用名
                val mAppNames = arrayOf(
                    "崩坏3-1",
                    "崩坏3-2",
                    "崩坏3-3",
                    "崩坏3-4",
                    "崩坏3-5",
                    "崩坏3-6",
                    "崩坏3-7",
                    "崩坏3-8",
                    "崩坏3-9"
                )
                // 获取界面组件
                val mAppGridView = findViewById<GridView>(R.id.gridview)
                // 初始化数据，创建一个List对象，List对象的元素是Map
                val listItems = ArrayList<Map<String, Any>>()
                for (i in 0 until mAppIcons.size) {
                    val listItem = HashMap<String, Any>()
                    listItem["icon"] = mAppIcons[i]
                    listItem["name"] = mAppNames[i]
                    listItems.add(listItem)
                }
                // 创建一个SimpleAdapter
                val simpleAdapter = SimpleAdapter(
                    this,
                    listItems,
                    R.layout.we_sub_gridview_item,
                    arrayOf("icon", "name"),
                    intArrayOf(R.id.icon_img, R.id.name_tv)
                )
                // 为GridView设置Adapter
                mAppGridView.adapter = simpleAdapter
                mAppGridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                    // 显示被单击的图片
                    Toast.makeText(
                        this@we_sub, mAppNames[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "spinner"->{
                setContentView(R.layout.we_sub_spinner)
                title = "下拉框Spinner"
                // 获取界面布局文件中的Spinner组件
                val mProSpinner = findViewById<Spinner>(R.id.spin_one)
                val mBookSpinner = findViewById<Spinner>(R.id.spin_two)

                val arr = arrayOf("初识Android开发", "Android初识开发", "Android中级开发", "Android高级开发", "Android开发进阶")
                // 创建ArrayAdapter对象
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1, arr
                )
                // 为Spinner设置Adapter
                mBookSpinner.adapter = adapter
                // 为Spinner设置选中事件监听器
//                mProSpinner.onItemSelectedListener = this
                mBookSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                    override fun onNothingSelected(parent: AdapterView<*>?) {}

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val content = parent!!.getItemAtPosition(position).toString()
                        when (parent.id) {
                            R.id.spin_one -> Toast.makeText(
                                this@we_sub, "选择的专业是：$content",
                                Toast.LENGTH_SHORT
                            ).show()
                            R.id.spin_two -> Toast.makeText(
                                this@we_sub, "选择的教材是：$content",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> {
                            }
                        }
                    }

                }
                mProSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                    override fun onNothingSelected(parent: AdapterView<*>?) {}

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val content = parent!!.getItemAtPosition(position).toString()
                        when (parent.id) {
                            R.id.spin_one -> Toast.makeText(
                                this@we_sub, "选择的专业是：$content",
                                Toast.LENGTH_SHORT
                            ).show()
                            R.id.spin_two -> Toast.makeText(
                                this@we_sub, "选择的教材是：$content",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> {
                            }
                        }
                    }

                }

            }
            "autocomplete_textview"->{
                setContentView(R.layout.we_sub_autocomplete_textview)
                title = "自动完成文本框"
                val mContacts = arrayOf("test", "abc", "aaa", "aabbcc", "bac", "ok", "say", "aabbsd")
                val mAutoTv = findViewById<AutoCompleteTextView>(R.id.auto_actv)
                val mMultiAutoTv = findViewById<MultiAutoCompleteTextView>(R.id.mauto_mactv)
                // 创建一个ArrayAdapter，封装数组
                val aa = ArrayAdapter(
                    this,
                    android.R.layout.simple_dropdown_item_1line, mContacts
                )
                mAutoTv.setAdapter(aa)
                mMultiAutoTv.setAdapter(aa)
                mMultiAutoTv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
            }
            "expandlist"->{
                setContentView(R.layout.we_sub_expandlist)
                title = "可折叠列表ExpandableListView"
                // 列表数据
                var mGroupNameList: List<String>? = null
                var mItemNameList: List<List<String>>? = null
                // 适配器
                var mAdapter: MyExpandableListViewAdapter? = null
                val mExpandableListView = findViewById<ExpandableListView>(R.id.expendlist)
                mExpandableListView.setGroupIndicator(null)

                //初始化数据
                // 组名
                mGroupNameList = ArrayList<String>()
                mGroupNameList.add("历代帝王")
                mGroupNameList.add("华坛明星")
                mGroupNameList.add("国外明星")
                mGroupNameList.add("政坛人物")

                mItemNameList = ArrayList<List<String>>()
                // 历代帝王组
                var itemList: MutableList<String> = ArrayList()
                itemList.add("唐太宗李世民")
                itemList.add("秦始皇嬴政")
                itemList.add("汉武帝刘彻")
                itemList.add("明太祖朱元璋")
                itemList.add("宋太祖赵匡胤")
                mItemNameList.add(itemList)
                // 华坛明星组
                itemList = ArrayList()
                itemList.add("范冰冰 ")
                itemList.add("梁朝伟")
                itemList.add("谢霆锋")
                itemList.add("章子怡")
                itemList.add("杨颖")
                itemList.add("张柏芝")
                mItemNameList.add(itemList)
                // 国外明星组
                itemList = ArrayList()
                itemList.add("安吉丽娜•朱莉")
                itemList.add("艾玛•沃特森")
                itemList.add("朱迪•福斯特")
                mItemNameList.add(itemList)
                // 政坛人物组
                itemList = ArrayList()
                itemList.add("唐纳德•特朗普")
                itemList.add("金正恩")
                itemList.add("奥巴马")
                itemList.add("普京")
                mItemNameList.add(itemList)
                // 为ExpandableListView设置Adapter
                mAdapter = MyExpandableListViewAdapter(this, mGroupNameList, mItemNameList)
                mExpandableListView.setAdapter(mAdapter)

                // 监听组点击
                mExpandableListView.setOnGroupClickListener { parent, v, groupPosition, id ->
                    mGroupNameList[groupPosition].isEmpty()
                }
                // 监听每个分组里子控件的点击事件
                mExpandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                    Toast.makeText(
                        this@we_sub,
                        mAdapter!!.getGroup(groupPosition) + ":"
                                + mAdapter!!.getChild(groupPosition, childPosition),
                        Toast.LENGTH_SHORT
                    ).show()
                    false
                }
            }
            "adapterview_filpper"->{
                setContentView(R.layout.we_sub_adapterview_filpper)
                title = "AdapterViewFlipper图片轮播"
                val mImageIds = intArrayOf(
                    R.drawable.bh3_1,
                    R.drawable.bh3_2,
                    R.drawable.bh3_3,
                    R.drawable.bh3_4,
                    R.drawable.bh3_5,
                    R.drawable.bh3_6,
                    R.drawable.bh3_7,
                    R.drawable.bh3_8,
                    R.drawable.bh3_9
                )
                val mFlipper = findViewById<AdapterViewFlipper>(R.id.flipper)
                val mPrevBtn = findViewById<Button>(R.id.prev_btn)
                val mNextBtn = findViewById<Button>(R.id.next_btn)
                val mAutoBtn = findViewById<Button>(R.id.auto_btn)
                val adapter = MyFilpperAdapter(this, mImageIds)
                mFlipper.adapter = adapter
                mPrevBtn.setOnClickListener{
                    // 显示上一个组件
                    mFlipper.showPrevious()
                    // 停止自动播放
                    mFlipper.stopFlipping()
                }
                mNextBtn.setOnClickListener{
                    // 显示下一个组件。
                    mFlipper.showNext()
                    // 停止自动播放
                    mFlipper.stopFlipping()
                }
                mAutoBtn.setOnClickListener{
                    // 开始自动播放
                    mFlipper.startFlipping()
                }
            }
            "stackview"->{
                setContentView(R.layout.we_sub_stackview)
                title = "StackView卡片堆叠"
                val mImageIds = intArrayOf(
                    R.drawable.bh3_11,
                    R.drawable.bh3_12,
                    R.drawable.bh3_13,
                    R.drawable.bh3_14,
                    R.drawable.bh3_15,
                    R.drawable.bh3_16,
                    R.drawable.bh3_17,
                    R.drawable.bh3_18
                )
                // 获取界面组件
                val mStackView = findViewById<StackView>(R.id.stackview)
                val mPrevBtn = findViewById<Button>(R.id.prev_btn)
                val mNextBtn = findViewById<Button>(R.id.next_btn)
                // 为AdapterViewFlipper设置Adapter
                val adapter = MyStackAdapter(this, mImageIds)
                mStackView.adapter = adapter
                mPrevBtn.setOnClickListener{
                    mStackView.showPrevious()
                }
                mNextBtn.setOnClickListener{
                    mStackView.showNext()
                }
            }
            "progressbar"->{
                setContentView(R.layout.we_sub_progressbar)
                title = "进度条ProgressBar"
            }
            "custom_progressbar"->{
                setContentView(R.layout.we_sub_custom_progressbar)
                title = "自定义进度条"
                val mProgressbarImg = findViewById<ImageView>(R.id.mypg_img)
                val mProgressAnimation = mProgressbarImg.drawable as AnimationDrawable
                // 启动动画
                mProgressbarImg.postDelayed({
                    // 启动动画
                    mProgressAnimation.start()
                }, 100)

            }
            "seekbar_ratingbar"->{
                setContentView(R.layout.we_sub_seekbar_ratingbar)
                title = "拖动条SeekBar和星级评分条RatingBar"
                val mSeekBar = findViewById<SeekBar>(R.id.seekBar)
                val mPromptTv = findViewById<TextView>(R.id.prompt_tv)
                val mProgressTv = findViewById<TextView>(R.id.pb_tv)

                // 注册事件监听器
                mSeekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        mPromptTv.text = "停止拖动"
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        mPromptTv.text = "开始拖动"
                    }

                    @SuppressLint("SetTextI18n")
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        mPromptTv.text = "正在拖动"
                        mProgressTv.text = "当前数值:" + progress
                    }
                })
            }
            "viewswitcher"->{
                setContentView(R.layout.we_sub_viewswitcher)
                title = "视图切换组件ViewSwitcher"
                val mViewSwitcher = findViewById<ViewSwitcher>(R.id.viewSwitcher)
                val mPrevBtn = findViewById<Button>(R.id.prev_btn)
                val mNextBtn  = findViewById<Button>(R.id.next_btn)
                mViewSwitcher.setFactory {
                    // 加载R.layout.slide_gridview组件，实际上就是一个GridView组件
                    return@setFactory this@we_sub.layoutInflater.inflate(R.layout.we_sub_viewswitcher_slide_gridview, null)
                }
                // 创建一个包含40个元素的List集合，用于模拟包含40个应用程序
                for (i in 0..39) {
                    val item = ViewSwitcherItemData("item$i", R.drawable.bh3)
                    mItemDatas.add(item)
                }
                // 计算应用程序所占的总屏数
                // 如果应用程序的数量能整除NUMBER_PER_SCREEN，除法的结果就是总屏数
                // 如果不能整除，总屏数应该是除法的结果再加1
                screenCount = if (mItemDatas.size % NUMBER_PER_SCREEN === 0)
                    mItemDatas.size / NUMBER_PER_SCREEN
                else
                    mItemDatas.size / NUMBER_PER_SCREEN + 1

                mAdapter = ViewSwitcherBaseAdapter(this, mItemDatas)

                mPrevBtn.setOnClickListener {
                    if (ViewSwitchers.screenNo > 0) {
                        ViewSwitchers.screenNo--
                        // 为ViewSwitcher的组件显示过程设置动画
                        mViewSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
                        // 为ViewSwitcher的组件隐藏过程设置动画
                        mViewSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)
                        // 控制下一屏将要显示的GridView对应的 Adapter
                        (mViewSwitcher.nextView as GridView).adapter = mAdapter
                        // 单击左边按钮，显示上一屏，当然可以采用手势
                        // 学习手势检测后，也可通过手势检测实现显示上一屏
                        mViewSwitcher.showPrevious()
                    }

                }
                mNextBtn.setOnClickListener {
                    if (ViewSwitchers.screenNo < screenCount - 1) {
                        ViewSwitchers.screenNo++
                        // 为ViewSwitcher的组件显示过程设置动画
                        mViewSwitcher.setInAnimation(this, R.anim.slide_in_right)
                        // 为ViewSwitcher的组件隐藏过程设置动画
                        mViewSwitcher.setOutAnimation(this, R.anim.slide_out_left)
                        // 控制下一屏将要显示的GridView对应的Adapter
                        (mViewSwitcher.nextView as GridView).adapter = mAdapter
                        // 单击右边按钮，显示下一屏
                        // 学习手势检测后，也可通过手势检测实现显示下一屏
                        mViewSwitcher.showNext()
                    }
                }
                if (ViewSwitchers.screenNo < screenCount - 1) {
                    ViewSwitchers.screenNo++
                    // 为ViewSwitcher的组件显示过程设置动画
                    mViewSwitcher.setInAnimation(this, R.anim.slide_in_right)
                    // 为ViewSwitcher的组件隐藏过程设置动画
                    mViewSwitcher.setOutAnimation(this, R.anim.slide_out_left)
                    // 控制下一屏将要显示的GridView对应的Adapter
                    (mViewSwitcher.nextView as GridView).adapter = mAdapter
                    // 单击右边按钮，显示下一屏
                    // 学习手势检测后，也可通过手势检测实现显示下一屏
                    mViewSwitcher.showNext()
                }
            }
            "imageswitcher"->{
                setContentView(R.layout.we_sub_imageswitcher)
                title = "ImageSwitcher使用"
                val mImageIds = intArrayOf(
                    R.drawable.bh3_1,
                    R.drawable.bh3_2,
                    R.drawable.bh3_3,
                    R.drawable.bh3_4,
                    R.drawable.bh3_5
                )
                var mIndex = 0
                val mImageSwitcher = findViewById<ImageSwitcher>(R.id.switcher)
                mImageSwitcher.setFactory(object : ViewSwitcher.ViewFactory{
                    override fun makeView(): View {
                        val imageView = ImageView(this@we_sub)
                        imageView.setBackgroundColor(-0x1000000)
                        // 设置填充方式
                        imageView.scaleType = ScaleType.FIT_XY
                        imageView.layoutParams = FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        return imageView
                    }
                })
                mImageSwitcher.setInAnimation(this, android.R.anim.fade_in)
                mImageSwitcher.setOutAnimation(this, android.R.anim.fade_out)
                // 为ImageSwitcher绑定监听事件
                mImageSwitcher.setOnClickListener {
                    mIndex++
                    if (mIndex >= mImageIds.size) {
                        mIndex = 0
                    }
                    mImageSwitcher.setImageResource(mImageIds[mIndex])
                }

                mImageSwitcher.setImageResource(mImageIds[0])
            }
            "textswitcher"->{
                setContentView(R.layout.we_sub_textswitcher)
                title = "TextSwitcher使用"
                val mContents = arrayOf("你好", "HelloWorld", "Good!!!", "TextSwitcher", "你会了吗？")
                var mIndex: Int = 0
                val mTextSwitcher = findViewById<TextSwitcher>(R.id.textSwitcher)
                mTextSwitcher.setFactory ( object: ViewSwitcher.ViewFactory{
                    override fun makeView(): View {
                        val tv = TextView(this@we_sub)
                        tv.textSize = 40f
                        tv.setTextColor(Color.MAGENTA)
                        return tv
                    }
                })
                mTextSwitcher.setOnClickListener { mTextSwitcher.setText(mContents[mIndex++ % mContents.size]) }
                mTextSwitcher.setText(mContents[0])
            }
            "viewflipper"->{
                setContentView(R.layout.we_sub_viewflipper)
                title = "翻转视图ViewFlipper打造引导页和轮播图"
                // viewflipper定义在里面，触发方法有问题所以放在外面
                val mViewFlipper = findViewById<ViewFlipper>(R.id.details)
                val viewflipper_prev = findViewById<Button>(R.id.viewflipper_prev)
                val viewflipper_auto = findViewById<Button>(R.id.viewflipper_auto)
                val viewflipper_next = findViewById<Button>(R.id.viewflipper_next)
                viewflipper_prev.setOnClickListener {
                    mViewFlipper.setInAnimation(this, R.anim.slide_in_right)
                    mViewFlipper.setOutAnimation(this, R.anim.slide_out_left)
                    // 显示上一个组件
                    mViewFlipper.showPrevious()
                    // 停止自动播放
                    mViewFlipper.stopFlipping()
                }
                viewflipper_next.setOnClickListener {
                    mViewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
                    mViewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
                    // 开始自动播放
                    mViewFlipper.startFlipping()
                }
                viewflipper_auto.setOnClickListener {
                    mViewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
                    mViewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
                    // 显示下一个组件
                    mViewFlipper.showNext()
                    // 停止自动播放
                    mViewFlipper.stopFlipping()
                }
            }
            "datepicker"->{
                setContentView(R.layout.we_sub_datepicker)
                title = "日期选择器"
                //获取日历对象
                val mCalendar = Calendar.getInstance()
                // 获取当前对应的年、月、日的信息
                val mYear = mCalendar.get(Calendar.YEAR)
                val mMonth = mCalendar.get(Calendar.MONTH)
                val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
                // 获取DatePicker组件
                val mDatePicker = findViewById<DatePicker>(R.id.datePicker)
                mDatePicker!!.init(mYear, mMonth, mDay) { view, year, monthOfYear, dayOfMonth ->
                    Toast.makeText(
                        this@we_sub,
                        year.toString() + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
            "timepicker"->{
                setContentView(R.layout.we_sub_timepicker)
                title = "时间选择器"
                //获取日历对象
                val mCalendar = Calendar.getInstance()

                // 获取对应的时、分的信息
                val mHour = mCalendar.get(Calendar.HOUR_OF_DAY)
                val mMinute = mCalendar.get(Calendar.MINUTE)

                // 获取TimePicker组件
                val mTimePicker =findViewById<TimePicker>(R.id.timePicker)
                // 为TimePicker指定监听器
                mTimePicker!!.setOnTimeChangedListener { view, hourOfDay, minute ->
                    Toast.makeText(
                        this@we_sub, "$hourOfDay:$minute",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "numberpicker"->{
                setContentView(R.layout.we_sub_numberpicker)
                title = "数值选择器NumberPicker"

                val mNumberPicker = findViewById<NumberPicker>(R.id.numberPicker)
                // 设置NumberPicker属性
                mNumberPicker.minValue = 1
                mNumberPicker.maxValue = 20
                mNumberPicker.value = 5
                // 监听数值改变事件
                mNumberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                    Toast.makeText(
                        this@we_sub, "选择的是：" + newVal,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "clock"->{
                setContentView(R.layout.we_sub_clock)
                title = "时钟"
            }
            "calendarview_chronnmeter"->{
                setContentView(R.layout.we_sub_calendarview_chronnmeter)
                title = "日历和定时器"
                val mChronometer = findViewById<Chronometer>(R.id.chronometer)

                mChronometer.format = "计时：%s"

                val mchronnmeter_start = findViewById<Button>(R.id.chronnmeter_start)
                val mchronnmeter_stop = findViewById<Button>(R.id.chronnmeter_stop)
                val mchronnmeter_reset = findViewById<Button>(R.id.chronnmeter_reset)
                mchronnmeter_start.setOnClickListener {
                    mChronometer.start()
                }
                mchronnmeter_stop.setOnClickListener {
                    mChronometer.stop()
                }
                mchronnmeter_reset.setOnClickListener {
                    mChronometer.base = SystemClock.elapsedRealtime()
                }

            }
            "scrollview"->{
                setContentView(R.layout.we_sub_scrollview)
                title = "滚动视图"
            }
            "searchview"->{
                setContentView(R.layout.we_sub_searchview)
                title = "搜索框"
                val mSearchView = findViewById<SearchView>(R.id.searchView)
                val mListView = findViewById<ListView>(R.id.listView)
                val mDatas                = arrayOf("aaa", "bbb", "ccc", "airsaid")
                mListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mDatas)
                mListView.isTextFilterEnabled = true

                mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextChange(newText: String?): Boolean {
                        if (!TextUtils.isEmpty(newText)){
                            mListView.setFilterText(newText)
                        }else{
                            mListView.clearTextFilter()
                        }
                        return false
                    }

                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                })

            }
            "tabhosttab"->{
                setContentView(R.layout.we_sub_tabhosttab)
                title = "选项卡TabHost"
                val mTabHost = findViewById<TabHost>(R.id.mytabhost)
                mTabHost.setup()
                val tab1 = mTabHost.newTabSpec("0")
                tab1.setIndicator("红色")
                tab1.setContent(R.id.widget_layout_red)
                mTabHost.addTab(tab1)
                mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator("绿色").setContent(R.id.widget_layout_green))
                mTabHost.addTab(mTabHost.newTabSpec("2").setIndicator("蓝色").setContent(R.id.widget_layout_blue))
            }
            "recyclerview"->{
                setContentView(R.layout.we_sub_recyclerview)
                title = "recyclerview"

                val mRecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
                // 设置管理器
                val layoutManager = GridLayoutManager(this,3)
                mRecyclerView.layoutManager = layoutManager
                // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                mRecyclerView.setHasFixedSize(true)

//                var mAdapter: RecyclerViewAdapter? = null
                val mDatas = ArrayList<String>()

                for (i in 0..60) {
                    mDatas.add(i, (i + 1).toString() + "")
                }
                val mAdapter = RecyclerViewAdapter(this, mDatas)
                mRecyclerView.adapter = mAdapter

                val hengxiang = findViewById<Button>(R.id.recyclerview_hengxiang)
                var pailie = 1
                hengxiang.setOnClickListener {
                    if(pailie ==1){
                        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                        pailie =2
                    } else{
                        layoutManager.orientation = LinearLayoutManager.VERTICAL
                        pailie =1
                    }

                }
            }
            "recyclerview_divider"->{
                setContentView(R.layout.we_sub_recyclerview_divider)
                title = "recyclerview_divider"

                val mRecyclerView = findViewById<RecyclerView>(R.id.recyclerview_divider)
                // 设置管理器
                val layoutManager = LinearLayoutManager(this)
                mRecyclerView.layoutManager = layoutManager

                // 自定义分割线
                val itemDecoration = RecyclerViewItemDivider(this, R.drawable.recyclerview_item_divider)
                mRecyclerView.addItemDecoration(itemDecoration)
                // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                mRecyclerView.setHasFixedSize(true)

//                var mAdapter: RecyclerViewAdapter? = null
                val mDatas = ArrayList<String>()

                for (i in 0..60) {
                    mDatas.add(i, (i + 1).toString() + "")
                }
                val mAdapter = RecyclerViewAdapter_divider(this, mDatas)
                mRecyclerView.adapter = mAdapter
            }
            "recyclerview_click"->{
                setContentView(R.layout.we_sub_recyclerview_click)
                title = "recyclerview点击/长按事件"

                val mRecyclerView = findViewById<RecyclerView>(R.id.recyclerview_click)
                // 设置管理器
                val layoutManager = LinearLayoutManager(this)
                mRecyclerView.layoutManager = layoutManager

                // 自定义分割线
                val itemDecoration = RecyclerViewItemDivider(this, R.drawable.recyclerview_item_divider)
                mRecyclerView.addItemDecoration(itemDecoration)
                // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                mRecyclerView.setHasFixedSize(true)

                val mDatas = ArrayList<String>()

                for (i in 0..60) {
                    mDatas.add(i, (i + 1).toString() + "")
                }
                val mAdapter = RecyclerViewAdapter_click(this, mDatas)
                mAdapter.setOnItemClickListener(object :RecyclerViewAdapter_click.OnItemClickListener {
                    override fun onClick(parent: View?, position: Int) {
                        Toast.makeText(
                            this@we_sub, "点击了第" + (position + 1) + "项",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                })
                mAdapter.setOnItemLongClickListener(object :RecyclerViewAdapter_click.OnItemLongClickListener{
                    override fun onLongClick(parent: View?, position: Int): Boolean {
                        Toast.makeText(
                            this@we_sub, "长压了第" + (position + 1) + "项",
                            Toast.LENGTH_SHORT
                        ).show()
                        return true

                    }

                })

                mRecyclerView.adapter = mAdapter
            }
            "recyclerview_apply"->{
                setContentView(R.layout.we_sub_recyclerview_apply)
                title = "recyclerview数据更新"
                val mRecyclerView = findViewById<RecyclerView>(R.id.recyclerview_apply)
                // 设置管理器
                val layoutManager = LinearLayoutManager(this)
                mRecyclerView.layoutManager = layoutManager

                // 自定义分割线
                val itemDecoration = RecyclerViewItemDivider(this, R.drawable.recyclerview_item_divider)
                mRecyclerView.addItemDecoration(itemDecoration)
                // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                mRecyclerView.setHasFixedSize(true)

                val mDatas = ArrayList<String>()

                for (i in 0..60) {
                    mDatas.add(i, (i + 1).toString() + "")
                }
                val mAdapter = RecyclerViewAdapter_apply(this, mDatas)
                mAdapter.setOnItemClickListener(object :RecyclerViewAdapter_apply.OnItemClickListener {
                    override fun onClick(parent: View?, position: Int) {
                        mAdapter.addData(position + 1)
                    }

                })
                mAdapter.setOnItemLongClickListener(object :RecyclerViewAdapter_apply.OnItemLongClickListener{
                    override fun onLongClick(parent: View?, position: Int): Boolean {
                        mAdapter.removeData(position)
                        return true
                    }

                })

                mRecyclerView.adapter = mAdapter

                mRecyclerView.itemAnimator = DefaultItemAnimator()
            }
            "recyclerview_header_and_footer"->{
                setContentView(R.layout.we_sub_recyclerview_header_and_footer)
                title = "recyclerview添加首尾"
                val mRecyclerView = findViewById<RecyclerView>(R.id.recyclerview_header_and_footer)
                // 设置管理器
                val layoutManager = LinearLayoutManager(this)
                mRecyclerView.layoutManager = layoutManager

                // 自定义分割线
                val itemDecoration = RecyclerViewItemDivider(this, R.drawable.recyclerview_item_divider)
                mRecyclerView.addItemDecoration(itemDecoration)
                // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
                mRecyclerView.setHasFixedSize(true)

                val mDatas = ArrayList<String>()

                for (i in 0..60) {
                    mDatas.add(i, (i + 1).toString() + "")
                }
                val mAdapter = RecyclerViewAdapter_header_and_footer(this, mDatas)
                mAdapter.setOnItemClickListener(object :RecyclerViewAdapter_header_and_footer.OnItemClickListener {
                    override fun onClick(parent: View?, position: Int) {
                        mAdapter.addData(position + 1)
                    }

                })
                mAdapter.setOnItemLongClickListener(object :RecyclerViewAdapter_header_and_footer.OnItemLongClickListener{
                    override fun onLongClick(parent: View?, position: Int): Boolean {
                        mAdapter.removeData(position)
                        return true
                    }

                })

                mRecyclerView.adapter = mAdapter

                mRecyclerView.itemAnimator = DefaultItemAnimator()
            }
            "viewpager"->{
                setContentView(R.layout.we_sub_viewpager)
                title = "ViewPager快速实现引导页"
                val mViewPager = findViewById<ViewPager>(R.id.view_pager)
                val mPageList = ArrayList<View>()
                val inflater = layoutInflater
                mPageList.add(inflater.inflate(R.layout.we_sub_viewpager_pager1,null,false))
                mPageList.add(inflater.inflate(R.layout.we_sub_viewpager_pager2,null,false))
                mPageList.add(inflater.inflate(R.layout.we_sub_viewpager_pager3,null,false))
                val mAdapter = ViewPagerAdapter(mPageList)
                mViewPager.adapter = mAdapter
                mViewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
                    override fun onPageSelected(p0: Int) {
                        Toast.makeText(
                            this@we_sub, "第" + (p0 + 1) + "页",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

                    }

                    override fun onPageScrollStateChanged(p0: Int) {

                    }

                })
            }
            "viewpager_tabhost"->{
                setContentView(R.layout.we_sub_viewpager_tabhost)
                title = "ViewPager实现TabHost"
                val mViewPager = findViewById<ViewPager>(R.id.view_pager_tabhost)
                val mPagerTabStrip = findViewById<PagerTabStrip>(R.id.view_pager_tabstrip)
                val mPageList = ArrayList<View>()
                val inflater = layoutInflater
                mPageList.add(inflater.inflate(R.layout.we_sub_viewpager_pager1,null,false))
                mPageList.add(inflater.inflate(R.layout.we_sub_viewpager_pager2,null,false))
                mPageList.add(inflater.inflate(R.layout.we_sub_viewpager_pager3,null,false))
                val mTitleLists = ArrayList<String>()
                mTitleLists.add("第一项")
                mTitleLists.add("第二项")
                mTitleLists.add("第三项")

                val mAdapter = ViewPagerAdapter_tabhost(mPageList,mTitleLists)
                mViewPager.adapter = mAdapter

                mPagerTabStrip.tabIndicatorColor =Color.BLUE
                mViewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
                    override fun onPageSelected(p0: Int) {
                        Toast.makeText(
                            this@we_sub, "第" + (p0 + 1) + "页",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

                    }

                    override fun onPageScrollStateChanged(p0: Int) {

                    }

                })
            }
            "cardview"->{
                setContentView(R.layout.we_sub_cardview)
                title = "CardView简单实现卡片式布局"
                val mCardView = findViewById<CardView>(R.id.cardview)
                mCardView.radius = 20F
                mCardView.cardElevation = Color.BLUE.toFloat()
                mCardView.cardElevation = 10F
                mCardView.setContentPadding(10,10,10,10)

            }
            "swiperefreshlayout"->{
                setContentView(R.layout.we_sub_swiperefreshlayout)
                title = "SwipeRefreshLayout下拉刷新"
                val mSwipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.container_swipe)
                val mContentTv = findViewById<TextView>(R.id.content_tv)

                mSwipeRefreshLayout.setColorSchemeResources(
                    android.R.color.holo_blue_light,
                    android.R.color.holo_red_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_green_light
                )
                mSwipeRefreshLayout.setOnRefreshListener(object :SwipeRefreshLayout.OnRefreshListener{
                    override fun onRefresh() {
                        mContentTv.text = "正在刷新，请稍后。。。"
                        Handler().run {
                            mContentTv.text = "刷新完毕！"
                            mSwipeRefreshLayout.isRefreshing = false
                        }
                    }
                })

            }
            "activity_rumen"->{
                setContentView(R.layout.we_sub_activity_rumen)
                title = "Activity入门"
            }
            "activity_on_off"->{
                setContentView(R.layout.we_sub_activity_on_off)
                title = "Activity启动和关闭"

                val startBtn = findViewById<Button>(R.id.start_btn)
                startBtn.setOnClickListener {
                    val intent = Intent(this,we_sub_activity_on_off_second::class.java)
                    startActivity(intent)
                }
            }
            "activity_life_cycle"->{
                setContentView(R.layout.we_sub_activity_life_cycle)
                title = "Activity状态和生命周期方法"

                val mStartActivityBtn = findViewById<Button>(R.id.start_normal_activity_btn)
                val mQutiActivityBtn = findViewById<Button>(R.id.quit_activity_btn)

                mStartActivityBtn.setOnClickListener { v ->
                    when (v.id) {
                        R.id.start_normal_activity_btn -> {
                            // 启动普通的Activity
                            val intent = Intent(this@we_sub, we_sub_activity_life_cycle_second::class.java)
                            startActivity(intent)
                        }
                        R.id.quit_activity_btn -> {
                            // 结束该Activity
                            Toast.makeText(
                                this@we_sub,
                                "为什么结束不了可以思考下原理(〜￣△￣)〜",
                                Toast.LENGTH_SHORT
                            ).show()
                            //下面这个不是废代码，是因为我的项目魔改后失效了，可以明白为何失效就算理解了
//                            this@we_sub.finish()
                        }
                        else -> {
                        }
                    }
                }
                mQutiActivityBtn.setOnClickListener { v ->
                    when (v.id) {
                        R.id.start_normal_activity_btn -> {
                            // 启动普通的Activity
                            val intent = Intent(this@we_sub, we_sub_activity_life_cycle_second::class.java)
                            startActivity(intent)
                        }
                        R.id.quit_activity_btn -> {
                            this@we_sub.finish()
                        }
                        else -> {
                        }
                    }
                }
            }
            "activity_save_h_or_v"->{
                setContentView(R.layout.we_sub_activity_save_h_or_v)
                title = "Activity数据保存和横竖屏切换"
            }
            "activity_stack_start"->{
                setContentView(R.layout.we_sub_activity_stack_start)
                title = "Activity任务栈和启动模式"
            }
            "intent"->{
                setContentView(R.layout.we_sub_intent)
                title = "四大组件的纽带——Intent"
            }
            "intent_property_top"->{
                setContentView(R.layout.we_sub_intent_property_top)
                title = "Intent 属性详解（上）"

                val w_intent_property_top_webview = findViewById<WebView>(R.id.intent_property_top_webview)
                w_intent_property_top_webview.settings.javaScriptEnabled = true
                w_intent_property_top_webview.settings.domStorageEnabled = true
                w_intent_property_top_webview.loadUrl("https://blog.csdn.net/cqkxzsxy/article/details/78282448")
            }
            "intent_property_bottom"->{
                setContentView(R.layout.we_sub_intent_property_bottom)
                title = "Intent 属性详解（下）"

                val w_intent_property_bottom_webview = findViewById<WebView>(R.id.intent_property_bottom_webview)
                w_intent_property_bottom_webview.settings.javaScriptEnabled = true
                w_intent_property_bottom_webview.settings.domStorageEnabled = true
                w_intent_property_bottom_webview.loadUrl("https://blog.csdn.net/cqkxzsxy/article/details/78293356")
            }
            "activity_transmit"->{
                setContentView(R.layout.we_sub_activity_transmit)
                title = "Activity数据传递"

                val mNameEt = findViewById<EditText>(R.id.name_et)
                val mPasswordEt = findViewById<EditText>(R.id.password_et)
                val mRegisterBtn = findViewById<Button>(R.id.register_btn)
                val mMaleRb = findViewById<RadioButton>(R.id.male_rb)
                val mFemaleRb = findViewById<RadioButton>(R.id.female_rb)

                mRegisterBtn.setOnClickListener {
                    val intent = Intent(this, we_sub_activity_transmit_second::class.java)
                    intent.putExtra("name",mNameEt.text.toString().trim())
                    intent.putExtra("password",mPasswordEt.text.toString().trim())
                    var str = ""
                    if(mMaleRb.isChecked){
                        str = "男"
                    }else if(mFemaleRb.isChecked){
                        str = "女"
                    }
                    intent.putExtra("sex", str)
                    startActivity(intent)
                }
            }
            "activity_return"->{
                setContentView(R.layout.we_sub_activity_result)
                title = "Activity数据回传"

                val mBuyBtn = findViewById<Button>(R.id.buy_btn)
                mLifeTV = findViewById(R.id.life_progress_tv)
                mAttackTV = findViewById(R.id.attack_progress_tv)
                mSpeedTV = findViewById(R.id.speed_progress_tv)
                mLifePb = findViewById(R.id.life_pb)
                mAttackPb = findViewById(R.id.attack_pb)
                mSpeedPb = findViewById(R.id.speed_pb)

                mLifePb?.max = 100
                mAttackPb?.max = 100
                mSpeedPb?.max = 100

                mBuyBtn.setOnClickListener {
                    val intent = Intent(this,we_sub_shopactivity::class.java)
                    startActivityForResult(intent,1)
                }
            }
            "activity_data_sub"->{
                setContentView(R.layout.we_sub_activity_data_sub)
                title = "Activity间数据传递方法汇总"

                val w_intent_property_top_webview = findViewById<WebView>(R.id.activity_data_sub_webview)
                w_intent_property_top_webview.settings.javaScriptEnabled = true
                w_intent_property_top_webview.settings.domStorageEnabled = true
                w_intent_property_top_webview.loadUrl("https://blog.csdn.net/cqkxzsxy/article/details/78339914")
            }
            "fragment"->{
                //这里就是建立fragment,并无任何使用的一个判断分支，根据教学文档来
            }
            "fragment_play"->{
                setContentView(R.layout.we_sub_fragment_play)
                title = "Fragment使用"
                //这里不是用静态加载，直接使用动态加载

                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val firstFragment = FirstFragment()
                fragmentTransaction.add(R.id.fragment_container,firstFragment)
                fragmentTransaction.commit()
            }
            "fragment_life_cycle"->{
                setContentView(R.layout.we_sub_fragment_life_cycle)
                title = "Fragment生命周期"
            }
            "fragment_add_delete"->{
                setContentView(R.layout.we_sub_fragment_add_delete)
                title = "Fragment添加，修改，删除"
                val mAddBtn = findViewById<Button>(R.id.add_btn)
                val mRemoveBtn  = findViewById<Button>(R.id.remove_btn)
                val mReplaceBtn  = findViewById<Button>(R.id.replace_btn)
                val mSecondFragment = we_sub_fragment_add_delete_second()
                val mThirdFragment = we_sub_fragment_add_delete_third()

                mAddBtn.setOnClickListener {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    // 向容器内加入Fragment
                    if (!mSecondFragment.isAdded) {
                        fragmentTransaction.add(R.id.fragment_container1, mSecondFragment)
                    }
                    if (!mThirdFragment.isAdded) {
                        fragmentTransaction.add(R.id.fragment_container2, mThirdFragment)
                    }
                    fragmentTransaction.commit()
                }
                mRemoveBtn.setOnClickListener {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.remove(mSecondFragment)
                    fragmentTransaction.commit()
                }
                mReplaceBtn.setOnClickListener {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    if (!mSecondFragment.isAdded) {
                        fragmentTransaction.replace(R.id.fragment_container2, mSecondFragment)
                    }
                    fragmentTransaction.commit()
                }

            }
            "fragment_display"->{
                //显示和隐藏只是可见不可见，实际操作实用性极低，尽量使用绑定和解绑
                //这里只展示绑定和解绑
                setContentView(R.layout.we_sub_fragment_display)
                title = "Fragment显示和隐藏、绑定和解绑"

                val mAttachBtn  = findViewById<Button>(R.id.attach_btn)
                val mDetachBtn  = findViewById<Button>(R.id.detach_btn)
                val mDemoFragment = we_sub_fragment_display_show_hide()
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.fragment_container_display,mDemoFragment)
                fragmentTransaction.commit()

                mAttachBtn.setOnClickListener {
                    val fragmentManager_mAttachBtn = supportFragmentManager
                    val fragmentTransaction_mAttachBtn = fragmentManager_mAttachBtn.beginTransaction()
                    if (mDemoFragment.isDetached) {
                        fragmentTransaction_mAttachBtn.attach(mDemoFragment)
                    }
                    fragmentTransaction_mAttachBtn.commit()
                }
                mDetachBtn.setOnClickListener {
                    val fragmentManager_mAttachBtn = supportFragmentManager
                    val fragmentTransaction_mAttachBtn = fragmentManager_mAttachBtn.beginTransaction()
                    if (!mDemoFragment.isDetached) {
                        fragmentTransaction_mAttachBtn.detach(mDemoFragment)
                    }
                    fragmentTransaction_mAttachBtn.commit()
                }
            }
            "fragment_back"->{
                setContentView(R.layout.we_sub_fragment_add_delete)
                title = "Fragment回退栈及弹出方法"

                val mAddBtn = findViewById<Button>(R.id.add_btn)
                val mRemoveBtn  = findViewById<Button>(R.id.remove_btn)
                val mReplaceBtn  = findViewById<Button>(R.id.replace_btn)
                val mSecondFragment = we_sub_fragment_add_delete_second()
                val mThirdFragment = we_sub_fragment_add_delete_third()

                mAddBtn.setOnClickListener {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    // 向容器内加入Fragment
                    if (!mSecondFragment.isAdded) {
                        fragmentTransaction.add(R.id.fragment_container1, mSecondFragment)
                    }
                    if (!mThirdFragment.isAdded) {
                        fragmentTransaction.add(R.id.fragment_container2, mThirdFragment)
                    }
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                mRemoveBtn.setOnClickListener {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.remove(mSecondFragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                mReplaceBtn.setOnClickListener {
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    if (!mSecondFragment.isAdded) {
                        fragmentTransaction.replace(R.id.fragment_container2, mSecondFragment)
                    }
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            }
            else ->{
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // 获取更改后的屏幕方向
        val screen = newConfig.orientation
        val ori = if (Configuration.ORIENTATION_LANDSCAPE === screen) "横屏" else "竖屏"

        // 消息提示
        Toast.makeText(this, "系统的屏幕方向改变为：$ori", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        Log.d("这里触发了", "onStart()")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("这里触发了", "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("这里触发了", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("这里触发了", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("这里触发了", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("这里触发了", "onDestroy()")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (resultCode == 1) {
                if (requestCode == 1) {
                    val equipment = data.extras
                    //更新ProgressBar的值
                    val lifeProgress = mLifePb?.progress
                    val attackProgress = mAttackPb?.progress
                    val speedProgress = mSpeedPb?.progress

                    mLifePb?.progress = lifeProgress!! + equipment.getInt(we_sub_shopactivity.DATA_KEY_LIFE)
                    mAttackPb?.progress = attackProgress!! + equipment.getInt(we_sub_shopactivity.DATA_KEY_ATTACK)
                    mSpeedPb?.progress = speedProgress!! + equipment.getInt(we_sub_shopactivity.DATA_KEY_SPEED)
                    mLifeTV?.text=mLifePb!!.progress.toString()
                    mAttackTV?.text=mAttackPb!!.progress.toString()
                    mSpeedTV?.text= mSpeedPb!!.progress.toString()
                }
            }
        }
    }
}




