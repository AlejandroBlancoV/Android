package com.develou.recyclerview_en_android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.develou.common.Article

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.articles)

        val articleList: RecyclerView = findViewById(R.id.list) // (1)

        val articleAdapter =
            ArticleAdapter { article -> onItemClick(article) } // (2)
        articleList.adapter = articleAdapter // (3)

        // articleList.layoutManager = LinearLayoutManager(this) // (3.1)
        // articleList.setHasFixedSize(true) // (3.2)

        articleAdapter.articles = Article.data // (4)

    }

    private fun onItemClick(article: Article) {
        Toast.makeText(this, article.title, Toast.LENGTH_SHORT).show()
    }
}