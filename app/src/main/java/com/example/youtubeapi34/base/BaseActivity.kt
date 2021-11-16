package com.example.youtubeapi34.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var viewBinding: VB
    protected abstract fun inflateViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateViewBinding()
        setContentView(viewBinding.root)
        checkInternet()
        setUI()
        setupLiveData()
        clickListener()

    }

    abstract fun clickListener() // внутри этого метода обрабатываем все клики

    abstract fun setUI() // инициализация UI

    abstract fun checkInternet()

    abstract fun setupLiveData()

}