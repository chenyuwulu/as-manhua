package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.Toast
import android.widget.CompoundButton
import android.widget.RadioGroup

class we_sub : AppCompatActivity() {
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
            else ->{
            }
        }
    }
}