package com.develou.recyclerview_en_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.develou.common.Article

class ArticleAdapter(private val onClick: (Article) -> Unit) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var articles = listOf<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount() = articles.size

    class ArticleViewHolder(view: View, val onClick: (Article) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.article_title)
        private val description: TextView = view.findViewById(R.id.article_description)
        private val featuredImage: ImageView = view.findViewById(R.id.featured_image)

        private var currentArticle: Article? = null

        init {
            view.setOnClickListener {
                currentArticle?.let {
                    onClick(it)
                }
            }
        }

        fun bind(article: Article) {
            currentArticle = article

            title.text = article.title
            description.text = article.description
            featuredImage.setImageResource(article.featuredImage)
        }
    }
}