package com.example.myapp.ext

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