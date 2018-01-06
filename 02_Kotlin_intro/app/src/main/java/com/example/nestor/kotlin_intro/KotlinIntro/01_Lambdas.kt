package com.example.nestor.kotlin_intro.KotlinIntro

/**
 * Created by Nestor on 12/23/17.
 */
object Lambdas{

    fun asyncNetworkCall(finished:(Boolean)->Unit){
        Threading.async(task = {
            println("asyncNetworkCall starting...")
            Thread.sleep(2000)
            println("asyncNetworkCall finish...")
            finished(true)
        })
    }

    fun localDBCall(authenticationBlock:(String)-> Boolean){
        val userName = "Nestor"
        val isAuthorized = authenticationBlock(userName)
        useLocalResult(userName, isAuthorized)
    }

    private fun useLocalResult(userName:String, isAuthorized:Boolean){

        println("$userName is authorized: $isAuthorized")
    }
}