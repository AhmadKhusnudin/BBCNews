package com.udindev.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udindev.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val favoriteFragment = FavoriteFragment()
        val fragment = fragmentManager.findFragmentByTag(FavoriteFragment::class.java.simpleName)
        if (fragment !is FavoriteFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.frame_container, favoriteFragment, FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }
}