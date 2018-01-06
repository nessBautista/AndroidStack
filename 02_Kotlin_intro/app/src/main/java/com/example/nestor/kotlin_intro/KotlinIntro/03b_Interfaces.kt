package com.example.nestor.kotlin_intro.KotlinIntro

/**
 * Created by Nestor on 12/26/17.
 */
interface DataBaseInteractor {
    fun loadFamily(){println("A")}
    fun loadFriends()
}

interface DataBaseHelper{
    fun loadFamily(){println("loadFamily")}
    fun loadFriends(){println("load all friends")}
}

class DataBaseSimpleInteraction: DataBaseInteractor {
    override fun loadFriends() {
        println("loading friends i care about")
    }

    override fun loadFamily() {
        super.loadFamily()
    }
}

class ComplexDataBaseInteraction: DataBaseInteractor, DataBaseHelper {
    override fun loadFamily() {
        super<DataBaseInteractor>.loadFamily()
        super<DataBaseHelper>.loadFamily()

    }

    override fun loadFriends() {
        super<DataBaseHelper>.loadFriends()
    }
}

//Extension method in interfaces
fun Interfaces.multipleInterfaces(){
    var database: DataBaseInteractor = ComplexDataBaseInteraction()
    database.loadFamily()
    database.loadFriends()

}