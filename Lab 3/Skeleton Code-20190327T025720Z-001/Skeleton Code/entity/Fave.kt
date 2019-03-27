package com.example.projectlab3.entity
import com.example.projectlab3.entity.Route


class Fave {
    //This class stores favourites
    var f= Route()


    fun getFav():Route {
        //returns favourites
        return f
    }

    fun delFav(){
        //deletes favourite
    }
    fun saveFav(r: Route){
        //saves Favourites
        f= r
    }

}