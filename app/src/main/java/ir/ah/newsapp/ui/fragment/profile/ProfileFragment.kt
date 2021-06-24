package ir.ah.newsapp.ui.fragment.profile

import android.content.*
import android.net.*
import android.os.*
import android.view.*
import androidx.fragment.app.*
import com.bumptech.glide.*
import dagger.hilt.android.*
import ir.ah.newsapp.R
import ir.ah.newsapp.databinding.*
import ir.ah.newsapp.ui.dialog.*

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        initView()
    }

    private fun initView() {

        Glide.with(requireContext())
            .load(R.drawable.image)
            .circleCrop()
            .placeholder(R.drawable.ic_error_logo)
            .error(R.drawable.ic_error_logo)
            .into(binding.ivFragmentProfileImage)
        OnClick()


    }

    private fun OnClick() {

        binding.llFragmentProfileGithub.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data= Uri.parse("https://github.com/asgharhosseini")
            })
        }
        binding.llFragmentProfileLinkedin.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data= Uri.parse("https://www.linkedin.com/in/asghar-hosseini-a76289136/")
            })
        }
        binding.btnAboutMe.setOnClickListener {
            val dialog = AboutDialog()
            dialog.show(parentFragmentManager, null)
        }

    }
}