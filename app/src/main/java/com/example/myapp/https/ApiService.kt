package com.wjx.android.wanandroidmvvm.base.https

import com.example.myapp.bean.BaseResp
import com.example.myapp.bean.WBean
import retrofit2.http.GET

/**
 * @Author yangtianfu
 * @CreateTime 2020/3/31 21:04
 * @Describe retrofit 使用协程定义api
 */

interface ApiService {

    /**
     * 使用协程进行网络请求
     */
    @GET("article/top/json/")
    suspend fun getTopArticle(): BaseResp<List<WBean>>

}