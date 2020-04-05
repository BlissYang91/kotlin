package com.example.myapp.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.myapp.bean.BaseResp

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/1 19:59
 * @Describe  数据解析扩展函数 顶层声明 作用域为package
 */

fun <T> BaseResp<T>.dataConvert(): T {
    if (errorCode == 0) {
        return data
    } else {
        throw Exception(errorMsg)
    }
}

/**
 * 全局toast
 */
fun Context.toast(msg: String) {
    Toast.makeText(this, msg,  LENGTH_SHORT).show()
}

/**
 * 全局跳转
 */
fun Activity.openActivity(cls: Class<*>) {
    startActivity(Intent(this, cls))
}