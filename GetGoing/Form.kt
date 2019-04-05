//package com.example.softwarefun
//import android.widget.EditText
//import java.time.LocalDateTime
//import android.widget.TextView
//
//object Form{
//    private val bus : Boolean = true
//    private val train : Boolean = true
//    private var origin : String = "Origin"
//    private val destination : String = "Destination"
//    private val choice : Boolean = true
//    private val enterRoute : Boolean = true
//    private val sortTimePrice : Boolean = true
//    private val departure : LocalDateTime
//    private val arrival : LocalDateTime
//
//    fun getOrigin() : String{
//        val origin2 : EditText
//        origin2 = (EditText)findViewById(R.id.origin);
//        origin2.getText().toString();
//        return origin
//    }
//    fun getDestination() : String{
//        return destination
//    }
//    fun setDestination(destination:String){
//        this.destination = destination
//    }
//    fun setOrigin(origin:String){
//        this.origin = origin
//    }
//    fun getBus() : Boolean{
//        return bus
//    }
//    fun setBus(bus:Boolean){
//        this.bus = bus
//    }
//    fun getTrain() : Boolean{
//        return train
//    }
//    fun setTrain(train:Boolean){
//        this.train = train
//    }
//    fun getArrivalTime() : LocalDateTime{
//        return arrival
//    }
//    fun setArrivalTime(arrival:LocalDateTime){
//        this.arrival = arrival
//    }
//    fun getDepartureTime() : LocalDateTime{
//        return departure
//    }
//    fun setDepartureTime(departure:LocalDateTime){
//        this.departure = departure
//    }
//    fun enterRoute(){
//        //This calls the route manager and passes through the required variables for Route manager to proceed with calculations
//    }
//}