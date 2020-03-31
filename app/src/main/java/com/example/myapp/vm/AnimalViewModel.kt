package com.example.myapp.vm

import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.myapp.R
import com.example.myapp.bean.Animal
import com.wjx.android.wanandroidmvvm.base.https.BaseResponse
import com.wjx.android.wanandroidmvvm.ui.account.data.LoginResponse

/**
 * @Author yangtianfu
 * @CreateTime 2020/3/31 18:08
 * @Describe VM层 做数据处理并更新xml中UI数据
 */
class AnimalViewModel(val animal: Animal)  {
    //将info变量作为被观察者绑定到xml中的文本上
    val info =  ObservableField("${animal.name} 叫了 ${animal.shoutCount}声..")

    /**
     * 点击xml中按钮闭包执行此方法,更新text文本的绑定字段info的值，继而更新UI数据
     */
    fun shot(){
        animal.shoutCount++
        info.set("${animal.name} 叫了 ${animal.shoutCount}声..")
    }

    //使用协程请求网络
    val mLoginData : MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()


}