package com.sopt.week2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.week2.databinding.HeaderLayoutBinding
import com.sopt.week2.databinding.ItemLayoutBinding

class HomeAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy {LayoutInflater.from(context)}
    private var userList = mutableListOf<UserData>()

    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_HEADER ->
                HeadViewHolder(
                    HeaderLayoutBinding.inflate(inflater, parent, false)
                )
            else-> HomeViewHolder(
                ItemLayoutBinding.inflate(inflater, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    override fun getItemCount(): Int = userList.size + 1

    class HomeViewHolder(
        private val binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserData) {
            binding.ivImg.setImageResource(data.image)
            binding.tvTitle.text=data.title
            binding.tvName.text=data.name
        }
    }

    class HeadViewHolder(
        private val binding: HeaderLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) { }

    fun setUserList(userList:List<UserData>){
        this.userList = userList.toList() as MutableList<UserData>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> holder.onBind(userList[position])
            else -> {}
        }
    }

}
