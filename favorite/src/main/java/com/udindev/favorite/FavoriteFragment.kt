package com.udindev.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.udindev.bbcnews.di.FavoriteModuleDependencies
import com.udindev.bbcnews.presentation.detail.DetailNewsActivity
import com.udindev.core.ui.NewsAdapter
import com.udindev.favorite.databinding.FragmentFavoriteBinding
import com.udindev.favorite.di.DaggerFavoriteComponent
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding

    @Inject
    lateinit var factory: FavoriteViewModelFactory
    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        DaggerFavoriteComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            ).build().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListFavoriteNews()
    }

    private fun setListFavoriteNews() {

        val newsAdapter = NewsAdapter {
            val intent = Intent(requireContext(), DetailNewsActivity::class.java).apply {
                putExtra(DetailNewsActivity.EXTRA_DATA, it)
            }
            startActivity(intent)
        }

        binding?.rvFavoriteNews?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = newsAdapter
        }

        favoriteViewModel.favoriteNews.observe(viewLifecycleOwner) {listNews ->
            newsAdapter.submitList(listNews)
            binding?.viewEmpty?.root?.visibility = if (listNews.isNotEmpty()) View.GONE else View.VISIBLE
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}