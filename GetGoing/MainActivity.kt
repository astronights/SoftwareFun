package com.example.softwarefun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.support.design.widget.BottomNavigationView
import maes.tech.intentanim.CustomIntent;
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(){

    val PREFS_FILENAME = "com.example.softwarefun.prefs"
    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = this.getSharedPreferences(PREFS_FILENAME, 0)
        //Direction.doInBackground(activity_search.url)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.getMenu().getItem(1).setChecked(true);
        navigation.menu.getItem(0).setIcon(R.drawable.ic_search)
        navigation.menu.getItem(1).setIcon(R.drawable.ic_currentroute)
        navigation.menu.getItem(2).setIcon(R.drawable.ic_history)
        navigation.menu.getItem(3).setIcon(R.drawable.ic_favourite_unshaded)

        //BottomNavigationViewHelper.disableShiftMode(navigation)

        navigation?.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{  item: MenuItem ->
//            item.isChecked = true
//            navigation.itemIconTintList = null;
            when (item.itemId) {
                R.id.navigation_search -> {
//                    navigation.itemIconTintList = null;
                    val a = Intent(this@MainActivity, activity_search::class.java)
                    //setContentView(R.layout.activity_p1)
                    startActivity(a)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_currentroute -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favourite -> {
//                    navigation.itemIconTintList = null;
                    val b = Intent(this@MainActivity, activity_fav::class.java)
                    startActivity(b)

                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
//                    navigation.itemIconTintList = null;
                    val c = Intent(this@MainActivity, activity_hist::class.java)
                    startActivity(c)

                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }




    }
}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val a = Intent(this@MainActivity, NavigationBar::class.java)
//        startActivity(a)
//        //setContentView(R.layout.activity_p1)
//
//    }




//    fun onClick(v: View) {
//        val c = Calendar.getInstance()
//        val year = c.get(Calendar.YEAR)
//        val month = c.get(Calendar.MONTH)
//        val day = c.get(Calendar.DAY_OF_MONTH)
//
//
//        val dpd = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//
//            // Display Selected date in textbox
//            lblDate.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)
//        }, year, month, day)
//
//        dpd.show()
//    }



