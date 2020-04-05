package com.example.myapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.R
import com.example.myapp.bean.Animal
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.moudle.NetViewMoudle
import com.example.myapp.vm.AnimalViewModel
import com.google.gson.Gson
import com.wjx.android.wanandroidmvvm.base.https.ApiService
import com.wjx.android.wanandroidmvvm.base.https.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.jvm.java as java

class MainActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityMainBinding
    lateinit var mViewMode:AnimalViewModel

    lateinit var netViewModel:NetViewMoudle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var animal = Animal("dog",0)
        mViewMode = AnimalViewModel(animal)
        mBinding.model = mViewMode //model指代xml xml中 name="model"的VM对象

//      创建view model
//        netViewModel = ViewModelProviders.of(this).get(NetViewMoudle::class.java)
        netViewModel = ViewModelProvider(this).get(NetViewMoudle::class.java)

//        请求网络
        mBinding.listener = View.OnClickListener {
            when(it.id){
                R.id.btn ->  netViewModel.getTopArticle()
            }
        }
//        数据变化更新UI,livedata的数据被观察
        netViewModel.list.observe(this, Observer {
            tv.text = Gson().toJson(it)
        })

    }


}
