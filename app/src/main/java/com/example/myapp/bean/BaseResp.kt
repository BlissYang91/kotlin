package com.example.myapp.bean

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/1 18:08
 * @Describe 返回数据最外层包装
 */


data class BaseResp<T> (
    var errorCode: Int = 0,
    var errorMsg: String = "",
    var data: T
)