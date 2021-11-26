package com.example.youtubeapi34.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi34.base.BaseActivity
import com.example.youtubeapi34.databinding.ActivityMainBinding
import com.example.youtubeapi34.model.PlayList
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("NotifyDataSetChanged")
class PlayListActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: PlayListViewModel by viewModel()

    private lateinit var playList: PlayList
    private val adapter: PlayListAdapter by lazy { PlayListAdapter(playList,this::clickListener) }

    override fun setUI() {

    }

    private fun initRecyclerView() {

        viewBinding.rvPlaylist.apply {
            layoutManager = LinearLayoutManager(this@PlayListActivity,LinearLayoutManager.VERTICAL,false)
            adapter = this@PlayListActivity.adapter
        }

        adapter.notifyDataSetChanged()
    }

    override fun setupLiveData() {
        viewModel.getPlayList().observe(this) {
            playList = it
            initRecyclerView()
        }
    }

    private fun clickListener(id: String) {
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show()
    }

    override fun checkInternet() {
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupClickListener() {

    }
}