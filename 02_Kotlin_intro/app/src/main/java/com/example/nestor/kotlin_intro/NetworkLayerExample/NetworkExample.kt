package com.example.nestor.kotlin_intro.NetworkLayerExample

import com.example.nestor.kotlin_intro.NetworkLayerExample.Entities.Article
import com.example.nestor.kotlin_intro.NetworkLayerExample.NetworkInteractor
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Nestor on 12/26/17.
 */
object NetworkExample{
    private var articleId = "2"
    private var currentArticle = BehaviorSubject.create<Article>()

    fun run(){
        currentArticle.subscribe(){ article ->
            article?.let{changeArticle(it)}
        }
        loadArticle(articleId)
    }
    private fun changeArticle(article: Article?) {
        if(article == null){return}
        article.title = "this has changed"
        NetworkInteractor.instance.postArticle(article, this::handleChangedArticle, this::handleFailure)
    }
    private fun loadArticle(articleId: String) {
        NetworkInteractor.instance.getArticle(articleId,this::handleNewArticle, this::handleFailure)
    }
    private  fun handleChangedArticle(newArticle:Article?){
        if(newArticle == null)return
        println("~~~Changed~~~")
        println(newArticle)
    }

    private fun handleNewArticle(newArticle:Article?){
        if(newArticle == null){return}

        println(newArticle)

        currentArticle.onNext(newArticle)
    }


    private fun handleFailure(){
        println("Failed to load the currentArticle")
    }
}