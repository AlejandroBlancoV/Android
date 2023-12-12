package com.develou.diferentes_layouts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.develou.common.Article

class ArticleAdapter(private val onClick: (Article) -> Unit) :
    ListAdapter<DataItem, RecyclerView.ViewHolder>(ArticleDiffCallback()) {

    private val HEADER_TYPE = 0
    private val ITEM_TYPE = 1

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.HeaderItem -> HEADER_TYPE
            is DataItem.ArticleItem -> ITEM_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_TYPE -> HeaderViewHolder.create(parent)
            ITEM_TYPE -> ArticleViewHolder.create(parent, onClick)
            else -> throw IllegalArgumentException("Tipo de ítem desconocido")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ArticleViewHolder -> {
                val item = getItem(position) as DataItem.ArticleItem
                holder.bind(item)
            }
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun create(parent: ViewGroup): HeaderViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.header, parent, false)
                return HeaderViewHolder(view)
            }
        }
    }

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

        fun bind(article: DataItem.ArticleItem) {
            currentArticle = article.article

            title.text = article.article.title
            description.text = article.article.description
            featuredImage.setImageResource(article.article.featuredImage)
        }


        companion object {
            fun create(parent: ViewGroup, onClick: (Article) -> Unit): ArticleViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.article_item, parent, false)
                return ArticleViewHolder(view, onClick)
            }
        }
    }
}

class ArticleDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}