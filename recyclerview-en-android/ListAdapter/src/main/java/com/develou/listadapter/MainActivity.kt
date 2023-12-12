package com.develou.listadapter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.develou.common.Article

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.articles_layout)

        val articleList: RecyclerView = findViewById(R.id.list)

        val articleAdapter = ArticleAdapter { article -> onItemClick(article) }
        articleList.adapter = articleAdapter

        articleAdapter.submitList(Article.data)
    }

    private fun onItemClick(article: Article) {
        Toast.makeText(this, article.title, Toast.LENGTH_SHORT).show()
    }
}