package com.example.youtubeapi34.repostiroy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi34.BuildConfig
import com.example.youtubeapi34.`object`.Constant
import com.example.youtubeapi34.model.PlayList
import com.example.youtubeapi34.remote.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val youtubeApi: YoutubeApi) {

    fun createCall(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()

        youtubeApi.getPlayLists(
            Constant.PART, Constant.CHANNEL_ID,
            BuildConfig.API_KEY,
            Constant.MAX_RESULT
        ).enqueue(object : Callback<PlayList> {

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