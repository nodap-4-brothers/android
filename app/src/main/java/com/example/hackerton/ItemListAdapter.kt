package com.example.hackerton

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackerton.databinding.ItemListBinding

class ItemListAdapter(val context: Context) : RecyclerView.Adapter<ItemListAdapter.MyViewHolder>() {

    var dataList = mutableListOf<Item>()

    inner class MyViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item) {
            binding.tvTitle.text = item.title
            binding.tvProfile.text = item.name
        }
    }


    override fun onBindViewHolder(holder: ItemListAdapter.MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}