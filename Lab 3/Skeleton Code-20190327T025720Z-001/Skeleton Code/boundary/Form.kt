package cz2006.boundary
import java.time.LocalDateTime

object Form{
    private var bus : Boolean = true
    private var train : Boolean = true
    private var origin : String = "Origin"
    private var destination : String = "Destination"
    private var choice : Boolean = true
    private var enterRoute : Boolean = true
    private var sortTimePrice : Boolean = true
    private var departure : LocalDateTime
    private var arrival : LocalDateTime

    fun getOrigin() : String{
        return origin
    }
    fun getDestination() : String{
        return destination
    }
    fun setDestination(destination:String){
        this.destination = destination
    }
    fun setOrigin(origin:String){
        this.origin = origin
    }
    fun getBus() : Boolean{
        return bus
    }
    fun setBus(bus:Boolean){
        this.bus = bus
    }
    fun getTrain() : Boolean{
        return train
    }
    fun setTrain(train:Boolean){
        this.train = train
    }
    fun getArrivalTime() : LocalDateTime{
        return arrival
    }
    fun setArrivalTime(arrival:LocalDateTime){
        this.arrival = arrival
    }
    fun getDepartureTime() : LocalDateTime{
        return departure
    }
    fun setDepartureTime(departure:LocalDateTime){
        this.departure = departure
    }
    fun enterRoute(){
        //This calls the route manager and passes through the required variables for Route manager to proceed with calculations
    }
}