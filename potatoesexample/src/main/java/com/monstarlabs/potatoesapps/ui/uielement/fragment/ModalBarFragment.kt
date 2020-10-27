package com.monstarlabs.potatoesapps.ui.uielement.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.monstarlabs.potatoesapps.R
import com.monstarlabs.potatoesapps.databinding.FragmentModalInBarBinding
import com.monstarlabs.potatoesapps.ui.slideshow.SlideshowViewModel
import com.monstarlabs.potatoesapps.ui.uielement.extendclass.ModalBar


class ModalBarFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private lateinit var binding: FragmentModalInBarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)
        binding = FragmentModalInBarBinding.inflate(layoutInflater)
        val view = binding.root

        var spinnerButton = binding.spinnerInButton
        spinnerButton.setIntLayoutSrc(R.layout.fragment_home)
        spinnerButton.setIntProjectSrc(ModalBar())
        spinnerButton.show()

        return view
    }


}


