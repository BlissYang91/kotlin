package com.example.myapp.moudle

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.bean.WBean
import com.example.myapp.ext.dataConvert
import com.wjx.android.wanandroidmvvm.base.https.ApiService
import com.wjx.android.wanandroidmvvm.base.https.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.math.log

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/1 19:18
 * @Describe 自带生命周期的viewmoudle
 */
class NetViewMoudle :ViewModel() {
//   vm持有数据层引用，并利用livedata赋值更新UI
    var list= MutableLiveData<List<WBean>>()

    /**
     * viewModelScope是一个绑定到当前viewModel的作用域  当ViewModel被清除时会自动取消该作用域，所以不用担心内存泄漏为问题
     */
    fun getTopArticle(){
        viewModelScope.launch {
            try {
                //withContext表示挂起块  配合Retrofit声明的suspend函数执行 该块会挂起直到里面的网络请求完成 最后一行就是返回值
                val data = withContext(Dispatchers.IO){
                    //dataConvert扩展函数可以很方便的解析出我们想要的数据  接口很多的情况下下可以节省不少无用代码
                    RetrofitFactory.instance.getService(ApiService::class.java).getTopArticle().dataConvert()
                }
                //给LiveData赋值  ui会自动更新
                list.value = data
            }catch (e:Exception){
                e.printStackTrace()
                Log.e("net error","网络请求错误${e.toString()}")
            }
        }
    }
}