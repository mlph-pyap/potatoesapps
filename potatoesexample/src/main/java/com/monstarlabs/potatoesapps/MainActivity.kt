package com.monstarlabs.potatoesapps

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.monstarlabsph.potatoesandroid.ui.elements.SpinnerInButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modals_main)

        val linear_lay1 =findViewById<SpinnerInButton>(R.id.linear_lay1)
        val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")

       // addNumberFormat(cars)

        linear_lay1.addNumberFormat(arrayOf("s1", "s2"))
       var cars_l1= linear_lay1.addNumberFormat(cars);
        cars_l1.wrapSelectorWheel=true;


     //   linear_lay1.setOnClickListener {
     //       Toast.makeText(it.context,"see long",Toast.LENGTH_LONG).show();
    //    }
      //  var tessy = Tessy()
      //  tessy_ss.text = tessy.myonly();
    }
}