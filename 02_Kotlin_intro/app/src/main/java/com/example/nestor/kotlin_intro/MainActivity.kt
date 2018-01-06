package com.example.nestor.kotlin_intro


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.nestor.kotlin_intro.KotlinIntro.*
import com.example.nestor.kotlin_intro.NetworkLayerExample.NetworkExample


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //runLambdaExample()
        //runExceptionExamples()
        //runInterfaceExample()
        runNetworkExample()
    }

    //region Interface example
    fun runInterfaceExample(){

        Interfaces.basics()
        Interfaces.multipleInterfaces()
    }
    //endregion

    //region Lambda examples
    fun runLambdaExample(){
        println("~~NetworkCall~~")

        Lambdas.asyncNetworkCall { successful ->
            val message = if(successful) "success" else "failure"
            println(message)
        }
        println("~~LocalDBCall~~")
        Lambdas.localDBCall { authenticate(it) }
        println("~~RunLambdaExample finished~~")
    }
    private fun authenticate(result:String):Boolean = result == "Nestor"
    //endregion

    //region Network Example
    fun runNetworkExample(){
        NetworkExample.run()
    }
    //endregion
    //region Exception examples
    fun runExceptionExamples(){
        Exceptions.example1()
        var result = Exceptions.example2("bad value")
        println("result:$result")

    }
    //endregion

    //region Optionals unwrapping
    //Optionals
    fun greet(name: String, day: String): String {
        var result:String ? = null
        result = "Hello $name, today is  ${day}."


        println(result)
        println("lenght:${result?.length}")
        //Forcing unwrapping
        println("lenght:${result!!.length}")

        return result
    }

    //Substitute for guard
    fun doSomething(someArg:String?){
        val arg = someArg?.let { it }?: return

        //Do something
        print(someArg)

        var person = Person("nestor", "hernandez")
        val arg2 = person.nickName?.let { it }?: return
    }

    //If let arg ={
    //  do something with arg
    // }
    fun doSomething2(someArg:String?) {

        someArg?.let {
            //do something
            println(it)
        }
    }
    //endregion Optionals unwrapping

    //region Collections and sortings
    //Collections: Arrays
    fun showArrays(){
        val names = arrayOf("Anna","Alex","Brian", "Jack")
        for ((i, name) in names.withIndex() ){
            println("Person ${i+1} is named $name")
        }
    }

    //Collections: Lists
    fun showLists(){
        val list = listOf("Anna","Alex","Brian", "Jack")
        for ((i, name) in list.withIndex()){
            println("Person  ${i+1} is named: $name")
        }
    }

    //  Sorts a list: length greater than 5, sort by name, to lower case
    fun sortListWithConditions(list:MutableList<String>){
        list.filter { it.length > 5}
                .sortedBy { it }
                .map { it.toLowerCase() }
        for (name in list){
            println(name)
        }
    }
    //endregion

    //region Basic Function Call
    fun runBasicFunction(){
        var result = showVariables(name = "Hector", age = 33)
        var result2 = showVariables("Hector", 33)

    }


    fun showVariables(name: String, age: Int): String{

        var variable = 42
        variable = 10

        val  myConstant = 42
        val explicitDouble: Double = 2.0
        return "Hello World!"
    }
    //endregion
}
