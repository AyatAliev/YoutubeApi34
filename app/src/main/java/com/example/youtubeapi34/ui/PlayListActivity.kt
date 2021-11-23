package com.example.youtubeapi34.ui

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi34.base.BaseActivity
import com.example.youtubeapi34.databinding.ActivityMainBinding
import com.example.youtubeapi34.model.Items

class PlayListActivity : BaseActivity<ActivityMainBinding>(),OnClickItem {

    private lateinit var viewModel: PlayListViewModel
    private lateinit var adapter: PlayListAdapter

    override fun setUI() {
    }

    private fun initRecyclerView() {

        viewBinding.rvPlaylist.apply {
            layoutManager = LinearLayoutManager(this@PlayListActivity,LinearLayoutManager.VERTICAL,false)
            adapter = this@PlayListActivity.adapter
        }
    }

    override fun setupLiveData() {
        viewModel = ViewModelProvider(this)[PlayListViewModel::class.java]


        viewModel.getPlayList().observe(this) {
            adapter = PlayListAdapter(it,this)
            initRecyclerView()
        }
    }

    override fun clickListener() {
    }

    override fun checkInternet() {
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onPlayListItemClick(id: String) {

    }

/*    1. Создать свой ApiKey и ознакомиться с документацией
    2. Добавить в класс playlist поле "items", отрисовать первых 2 экрана из фигмы (Проверка на интернет, и список всех PlayList)
    3. Cделать переход на новую активити и передаете туда id и её отображаете тостом*/

}