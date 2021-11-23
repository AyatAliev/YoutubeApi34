package com.example.youtubeapi34.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi34.databinding.ItemPlaylistBinding
import com.example.youtubeapi34.extensions.loadImage
import com.example.youtubeapi34.model.Items
import com.example.youtubeapi34.model.PlayList

class PlayListAdapter(
    private val playList: PlayList,
    private val listener: OnClickItem
) : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false),listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playList.items[position])
    }

    override fun getItemCount(): Int {
        return playList.items.size
    }

    inner class ViewHolder(private val containerView: ItemPlaylistBinding, var listener: OnClickItem) :
        RecyclerView.ViewHolder(containerView.root) {

        fun onBind(playList: Items) {
            containerView.tvTitle.text = playList.snippet.title
            containerView.ivPlaylist.loadImage(playList.snippet.thumbnails.default.url)

        }
    }
}

interface OnClickItem {
    fun onPlayListItemClick(id: String)
}

