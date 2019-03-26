package com.example.projectlab3.control

import com.example.projectlab3.entity.Route
import java.time.LocalDateTime

object RouteMgr {
    // var for storing all the routes.. ArrayList? or is there a better way?

    fun calcRoute(origin: String, destination:String, time: LocalDateTime){
        //this function calls API manager to calculate the route
    }
    fun startRoute(r: Route){
        //this function calls 'Current' to start the route
    }
    fun sort(b: Boolean){
        // need to pass in the list of routes too (Array list?? or wtv way we passing the routes by
        // this function calls 'sort' to sort the routes by either time or price
        //boolean since there will only be 2 choices, either by time or price. since  default sorting by time. 1= sort time 0=sort by price
    }
}