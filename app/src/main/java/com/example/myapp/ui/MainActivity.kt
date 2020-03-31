package com.example.myapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.bean.Animal
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.vm.AnimalViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityMainBinding
    lateinit var mViewMode:AnimalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        var animal = Animal("dog",0)
        mViewMode = AnimalViewModel(animal)
        mBinding.model = mViewMode //model指代xml xml中 name="model"的VM对象

    }
}
