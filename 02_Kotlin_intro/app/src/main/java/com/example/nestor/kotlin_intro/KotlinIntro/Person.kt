package com.example.nestor.kotlin_intro.KotlinIntro

/**
 * Created by Nestor on 12/23/17.
 */
//Primary constructor
class Person(val firstName: String, val lastName: String){

    lateinit var nickName:String
    init {
        println("Creating a Person $firstName $lastName")
    }

}

class Pet internal constructor(animal:String, name:String){
    init{
        println("Record of a new pet. $name is a $animal")
    }

    constructor(animal:String, name:String, age:Int):
            this(animal, name){

    }
}

class Square(position: Position, width:Float, height: Float){
    init{
        println("Created a Square figure")
    }
}

object Position{
    var xPos =0.0
    var yPost=0.0
}