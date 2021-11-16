package com.example.youtubeapi34.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi34.BuildConfig.API_KEY
import com.example.youtubeapi34.`object`.Constant
import com.example.youtubeapi34.model.PlayList
import com.example.youtubeapi34.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val youtubeApi = RetrofitClient.create()

    fun getPlayList(): LiveData<PlayList> {
        return createCall()
    }

    private fun createCall(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()

        youtubeApi.getPlayLists(Constant.PART, Constant.CHANNEL_ID, API_KEY)
            .enqueue(object : Callback<PlayList> {

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    print(t.stackTrace)
                    // 404 не найдено // 403 - токен истек // 401 - нет доступа
                }
            })
        return data
    }
}