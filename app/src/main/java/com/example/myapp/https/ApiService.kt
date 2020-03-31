package com.wjx.android.wanandroidmvvm.base.https

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

//    @POST("/user/login")
//   fun onLogin(
//        @Query("username") username: String,
//        @Query("password") password: String
//    ): Observable<BaseResponse<LoginResponse>>


//    @POST("/user/register")
//    fun onRegister(
//        @Query("username") username: String, @Query("password") password: String,
//        @Query("repassword") repassword: String
//    ): Observable<BaseResponse<RegisterResponse>>

    @POST("/user/login")
   suspend fun onLogin(
        @Query("username") username: String,
        @Query("password") password: String
    ): BaseResponse<LoginResponse>

    @POST("/user/register")
    suspend fun onRegister(
        @Query("username") username: String, @Query("password") password: String,
        @Query("repassword") repassword: String
    ): BaseResponse<RegisterResponse>


}