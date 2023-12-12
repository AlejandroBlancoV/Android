package com.develou.staggeredlayoutmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.develou.common.Article
import com.develou.common.GutterDecoration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.articles_layout)

        val articleList: RecyclerView = findViewById(R.id.staggered_grid)

        val articleAdapter = ArticleAdapter { article -> onItemClick(article) }

        val staggeredManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val gutter = resources.getDimensionPixelSize(R.dimen.grid_gutter)
        articleList.apply {
            adapter = articleAdapter
            layoutManager = staggeredManager
            addItemDecoration(GutterDecoration(gutter))
        }

        articleAdapter.submitList(Article.data)
    }

    private fun onItemClick(article: Article) {
        Toast.makeText(this, article.title, Toast.LENGTH_SHORT).show()
    }
}