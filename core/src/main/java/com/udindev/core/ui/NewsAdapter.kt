package com.udindev.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udindev.core.databinding.ItemNewsBinding
import com.udindev.core.domain.model.News

class NewsAdapter(
    private val onItemClicked:(News) -> Unit
): ListAdapter<News, NewsAdapter.NewsViewHolder>(DIFF_CALLBACK) {
    inner class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.tvTitle.text = news.title
            binding.tvSubtitle.text = news.description

            Glide.with(itemView.context)
                .load(news.image)
                .into(binding.ivImage)

            itemView.setOnClickListener {
                onItemClicked(news)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<News>() {
            override fun areContentsTheSame(
                oldItem: News,
                newItem: News
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(
                oldItem: News,
                newItem: News
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}