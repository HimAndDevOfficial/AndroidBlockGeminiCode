package com.example.androidpracticecode.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidpracticecode.databinding.ItemFetchNameRowBinding
import com.example.androidpracticecode.model.Data


internal class FetchRecordListAdapter(items: List<Data>) : RecyclerView.Adapter<FetchRecordListAdapter.ItemViewHolder>() {


    private var adapterList = items
    inner class ItemViewHolder(
        private val binding :ItemFetchNameRowBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindData(holder: ItemViewHolder,item: Data){
            binding.firstName.text=item.first_name
            binding.lastName.text=item.last_name
            Glide.with(holder.itemView).load(item.avatar).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFetchNameRowBinding.inflate(inflater,parent,false)


        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(holder,adapterList[position])
    }

    override fun getItemCount() = adapterList.size




}