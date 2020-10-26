package com.monstarlabs.potatoesapps

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class LaunchActivity : AppCompatActivity() {

    private var mDrawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    private val nvDrawer: NavigationView? = null

    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    private val drawerToggle: ActionBarDrawerToggle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_main)

        //   val linear_lay1 =findViewById<SpinnerInButton>(R.id.linear_lay1)
        //   val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")

        // addNumberFormat(cars)

        //    linear_lay1.addNumberFormat(arrayOf("s1", "s2"))
        ///   var cars_l1= linear_lay1.addNumberFormat(cars);
        //    cars_l1.wrapSelectorWheel=true;


        //   linear_lay1.setOnClickListener {
        //       Toast.makeText(it.context,"see long",Toast.LENGTH_LONG).show();
        //    }
        //  var tessy = Tessy()
        //  tessy_ss.text = tessy.myonly();

        //    toolbar =findViewById(R.id.toolbar);
        //    setSupportActionBar(toolbar);

        // This will display an Up icon (<-), we will replace it with hamburger later
        //  getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        //    mDrawer =  findViewById(R.id.drawer_layout);

    }
}