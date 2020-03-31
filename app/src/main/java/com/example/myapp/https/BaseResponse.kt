package com.wjx.android.wanandroidmvvm.base.https

/**
 * @Author yangtianfu
 * @CreateTime 2020/3/31 21:22
 * @Describe 
 */

open class BaseResponse<T>(var data: T, var errorCode: Int = -1, var errorMessage: String = "")