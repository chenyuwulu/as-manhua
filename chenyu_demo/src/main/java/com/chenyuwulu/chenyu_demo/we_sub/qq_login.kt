package com.chenyuwulu.chenyu_demo.we_sub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.chenyuwulu.chenyu_demo.R
import com.tencent.connect.UserInfo
import com.tencent.connect.common.Constants
import com.tencent.tauth.IUiListener
import com.tencent.tauth.Tencent
import com.tencent.tauth.UiError
import kotlinx.android.synthetic.main.we_sub_qq_login.*
import org.json.JSONException
import org.json.JSONObject

class qq_login : AppCompatActivity() {

    private val TAG = "qq_login"
    private lateinit var  mTencent: Tencent
    private var mUserInfo: UserInfo? = null
    private lateinit var image : ImageView
    private lateinit var mIUiListener:IUiListener
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.we_sub_qq_login)
        val mAppid = "1109647204"
//        val image = findViewById<ImageView>(R.id.iv_icon)
//        val tv_result = findViewById<TextView>(R.id.tv_result)
        mTencent = Tencent.createInstance(mAppid, this)
        this.tencent_login.setOnClickListener{
            //all表示获取所有权限
            mIUiListener = BaseUiListener()
//            调起QQ小程序
//            mTencent.startMiniApp(this, "1109689877", "pages/index/index", "release")
            mTencent.login(this, "all", mIUiListener)

        }
    }

    inner class BaseUiListener : IUiListener {

        override fun onComplete(response: Any) {
            Toast.makeText(this@qq_login, "授权成功", Toast.LENGTH_SHORT).show()
            Log.e(TAG, "response:$response")
            val obj = response as JSONObject
            try {
                val openID = obj.getString("openid")
                val accessToken = obj.getString("access_token")
                val expires = obj.getString("expires_in")
                mTencent.openId = openID
                mTencent.setAccessToken(accessToken, expires)
                val qqToken = mTencent.qqToken
                mUserInfo = UserInfo(applicationContext, qqToken)
                mUserInfo!!.getUserInfo(object : IUiListener {
                    override fun onComplete(response: Any) {
                        //是一个json串response.tostring，直接使用gson解析就好
                        Log.e(TAG, "登录成功$response")
                        //登录成功后进行Gson解析即可获得你需要的QQ头像和昵称
                        // Nickname  昵称
                        val we_obj = response as JSONObject
                        Toast.makeText(this@qq_login, we_obj.getString("nickname"), Toast.LENGTH_SHORT).show()
//                        Glide.with(this@qq_login).load(we_obj.getString("figureurl_qq")).into(this@qq_login.iv_icon);
                        //Figureurl_qq_1 //头像
                        loadNetImage(we_obj.getString("figureurl_qq"))

                    }
                    fun loadNetImage(src : String){
                        Glide.with(this@qq_login).load(src).into(this@qq_login.iv_icon)
                    }
                    override fun onError(uiError: UiError) {
                        Log.e(TAG, "登录失败$uiError")
                    }

                    override fun onCancel() {
                        Log.e(TAG, "登录取消")

                    }
                })
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }

        override fun onError(uiError: UiError) {
            Toast.makeText(this@qq_login, "授权失败", Toast.LENGTH_SHORT).show()

        }

        override fun onCancel() {
            Toast.makeText(this@qq_login, "授权取消", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}