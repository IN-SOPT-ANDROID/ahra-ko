package org.sopt.sample.MusicList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.sopt.sample.databinding.ItemLayoutBinding
import org.sopt.sample.remote.api.ResponseMusicShowDTO

class MusicAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var musicList: List<ResponseMusicShowDTO.Data> = emptyList()

    class MusicViewHolder(private val binding: ItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun setMusic(data: ResponseMusicShowDTO.Data) {
            binding.ivAlbum.load(data.image)
            binding.tvTitle.text = data.title
            binding.tvSinger.text = data.singer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MusicViewHolder) holder.setMusic(musicList[position])
    }

    override fun getItemCount() = musicList.size

    fun setMusicList(musicList: MutableList<ResponseMusicShowDTO.Data>){
        this.musicList = musicList.toList()
        notifyDataSetChanged()
    }
}