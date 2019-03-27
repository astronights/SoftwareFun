package com.example.projectlab3.entity
import com.example.projectlab3.entity.Route

object History {
    //This stores history
    var h= Route()


     fun getHist(): Route{
        //returns history
        return h
    }
    fun storeHist(r: Route){
        //this function stores the history somewhr dk whr
        h= r
    }
}