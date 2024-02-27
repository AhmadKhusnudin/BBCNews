package com.udindev.bbcnews.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.udindev.bbcnews.databinding.FragmentHomeBinding
import com.udindev.bbcnews.presentation.detail.DetailNewsActivity
import com.udindev.core.data.Resource
import com.udindev.core.ui.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListNews()

        binding?.searchBar?.btnFavorite?.setOnClickListener {
            try {
                moveToFavorite()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Module not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setListNews() {

        val newsAdapter = NewsAdapter {
            val intent = Intent(requireContext(), DetailNewsActivity::class.java).apply {
                putExtra(DetailNewsActivity.EXTRA_DATA, it)
            }
            startActivity(intent)
        }

        binding?.rvNews?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = newsAdapter
        }

        homeViewModel.news.observe(viewLifecycleOwner) { listNews ->
            when(listNews) {
                is Resource.Error -> {
                    showLoading(false)
                    Toast.makeText(
                        requireActivity(),
                        "Load Data Error ${listNews.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Loading -> {
                    showLoading(true)
                }
                is Resource.Success -> {
                    showLoading(false)
                    val result = listNews.data
                    newsAdapter.submitList(result)
                }
            }
        }
    }

    private fun moveToFavorite() {
        startActivity(Intent(requireContext(), Class.forName("com.udindev.favorite.FavoriteActivity")))
    }

    private fun showLoading(isLoading: Boolean) {
        binding?.progressBar?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}