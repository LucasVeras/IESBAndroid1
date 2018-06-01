package lucasveras.com.br.projetofinal.activities

import android.support.v4.view.PagerAdapter
import kotlinx.android.synthetic.main.activity_news_list.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.adapter.BannerViewAdapter
import lucasveras.com.br.projetofinal.adapter.NewsListAdapter
import lucasveras.com.br.projetofinal.model.News
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity

/*
 * Created by LucasVeras on 30/05/18.
 */

@EActivity(R.layout.activity_news_list)
open class NewsListActivity: BaseActivity() {

    private var sampleImages: Array<Int> = arrayOf(R.drawable.android_logo, R.drawable.swift_logo, R.drawable.apple_logo)
    private var bannerAdapter: PagerAdapter = BannerViewAdapter(this, sampleImages)

    private var newsAdapter: NewsListAdapter? = null

    @AfterViews
    protected open fun afterViews(){
        bannerView.adapter = bannerAdapter
        newsAdapter = NewsListAdapter(this, mockNews())
        newsRecyclerView.adapter = newsAdapter
    }

    private fun mockNews(): List<News>{
        return listOf(
                News("Android",
                        "05/11/2007",
                        R.drawable.android_logo,
                        getString(R.string.android_description_news)),
                News("Swift",
                        "22/10/2014",
                        R.drawable.swift_logo,
                        getString(R.string.swift_description_news)),
                News("Apple",
                        "01/04/1976",
                        R.drawable.apple_logo,
                        getString(R.string.apple_description_news)),
                News("Android",
                        "05/11/2007",
                        R.drawable.android_logo,
                        getString(R.string.android_description_news)),
                News("Swift",
                        "22/10/2014",
                        R.drawable.swift_logo,
                        getString(R.string.swift_description_news)),
                News("Apple",
                        "01/04/1976",
                        R.drawable.apple_logo,
                        getString(R.string.apple_description_news)))
    }

}