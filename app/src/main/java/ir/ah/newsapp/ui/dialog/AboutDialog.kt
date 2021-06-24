package ir.ah.newsapp.ui.dialog

import android.os.*
import android.view.*
import com.google.android.material.bottomsheet.*
import ir.ah.newsapp.*
import ir.ah.newsapp.databinding.*

class AboutDialog() : BottomSheetDialogFragment() {
    private lateinit var binding: DialogAboutBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return    LayoutInflater.from(requireContext()).inflate(R.layout.dialog_about, null, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=DialogAboutBinding.bind(view)

        binding.btnDialogAboutClose.setOnClickListener {
            dismiss()
        }


    }

}
