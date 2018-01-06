package com.example.nestor.kotlin_intro.KotlinIntro

/**
 * Created by Nestor on 12/26/17.
 */
interface NetworkInteractor{
    val timeout:Int     //abstract- must be implemented
    val mimetype:String //can be overriden
        get() = "Application/json"


    fun makeRequest(){ //default implementation
        println("timeout value: $timeout")
    }

    fun parseRequest() //abstract- must be implemented
}

class NetworkInteraction(): NetworkInteractor {
    override val timeout: Int = 29
    override fun parseRequest() {

    }
}

object Interfaces{
    fun basics(){
        //Should normally inject this
        //ObjectOfType Interface = instances of class implementing the interface
        val network: NetworkInteractor = NetworkInteraction()
        println("network.mimetype = ${network.mimetype}")
        network.makeRequest()
    }
}
