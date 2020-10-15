package com.arifin.mvpmnewapp.repository

import android.widget.SearchView
import com.arifin.mvpmnewapp.database.ArticleDataBase
import com.arifin.mvpmnewapp.model.Article
import com.arifin.mvpmnewapp.network.RetrofitInstance

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticle()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}