package com.example.softwarefun
import java.io.Serializable
import java.util.*

class Item : Serializable {

    var id: Int? = null
    var title: String? = null
    var origin: String? = null
    var destination: String? = null
    var transportBus: Boolean = true
    var transportMRT: Boolean = true
    var departTime: String? = null
    var arrTime: String? = null



    constructor(id: Int, title: String, origin: String, destination: String,
                transportBus: Boolean, transportMRT: Boolean,
                departTime: String, arrTime: String) {
        this.id = id
        this.title = title
        this.origin = origin
        this.destination = destination
        this.transportBus = transportBus
        this.transportMRT = transportMRT
        this.departTime = departTime
        this.arrTime = arrTime
    }

}
