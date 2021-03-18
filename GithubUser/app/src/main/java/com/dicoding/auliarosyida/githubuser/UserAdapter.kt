package com.dicoding.auliarosyida.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()

    override fun getCount(): Int = users.size

    override fun getItem(i: Int): Any = users[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_row_user, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder constructor(view: View) {
        private val txtUsername: TextView = view.findViewById(R.id.tv_item_username)
        private val txtName: TextView = view.findViewById(R.id.tv_item_name)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_item_photo)
        internal fun bind(u: User) {
            txtUsername.text = u.username
            txtName.text = u.name
            imgPhoto.setImageResource(u.photo)
        }
    }
}