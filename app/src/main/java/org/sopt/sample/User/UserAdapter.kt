package org.sopt.sample.User

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.databinding.ItemLayoutBinding
import org.sopt.sample.remote.api.ResponseUser
import com.bumptech.glide.Glide

class UserAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var userList: List<ResponseUser.User> = emptyList()

    class UserViewHolder(private val binding: ItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun setUser(user: ResponseUser.User) {
            Glide.with(this.binding.root)
                .load(user.avatar)
                .circleCrop()
                .into(binding.ivImg)

            binding.tvFirstname.text = user.first_name
            binding.tvEmail.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemLayoutBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) holder.setUser(userList[position])
    }

    override fun getItemCount() = userList.size

    fun setRepoList(userList: List<ResponseUser.User>){
        this.userList = userList.toList()
        notifyDataSetChanged()
    }

}