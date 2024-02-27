package com.udindev.bbcnews.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.udindev.bbcnews.R
import com.udindev.bbcnews.databinding.ActivityDetailNewsBinding
import com.udindev.core.domain.model.News
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    private val detailNewsViewModel: DetailNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailNews = intent.getParcelableExtra<News>(EXTRA_DATA)
        showDetailNews(detailNews)
    }

    private fun showDetailNews(news: News?) {
        news?.let {
            supportActionBar?.title = news.title
            binding.content.tvAuthor.text = news.author
            binding.content.tvPublished.text = news.published
            binding.content.tvDescription.text = news.description
            Glide.with(this@DetailNewsActivity)
                .load(news.image)
                .into(binding.ivDetailImage)

            var statusFavorite = news.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailNewsViewModel.setFavoriteNews(news.title, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
        }
    }

    companion object {
        const val EXTRA_DATA = "news"
    }
}