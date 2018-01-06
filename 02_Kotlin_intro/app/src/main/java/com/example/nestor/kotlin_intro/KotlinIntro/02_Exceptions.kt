package com.example.nestor.kotlin_intro.KotlinIntro

/**
 * Created by Nestor on 12/26/17.
 */
class CustomException(override var message:String):Exception()
object Exceptions{
    fun example1() {
        try{
            faultCode("Some bad argument")
        } catch (e: CustomException){
            println("CustomException caught:${e.message}")
        } catch (e:Exception){
            //Catch all other exceptions
            println("Caught all other exceptions")
        } finally {
            //wrap things up - close db or file connections,sockets, etc
        }

    }

    fun example2(someArg:String):Int?{
        val result:Int? = try{someArg.toInt()}catch (e:NumberFormatException){null}
        return result
    }

    fun example3(){ //This will crash-throw not required
        faultCode("error out")
    }
    private fun faultCode(message:String):Nothing {

        throw IllegalArgumentException(message)
    }
}