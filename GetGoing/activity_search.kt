package com.example.softwarefun
import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.app.TimePickerDialog

import android.widget.Switch
import android.widget.CheckBox
import android.support.v4.content.ContextCompat.startActivity
import java.util.TimeZone
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.text.format.Time
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import maes.tech.intentanim.CustomIntent
import java.text.SimpleDateFormat
import java.time.LocalDateTime

import java.time.format.DateTimeFormatter
import java.util.*

class activity_search : AppCompatActivity() {
    @TargetApi(26)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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
                    val a = Intent(this@activity_search, MainActivity::class.java)
                    startActivity(a)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favourite -> {
                    //  navigation.itemIconTintList = null;
                    val b = Intent(this@activity_search, activity_fav::class.java)
                    startActivity(b)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    //navigation.itemIconTintList = null;
                    val c = Intent(this@activity_search, activity_hist::class.java)
                    startActivity(c)
                    CustomIntent.customType(this, "fadein-to-fadeout");
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        //Final code for switch toggle
        findViewById<Switch>(R.id.switch1).setOnClickListener{
            if(findViewById<Switch>(R.id.switch1).isChecked) {
                findViewById<TextView>(R.id.switch1_title).setText("Arrive By")
            }
            else{
                findViewById<TextView>(R.id.switch1_title).setText("Depart At")
            }
        }
//date
        val textView: TextView  = findViewById(R.id.editText)
        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }
        textView.setOnClickListener {
            DatePickerDialog(this@activity_search, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
//time

        val timeView: TextView  = findViewById(R.id.timeDeparture)

        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        timeView.text = currentTime.format(formatter)

        val timeSetListener = TimePickerDialog.OnTimeSetListener() { timePicker, hourOfDay, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE, minute)

            textView.text = SimpleDateFormat("HH:mm").format(cal.time)

        }
        timeView.setOnClickListener {
            TimePickerDialog(this,timeSetListener,cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
    }
    // url request
    @Suppress("UNUSED_PARAMETER")
    @TargetApi(24)
    fun query(view: View){
        if(findViewById<EditText>(R.id.origin).text.toString() == "" ) {
            findViewById<EditText>(R.id.origin).setBackgroundColor(getResources().getColor(R.color.red))
            findViewById<EditText>(R.id.origin).hint = "Please enter an origin"
        }
        else if(findViewById<EditText>(R.id.destination).text.toString() == "" ){
            findViewById<EditText>(R.id.destination).setBackgroundColor(getResources().getColor(R.color.red))
            findViewById<EditText>(R.id.destination).hint = "Please enter an origin"
        }
        else{
            var url = "http://maps.googleapis.com/maps/api/directions/json?mode=transit&"
            url += if(findViewById<CheckBox>(R.id.checkBox).isChecked && findViewById<CheckBox>(R.id.checkBox2).isChecked){
                ""
            }
            else if(findViewById<CheckBox>(R.id.checkBox).isChecked){
                "transit_mode=BUS&"
            }
            else if(findViewById<CheckBox>(R.id.checkBox2).isChecked){
                "transit_mode=SUBWAY&"
            }
            else{
                ""
            }
            println(url)
            url += "origin=" + findViewById<EditText>(R.id.origin).text.toString().split(" ").joinToString("+") + "&"
            url += "destination=" + findViewById<EditText>(R.id.destination).text.toString().split(" ").joinToString("+") + "&"
            println(url)
            val datestr = findViewById<TextView>(R.id.editText).text.toString() + " " + findViewById<TextView>(R.id.timeDeparture).text.toString()
            val sdf = SimpleDateFormat("dd.MM.yyyy hh:mm")
            val mDate = sdf.parse(datestr)
            val timeInMilliseconds = mDate.getTime()
            url += if(findViewById<Switch>(R.id.switch1).isChecked){
                "arrival_time=" + timeInMilliseconds.toString() + "&"
            }
            else{
                "departure_time=" + timeInMilliseconds.toString() + "&"
            }
            url += "key="

//            val intent_start: Intent = Intent(this@activity_search, MainActivity::class.java)
//
//            startActivity(intent_start)
//            CustomIntent.customType(this, "left-to-right"
        }

    }



}
//fun page2(view: View){
//    setContentView(R.layout.activity_p2);
//}
//
//fun page3(view: View){
//    setContentView(R.layout.activity_p3);
//}