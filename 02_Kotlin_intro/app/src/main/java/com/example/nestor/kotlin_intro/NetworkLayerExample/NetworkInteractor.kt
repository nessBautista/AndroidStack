package com.example.nestor.kotlin_intro.NetworkLayerExample

import com.example.nestor.kotlin_intro.NetworkLayerExample.EndPointInterfaces.JsonPlaceHolder
import com.example.nestor.kotlin_intro.NetworkLayerExample.Entities.Article
import com.example.nestor.kotlin_intro.NetworkLayerExample.Entities.ArticlePost
import com.example.nestor.kotlin_intro.NetworkLayerExample.Helpers.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Created by Nestor on 12/26/17.
 */

typealias ArticleLambda= (Article?)->Unit
typealias VoidLambda = ()->Unit

class NetworkInteractor{
    companion object { val instance = NetworkInteractor() }

    private val placeHolderApi:JsonPlaceHolder

    init {
        placeHolderApi = ServiceGenerator.createService(JsonPlaceHolder::class.java)
    }

    fun getArticle(articleId: String, success:ArticleLambda, failure:VoidLambda){

        val call = placeHolderApi.getArticle(articleId)
        call.enqueue(object : Callback<Article> {
            override fun onFailure(call: Call<Article>?, t: Throwable?) {
                println("fail to get article: ${t?.message}")
                failure()
            }

            override fun onResponse(call: Call<Article>?, response: Response<Article>?) {
                val article = parseResponse(response)
                success(article)
            }
        })
    }

    fun postArticle(article:Article, success:ArticleLambda, failure:VoidLambda){
        var articlePost = ArticlePost(article.userId, article.title,article.body)
        val call = placeHolderApi.postArticle(articlePost)
        call.enqueue(object :Callback<Article>{
            override fun onResponse(call: Call<Article>?, response: Response<Article>?) {
                val article = parseResponse(response)
                success(article)
            }

            override fun onFailure(call: Call<Article>?, t: Throwable?) {
                println("Failed to post article: ${t?.message}")
                failure()
            }
        })
    }
    private fun parseResponse(response:Response<Article>?):Article?{
        var article = response?.body() ?:null
        if(article == null){
            parseResponseError(response)
        }
        return article
    }

    private fun parseResponseError(response: Response<Article>?){
        if(response == null){return}
        val responseBody = response.errorBody()
        if(responseBody != null){
            try{

                val text = "response body = ${responseBody.string()}"
                println("$text")
            }catch (e:IOException){
                e.printStackTrace()
            }
        } else {
            val text = "responsebody == null"
            println("$text")
        }
    }
}