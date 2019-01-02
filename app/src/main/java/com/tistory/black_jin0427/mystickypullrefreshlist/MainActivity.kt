package com.tistory.black_jin0427.mystickypullrefreshlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tistory.black_jin0427.mystickypullrefreshlist.sample.getMovieItems
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private val adapter by lazy { MaterialAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initRecyclerview()
        initButton()
    }

    override fun onRefresh() {

        toast("swipe")

        Handler().postDelayed({

            swipeLayout.isRefreshing = false
        }, 1000)
    }

    private fun initToolbar() {

        // set toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = null

        // set toolbar image
        Glide.with(this)
                .load("https://i.ytimg.com/vi/vLRZ6U1XMfc/maxresdefault.jpg")
                .into(imageView)

    }

    private fun initRecyclerview() {

        // set recycler view
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        // set item
        adapter.setItems(getMovieItems())

        // set Swipe
        swipeLayout.setOnRefreshListener(this)

    }

    private fun initButton() {

        button1.setOnClickListener {
            toast("btn1")
        }

        button2.setOnClickListener {
            toast("btn2")
        }

        button3.setOnClickListener {
            toast("btn3")
        }
    }

}
