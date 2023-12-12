package com.develou.diferentes_layouts

import com.develou.common.Article

sealed class DataItem {
    abstract val id: Int

    object HeaderItem : DataItem() {
        override val id = Int.MIN_VALUE
    }

    data class ArticleItem(val article: Article) : DataItem() {
        override val id = article.id
    }
}
