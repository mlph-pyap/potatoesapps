package com.monstarlabs.potatoesapps.ui.uielement.extendclass

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.monstarlabs.potatoesapps.R
import com.monstarlabsph.potatoesandroid.ui.elements.ModalsBarLayout

class ModalBar: ModalsBarLayout.ModalsBarLayoutListener {
    override fun onViewModalsBar(context: Context?, view: View?) {
        val tesst = view?.findViewById<TextView>(R.id.text_home)
        tesst?.text = "Gundam 2"
        tesst?.setOnClickListener {
            Toast.makeText(it.context,"Yahoo 2", Toast.LENGTH_LONG).show()
        }
    }
}