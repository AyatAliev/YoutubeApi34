package com.example.youtubeapi34.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi34.model.PlayList
import com.example.youtubeapi34.repostiroy.Repository

class PlayListViewModel(private val repository: Repository) : ViewModel() {

    fun getPlayList(): LiveData<PlayList> {
        return repository.createCall()
    }
}