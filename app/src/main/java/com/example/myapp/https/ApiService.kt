package com.wjx.android.wanandroidmvvm.base.https

import com.example.myapp.bean.BaseResp
import com.example.myapp.bean.WBean
import com.wjx.android.wanandroidmvvm.ui.account.data.LoginResponse
import com.wjx.android.wanandroidmvvm.ui.account.data.RegisterResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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