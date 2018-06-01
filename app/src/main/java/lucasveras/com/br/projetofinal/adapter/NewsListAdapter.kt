package lucasveras.com.br.projetofinal.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.activities.NewsDetailActivity_
import lucasveras.com.br.projetofinal.activities.NewsListActivity_
import lucasveras.com.br.projetofinal.model.News

/*
 * Created by LucasVeras on 31/05/18.
 */

class NewsListAdapter(val context: Context,
                      val news: List<News>): Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(news: News, context: Context){
            val titleNews = itemView.news_title
            val dateNews = itemView.news_date
            val imageNews = itemView.news_image

            titleNews.text = news.titleNews
            dateNews.text = news.date
            news.image?.let { imageNews.setImageResource(it) }

            itemView.setOnClickListener {
                NewsDetailActivity_.intent(context).newsToDetail(news).start()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(news[position], context)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)

        return ViewHolder(view)
    }

}