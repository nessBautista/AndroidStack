package com.example.nestor.notebookapp.models

import com.example.nestor.notebookapp.R

/**
 * Created by Nestor on 1/10/18.
 */
enum class NavBarItem  constructor(val id:Int) {
    GOOGLE_PHOTOS(R.id.google_photos),
    TWITTER(R.id.twitter),
    FACEBOOK(R.id.facebook),
    SETTINGS(R.id.user_settings);

    fun fromViewId(viewId: Int): NavBarItem{
        for(item in NavBarItem.values()) {
            if(item.id == viewId){
                return item
            }
        }
        throw error("Can't find view type")
    }
}