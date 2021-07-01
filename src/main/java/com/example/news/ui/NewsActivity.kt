package com.example.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.news.R
import com.example.news.db.ArticleDatabase
import com.example.news.respository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    // NewsViewModal object.
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // connect bottom nav to navigation components
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

        // instantiate news repo
        val newsRepository=NewsRepository(ArticleDatabase(this))
        //viewModel provider factory.
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)

        viewModel=ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
    }
}
