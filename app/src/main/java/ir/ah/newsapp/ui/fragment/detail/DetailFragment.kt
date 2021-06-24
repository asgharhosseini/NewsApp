package ir.ah.newsapp.ui.fragment.detail

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.navigation.fragment.*
import com.bumptech.glide.*
import dagger.hilt.android.*
import ir.ah.newsapp.*
import ir.ah.newsapp.R
import ir.ah.newsapp.data.model.news.*
import ir.ah.newsapp.databinding.*
import javax.inject.*

@AndroidEntryPoint
class DetailFragment :Fragment(R.layout.fragment_detail) {
    @Inject
    lateinit var glide: RequestManager

    private val arg by navArgs<DetailFragmentArgs>()
    private lateinit var binding: FragmentDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        initView()
    }
    private fun initView() {
        binding.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
       val article:Article= arg.article
       binding.txtFragmentDetailTitle.text= article.title
       binding.txtFragmentDetailAuthor.text= article.author
       binding.txtFragmentDetailContent.text= article.content
       binding.txtFragmentDetailPublishedAt.text= article.publishedAt
        glide.load(article.urlToImage).into(binding.ivFragmentDetailImage)

    }

}