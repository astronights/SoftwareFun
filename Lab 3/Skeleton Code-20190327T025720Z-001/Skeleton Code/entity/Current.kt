package com.example.projectlab3.entity

class  Current {
    //CurrentRoute when press start route, gets user location, alerts when to alight if take bus and gg alight
    var c= Route()
    // do we need current location variable
    // no need for var dest, origin etc since route var will store all that already

    fun start(r:Route){
        c= r
        //continuously calls alert if on bus/MRT
    }

    fun alert(no: Int, Start: Int, End: Int ){
        // same issue, how to get current location, will it be passed in as a variable?
        // when location near end, alert to alight
        //if pass stop, call function recalc, by passing current location and end location
    }
    fun recalc( c: String, End: String ){
        // recalculates the route
        //systems automatically choose best route now that miss stop
    }
    fun storeRoute(){
        //this calls the database manager(save hist function) and the current route that is successfully completed will be stored under history
    }


}