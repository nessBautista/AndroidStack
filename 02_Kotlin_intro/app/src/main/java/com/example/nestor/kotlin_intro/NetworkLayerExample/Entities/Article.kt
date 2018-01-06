package com.example.nestor.kotlin_intro.NetworkLayerExample.Entities

/**
 * Created by Nestor on 12/26/17.
 */
data class Article(var id:Int, var userId:Int, var title:String, var body: String)
data class ArticlePost(var userId:Int, var title:String, var body: String)
