package lucasveras.com.br.projetofinal.activities

import kotlinx.android.synthetic.main.activity_news_detail.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.model.News
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.Extra

/*
 * Created by LucasVeras on 31/05/18.
 */

@EActivity(R.layout.activity_news_detail)
open class NewsDetailActivity: BaseActivity()  {

    @Extra
    @JvmField
    protected var newsToDetail: News? = null

    @AfterViews
    protected open fun afterViews(){
        newsToDetail?.image?.let { newsImageViewDetail.setImageResource(it) }
        newsToDetail?.titleNews.let { newsTitleDetail.text = it }
        newsToDetail?.date.let { newsDateDetail.text = it }
        newsToDetail?.description.let { newsDescriptionDetail.text = it }
    }

}