package com.udindev.bbcnews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udindev.bbcnews.R
import com.udindev.bbcnews.databinding.ActivityMainBinding
import com.udindev.bbcnews.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
        if (fragment !is HomeFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.container, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}