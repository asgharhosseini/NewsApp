package ir.ah.newsapp.ui.adapter

import android.util.*
import android.view.*
import androidx.core.view.*
import androidx.paging.*
import androidx.recyclerview.widget.*
import ir.ah.newsapp.databinding.*
import ir.ah.newsapp.other.Constants.TAG
import java.io.*

class NewsLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<NewsLoadStateAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) = holder.bind(loadState)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) = ViewHolder(
        FooterBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        retry
    )

    class ViewHolder(
        private val binding: FooterBinding,
        retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryButton.setOnClickListener { retry() }
        }

        fun bind(loadState: LoadState) = with(binding) {
            if (loadState is LoadState.Error) {
                when (loadState.error) {
                    is IOException -> errorMsg.text = "Network connection error"
                    else -> {
                        errorMsg.text = "Unknown error"
                        Log.e(TAG, loadState.error.localizedMessage)
                    }
                }

            }
            progressBar.isVisible = loadState is LoadState.Loading
            retryButton.isVisible = loadState is LoadState.Error
            errorMsg.isVisible = loadState is LoadState.Error
        }
    }
}