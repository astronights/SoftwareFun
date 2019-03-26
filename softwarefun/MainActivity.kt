package com.example.softwarefun

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.DatePickerDialog

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p1)
    }

    fun page2(view: View){
        setContentView(R.layout.activity_p2);
    }

    fun page3(view: View){
        setContentView(R.layout.activity_p3);
    }

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
}
