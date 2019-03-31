package com.example.softwarefun


import android.support.v4.content.ContextCompat.startActivity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import maes.tech.intentanim.CustomIntent

class activity_p1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p1)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.getMenu().getItem(0).setChecked(true);
        navigation?.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ item: MenuItem ->
            //            item.isChecked = true
//            navigation.itemIconTintList = null;
            when (item.itemId) {
                R.id.navigation_search -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_currentroute -> {
                    //navigation.itemIconTintList = null;
                    val a = Intent(this@activity_p1, MainActivity::class.java)
                    startActivity(a)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favourite -> {
                    //  navigation.itemIconTintList = null;
                    val b = Intent(this@activity_p1, activity_fav::class.java)
                    startActivity(b)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    //navigation.itemIconTintList = null;
                    val c = Intent(this@activity_p1, activity_hist::class.java)
                    startActivity(c)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        val nextArrow: ImageView = findViewById<ImageView>(R.id.imageView4)
        nextArrow.setOnClickListener OnClickListener@{ v: View ->
            onClick(v)
        }

    }


    private fun onClick(v: View) {
        val intent0: Intent = Intent(this@activity_p1, activity_p2::class.java)

        startActivity(intent0)
        CustomIntent.customType(this, "left-to-right")
    }
}
//fun page2(view: View){
//    setContentView(R.layout.activity_p2);
//}
//
//fun page3(view: View){
//    setContentView(R.layout.activity_p3);
//}