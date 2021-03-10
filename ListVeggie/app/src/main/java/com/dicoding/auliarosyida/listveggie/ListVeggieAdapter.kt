package com.dicoding.auliarosyida.listveggie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListVeggieAdapter(private val listVeggie: ArrayList<Veggie>) : RecyclerView.Adapter<ListVeggieAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListVeggieAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_veggie, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListVeggieAdapter.ListViewHolder, position: Int) {
        val veggie = listVeggie[position]
        Glide.with(holder.itemView.context)
            .load(veggie.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = veggie.name
        holder.tvDetail.text = veggie.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listVeggie[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listVeggie.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Veggie)
    }
}