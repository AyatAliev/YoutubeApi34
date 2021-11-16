package com.example.youtubeapi34.ui

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi34.base.BaseActivity
import com.example.youtubeapi34.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: MainViewModel

    override fun setUI() {
    }

    override fun setupLiveData() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getPlayList().observe(this) {

            viewBinding.tvTitle.text = it.kind
        }
    }

    override fun clickListener() {
    }

    override fun checkInternet() {
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}