package com.monstarlabs.potatoesapps.ui.uielement.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.monstarlabs.potatoesapps.R
import com.monstarlabs.potatoesapps.ui.uielement.viewmodel.UIElementViewModel

import com.monstarlabs.potatoesapps.databinding.UilementHomeFragmentBinding
import com.monstarlabs.potatoesapps.ui.uielement.adapter.ContentData
import com.monstarlabs.potatoesapps.ui.uielement.adapter.ListAdapter

class HomeFragment : Fragment() {

    private lateinit var uielementViewModel: UIElementViewModel
    private lateinit var binding: UilementHomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UilementHomeFragmentBinding.inflate(inflater)
        val view = binding.root
        val viewAdapter = ListAdapter(listProject)

        binding.leaderboardList.run {

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        uielementViewModel = ViewModelProvider(this).get(UIElementViewModel::class.java)


    }
}
var listProject = arrayListOf<ContentData>(
    ContentData("Spinner in number button", R.id.nav_ui_element_spinner_button),
    ContentData("Modal bar layout", R.id.nav_ui_element_modal_bar)

)


