package com.dicoding.provinsibengkulu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class ListKabupatenAdapter(private val listKabupaten: ArrayList<Kabupaten>) : RecyclerView.Adapter<ListKabupatenAdapter.ListViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
            val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_kabupaten, viewGroup, false)
            return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val kabupaten = listKabupaten[position]

            Glide.with(holder.itemView.context)
                .load(kabupaten.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)

            holder.tvName.text = kabupaten.name
            holder.tvDetail.text = kabupaten.detail

            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKabupaten[holder.adapterPosition]) }
        }


        override fun getItemCount(): Int {
            return listKabupaten.size
        }


        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
            var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
            var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)

        }

        interface OnItemClickCallback {
            fun onItemClicked(data: Kabupaten)
        }
    }