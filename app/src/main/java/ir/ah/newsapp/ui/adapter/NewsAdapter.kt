package ir.ah.newsapp.ui.adapter
import android.view.*
import android.widget.*
import androidx.paging.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.databinding.*

import javax.inject.*


class NewsAdapter @Inject constructor(  private val glide: RequestManager) :
    PagingDataAdapter<Article, NewsAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(
        private val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) = with(binding) {

            binding.txtItemNewsTitle.text=article.title
            binding.txtItemNewsPublishedAt.text=article.publishedAt
            glide.load(article.urlToImage).into(binding.imageView)
            binding.root.setOnClickListener {
                newsSelectedListener.onArtistSelected(article)
            }
        }


    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem
        }
    }


    lateinit var newsSelectedListener: NewsSelectedListener

    interface NewsSelectedListener {
        fun onArtistSelected(article: Article)
    }





}