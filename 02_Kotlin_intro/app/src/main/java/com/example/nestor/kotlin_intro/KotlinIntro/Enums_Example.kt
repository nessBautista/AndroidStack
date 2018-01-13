package com.example.nestor.kotlin_intro.KotlinIntro

import android.graphics.Color

/**
 * Created by Nestor on 1/13/18.
 */

object EnumExample{
    enum class CompassDirection{
        EAST,
        WEST,
        SOUTH,
        NORTH
    }

    enum class ActionState {
        ACTIVE{
            override fun reverseAction() = INACTIVE
        },
        INACTIVE{
            override fun reverseAction() = ACTIVE
        };
        abstract fun reverseAction():ActionState
    }


    enum class NavBarItem(val id:Int) {
        GOOGLE_PHOTOS(100),
        TWITTER(200),
        FACEBOOK(300),
        SETTINGS(400);

        fun fromViewId(viewId: Int): NavBarItem{
            for(item in NavBarItem.values()) {
                if(item.id == viewId){
                    return item
                }
            }
            throw error("Can't find view type")
        }
    }
    enum class Color(val red: Int, val green:Int, val blue: Int){
        RED(255,0,0),
        GREEN(0,255,0),
        BLUE(0,0,255)
    }

    public fun runExample(){
        println("North enum = ${CompassDirection.NORTH}")
        println(Color.BLUE.toString())
        println("Color details.name = ${Color.GREEN.name}, ordinal: ${Color.GREEN.ordinal}")
        println("Color.valueOf(BLUE): ${Color.valueOf("BLUE")}")
        for(colorValue in Color.values()){
            println("color value is : $colorValue")
        }
        println(ActionState.ACTIVE.reverseAction())
        println(ActionState.INACTIVE.reverseAction())
    }
}