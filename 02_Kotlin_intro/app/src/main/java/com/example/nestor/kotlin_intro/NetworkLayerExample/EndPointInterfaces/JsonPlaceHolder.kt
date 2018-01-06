package com.example.nestor.kotlin_intro.NetworkLayerExample.EndPointInterfaces

import com.example.nestor.kotlin_intro.NetworkLayerExample.Entities.Article
import com.example.nestor.kotlin_intro.NetworkLayerExample.Entities.ArticlePost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
/**
 * Created by Nestor on 12/26/17.
 */
interface JsonPlaceHolder{
    @GET("/posts/{articleId}")
    fun getArticle(@Path("articleId")articleId:String):Call<Article>

    @POST("/posts")
    fun postArticle(@Body article:ArticlePost):Call<Article>
}