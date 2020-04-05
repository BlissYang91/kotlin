package com.example.myapp.bean

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/5 19:29
 * @Describe
 */
data class Result<T>(val code: Int, val errorMsg: String?, val data: T)