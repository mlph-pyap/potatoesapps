package com.monstarlabs.potatoesapps.ui.uielement.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.monstarlabs.potatoesapps.databinding.FragmentSpinnerInButtonBinding
import com.monstarlabs.potatoesapps.ui.slideshow.SlideshowViewModel
import com.monstarlabsph.potatoesandroid.ui.elements.SpinnerInButton
import com.monstarlabsph.potatoesandroid.ui.elements.SpinnerInButton.SpinnerInButtonListener

class SpinnerInButtonFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private lateinit var binding: FragmentSpinnerInButtonBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)
        binding = FragmentSpinnerInButtonBinding.inflate(layoutInflater)
        val view = binding.root

        val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
        var spinnerButton = binding.spinnerInButton
        var cars_l1 = spinnerButton.addNumberFormat(cars);
        spinnerButton.addNumberFormat(arrayOf("s1", "s2"))
        cars_l1.wrapSelectorWheel = true;

        spinnerButton.isBtnTextWillUpdatedWhenOnClick = true;
        spinnerButton.textSplit = ":"
        spinnerButton.onTopButtonClickEvent(object : SpinnerInButtonListener {
            override fun onClickBtnCancel(view: View?) {

            }

            override fun onClickBtnDone(view: View?) {
                Toast.makeText(
                    view?.context,
                    "test done:" + spinnerButton.numberFormatValue.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

        })

        return view
    }
}


