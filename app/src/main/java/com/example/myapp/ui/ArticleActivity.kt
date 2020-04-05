package com.example.myapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.adapter.ArticleAdapter
import com.example.myapp.ext.toast
import com.example.myapp.vm.ArticleViewModel
import kotlinx.android.synthetic.main.activity_view_model.*

class ArticleActivity : AppCompatActivity() {
    private val adapter by lazy { ArticleAdapter() }
    lateinit var viewModel: ArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
         viewModel = ArticleViewModel()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        //观察文章列表数据
        viewModel.articleListData.observe(this, Observer { list ->
            //articleListData 的值改变时触发此监听
            loadProgress.visibility = View.GONE
            adapter.submitList(list)
        })
        viewModel.errorMsg.observe(this, Observer {
            if (it!=null){
                toast(it)
            }
        })
        btn.setOnClickListener {
            loadProgress.visibility = View.VISIBLE
            viewModel.fetch(1) //请求数据
        }
    }
}
