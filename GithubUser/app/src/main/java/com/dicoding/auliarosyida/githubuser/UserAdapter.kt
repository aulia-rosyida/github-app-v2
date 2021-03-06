package com.dicoding.auliarosyida.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.auliarosyida.githubuser.databinding.ItemRowUserBinding

class UserAdapter(private val listUser: MutableList<User>): RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class ListViewHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding){
                Glide.with(itemView.context)
                        .load(user.photo)
                        .apply(RequestOptions().override(55, 55))
                        .into(imgItemPhoto)

                if(user.username.equals("Please try with another username")) {
                    tvItemName.text = user.name
                    tvItemUsername.text = user.username
                }
                else {
                    tvItemName.text = user.username
                    tvItemUsername.text = "@${user.username}"
                }

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(user) }
            }
        }
    }

}