package com.example.myapp.bean

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/1 18:08
 * @Describe
 */


data class BaseResp<T> (
    var errorCode: Int = 0,
    var errorMsg: String = "",
    var data: T
)