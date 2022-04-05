package com.pvsb.sevendaysofcode.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.pvsb.core.model.IMDBDetails
import com.pvsb.sevendaysofcode.databinding.MainListItemBinding

class MainAdapter : PagingDataAdapter<IMDBDetails, MainAdapter.MainViewHolder>(BaseDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            MainListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class MainViewHolder(private val binding: MainListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: IMDBDetails) {

            val rating = "${item.imDbRating} - Ano:${item.year}"

            binding.tvTitle.text = item.title
            binding.tvRating.text = rating

            Glide.with(itemView.context)
                .load(item.image)
                .transition(DrawableTransitionOptions.withCrossFade(700))
                .into(binding.ivMain)
        }
    }
}

class BaseDiffUtil<T : Any> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.toString() == newItem.toString()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}