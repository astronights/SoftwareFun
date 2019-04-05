package com.example.softwarefun
import android.content.SharedPreferences
import android.app.DownloadManager
import android.graphics.Color
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.android.gms.maps.model.*
import com.google.gson.Gson
import java.io.IOException
import java.io.UnsupportedEncodingException
import android.content.Context.MODE_PRIVATE
import android.content.Context.MODE_PRIVATE








class Direction(val url:String): AsyncTask<Void, Void, List<List<LatLng>>>() {
//
//    val PREFS_FILENAME = "com.example.softwarefun.prefs"
//    var prefs: SharedPreferences? = null

    override fun doInBackground(vararg params: Void?): List<List<LatLng>> {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val data = response.body()!!.string()
        val result = ArrayList<List<LatLng>>()
        var respObj :GoogleMapDTO ?=null

//        prefs = this.getSharedPreferences(PREFS_FILENAME, 0)

        try{
            respObj=  Gson().fromJson(data,GoogleMapDTO::class.java)
            val path = ArrayList<LatLng>()

//            val editor = prefs!!.edit()
//            val json = respObj
//            editor.putString("MyObject", json);
//            editor.apply()

            for (i in 0..(respObj!!.routes[0].legs[0].steps.size-1)){
                path.addAll(decodePolyline(respObj!!.routes[0].legs[0].steps[i].polyline.points))

            }
            result.add(path)
        }catch (e:Exception){
            e.printStackTrace()
        }
        return result
    }
    override fun onPostExecute(result: List<List<LatLng>>?) {

    }
    fun getInput(){
        var url_request = "http://maps.googleapis.com/maps/api/directions/outputFormat?parameters";
//
    }
    public fun decodePolyline(encoded: String): List<LatLng> {

        val poly = ArrayList<LatLng>()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0

        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat

            shift = 0
            result = 0
            do {
                b = encoded[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng

            val latLng = LatLng((lat.toDouble() / 1E5),(lng.toDouble() / 1E5))
            poly.add(latLng)
        }

        return poly
    }
}