package ir.ah.newsapp.ui.fragment.news

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.*
import androidx.navigation.fragment.*
import androidx.paging.*
import androidx.recyclerview.widget.*
import dagger.hilt.android.*
import ir.ah.newsapp.*
import ir.ah.newsapp.R
import ir.ah.newsapp.base.*
import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.databinding.*
import ir.ah.newsapp.ui.adapter.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@AndroidEntryPoint
class NewsFragment :BaseFragment<NewsViewModel>(R.layout.fragment_news,NewsViewModel::class) {
    private lateinit var binding:FragmentNewsBinding

    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        initView()
    }

    private fun initView() {
        (activity as MainActivity).showBottomNav()
        subscribeToObservers()
    }


    @OptIn(ExperimentalPagingApi::class)
    private fun subscribeToObservers() {

        lifecycleScope.launch {
            viewModel.getAllMovie().collect {
                newsAdapter.submitData(it)
            }
        }
        initAdapter()

    }

    fun initAdapter() {
        binding.recyclerView.adapter = newsAdapter.withLoadStateHeaderAndFooter(
            header = NewsLoadStateAdapter { newsAdapter.retry() },
            footer = NewsLoadStateAdapter { newsAdapter.retry() }
        )
        binding.recyclerView.apply {
            layoutManager =LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }

        newsAdapter.newsSelectedListener = object : NewsAdapter.NewsSelectedListener {
            override fun onArtistSelected(article: Article) {
                val action = NewsFragmentDirections.actionNewsFragmentToDetailFragment(article)
                findNavController().navigate(action)
            }
        }
    }



}