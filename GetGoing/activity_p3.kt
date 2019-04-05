//package com.example.softwarefun
//
//import java.util.Locale
//
//import java.text.SimpleDateFormat
//import android.content.Intent
//import android.os.Bundle
//import android.support.design.widget.BottomNavigationView
//import android.support.v7.app.AppCompatActivity
//import android.view.MenuItem
//import android.view.View
//import android.widget.ImageView
//import android.widget.TextView
//import maes.tech.intentanim.CustomIntent
//import android.widget.DatePicker
//import android.app.DatePickerDialog
//import android.text.InputType
//
//import android.widget.EditText
//import java.util.Calendar;
//
//
//class activity_p3 : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_p3)
//
//        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
//        navigation.getMenu().getItem(0).setChecked(true);
//        navigation?.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ item: MenuItem ->
//            //            item.isChecked = true
////            navigation.itemIconTintList = null;
//            when (item.itemId) {
//                R.id.navigation_search -> {
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_currentroute -> {
//                    //navigation.itemIconTintList = null;
//                    val a = Intent(this@activity_p3, MainActivity::class.java)
//                    startActivity(a)
//                    CustomIntent.customType(this, "fadein-to-fadeout");
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_favourite -> {
//                    //  navigation.itemIconTintList = null;
//                    val b = Intent(this@activity_p3, activity_fav::class.java)
//                    startActivity(b)
//                    CustomIntent.customType(this, "fadein-to-fadeout");
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.navigation_history -> {
//                    //navigation.itemIconTintList = null;
//                    val c = Intent(this@activity_p3, activity_hist::class.java)
//                    startActivity(c)
//                    CustomIntent.customType(this, "fadein-to-fadeout");
//                    return@OnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }
//        val textView: TextView  = findViewById(R.id.editText)
//        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
//
//        var cal = Calendar.getInstance()
//
//        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//            cal.set(Calendar.YEAR, year)
//            cal.set(Calendar.MONTH, monthOfYear)
//            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
//            val myFormat = "dd.MM.yyyy" // mention the format you need
//            val sdf = SimpleDateFormat(myFormat, Locale.US)
//            textView.text = sdf.format(cal.time)
//
//        }
//        textView.setOnClickListener {
//            DatePickerDialog(this@activity_p3, dateSetListener,
//                cal.get(Calendar.YEAR),
//                cal.get(Calendar.MONTH),
//                cal.get(Calendar.DAY_OF_MONTH)).show()
//        }
//
//    }
//}