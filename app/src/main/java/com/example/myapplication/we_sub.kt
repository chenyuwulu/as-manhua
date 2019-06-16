package com.example.myapplication

import android.content.res.Configuration
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
import android.support.v4.app.NotificationCompat.getGroup
import android.app.ExpandableListActivity










class we_sub : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = intent.getStringExtra(MainActivity.ojbk.we_sub)
        when (message) {
            "textview" -> {
                setContentView(R.layout.we_sub_textview)
                setTitle("文本框展示")
            }
            "edittext" -> {
                setContentView(R.layout.we_sub_edittext)
                setTitle("可编辑文本框展示")
            }
            "button" -> {
                setContentView(R.layout.we_sub_button)
                setTitle("按钮展示")
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
                setTitle("复选和单选框展示")
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
                setTitle("开关按钮展示")
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
                setTitle("图片视图展示")
            }
            "imagebutton" -> {
                setContentView(R.layout.we_sub_imagebutton)
                setTitle("图片按钮展示")
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
                setTitle("自定义view展示")
            }
            "linearlayout" -> {
                setContentView(R.layout.we_sub_linearlayout)
                setTitle("线性布局展示")
            }
            "gravity_layout_gravity" -> {
                setContentView(R.layout.we_sub_gravity_layout_gravity)
                setTitle("布局重心展示")
            }
            "padding_margin" -> {
                setContentView(R.layout.we_sub_padding_margin)
                setTitle("padding&margin展示")
            }
            "relativelayout" -> {
                setContentView(R.layout.we_sub_relativelayout)
                setTitle("相对布局展示")
            }
            "tablelayout" -> {
                setContentView(R.layout.we_sub_tablelayout)
                setTitle("表格布局展示")
            }
            "framelayout" -> {
                setContentView(R.layout.we_sub_framelayout)
                setTitle("帧布局展示")
            }
            "absolutelayout" -> {
                setContentView(R.layout.we_sub_absolutelayout)
                setTitle("绝对布局展示")
            }
            "gridlayout" -> {
                setContentView(R.layout.we_sub_gridlayout)
                setTitle("网格布局展示")
            }
            "33" -> {
                setContentView(R.layout.we_sub_33)
                setTitle("Android事件展示")
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
                setTitle("Android事件监听展示")
            }
            "35"->{
                setContentView(R.layout.we_sub_35)
                setTitle("Android回调事件展示")
            }
            "36"->{
                setContentView(R.layout.we_sub_36)
                setTitle("Android系统事件展示")
                val configurationTv = findViewById(R.id.configuration_tv) as TextView

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
                setTitle("listview展示")
            }
            "adapter"->{
                setContentView(R.layout.we_sub_adapter)
                setTitle("adapter展示")
                // 获取界面ListView组件
                val listView = findViewById(R.id.listview) as ListView

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
                setTitle("listactivity监听展示")
                // 获取界面ListView组件
                val listView = findViewById(R.id.listview) as ListView

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
                setTitle("arrayadapter展示")
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
                setTitle("simpleadapter展示")
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
                listView.setAdapter(adapter)
            }
            "baseadapter" -> {
                setContentView(R.layout.we_sub_baseadapter)
                setTitle("baseadapter展示")
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
                val listView = findViewById(R.id.listview) as ListView

                // 将数组包装为自定义MyBaseAdapter
                val adapter = MyBaseAdapter(this, getData(), R.layout.we_sub_baseadapter_item)

                // 为ListView设置Adapter
                listView.adapter = adapter

            }
            "listview优化暂为空"->{
            }
            "listview_apply"->{
                setContentView(R.layout.we_sub_listview_apply)
                setTitle("重写类，所以没内嵌在里面，放在外面UpdateDataActivity这个类里")
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
                    val count = mAdapter.getCount()
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
                setTitle("GridView简单使用")
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
                setTitle("下拉框Spinner")
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
                mProSpinner.onItemSelectedListener = this
                mBookSpinner.onItemSelectedListener = this
            }
            "autocomplete_textview"->{
                setContentView(R.layout.we_sub_autocomplete_textview)
                setTitle("自动完成文本框")
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
                setTitle("可折叠列表ExpandableListView")
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
                        mAdapter.getGroup(groupPosition) + ":"
                                + mAdapter.getChild(groupPosition, childPosition),
                        Toast.LENGTH_SHORT
                    ).show()
                    false
                }
            }
            "adapterview_filpper"->{
                setContentView(R.layout.we_sub_adapterview_filpper)
                setTitle("AdapterViewFlipper图片轮播")
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
                setTitle("StackView卡片堆叠")
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
    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val content = parent.getItemAtPosition(position).toString()
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
    override fun onNothingSelected(adapterView: AdapterView<*>) {}
}