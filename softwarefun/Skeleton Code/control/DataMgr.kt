package com.example.projectlab3.control
import com.example.projectlab3.entity.Route

object DataMgr {
    fun saveHist(r: Route){
        //This function calls history to saves route to history after current route
    }
    fun getHist(){
        //This function calls history to return history
    }
    fun getFav(){
        //This functions calls favourite to return favourite
    }

    fun delFav(r: Route){
        // This functions calls favourite to delete favourite
    }

    fun getBfare(no: Int, start: Int , End:Int ){
        //This functions calls API to determine bus fare from start(bus stop number) to dest bus stop
        // no is bus number
    }
    fun getMRTfare(start: String, end: String ){
        //This functions call API to determine MRT fare
    }
}