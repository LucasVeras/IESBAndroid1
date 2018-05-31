package lucasveras.com.br.projetofinal.activities

import android.support.v4.view.PagerAdapter
import kotlinx.android.synthetic.main.activity_news_list.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.adapter.BannerViewAdapter
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity

/*
 * Created by LucasVeras on 30/05/18.
 */

@EActivity(R.layout.activity_news_list)
open class NewsListActivity: BaseActivity() {

    private var sampleImages: Array<Int> = arrayOf(R.drawable.android_logo, R.drawable.swift_logo, R.drawable.apple_logo)
    private var bannerAdapter: PagerAdapter = BannerViewAdapter(this, sampleImages)

    @AfterViews
    protected open fun afterViews(){
        bannerView.adapter = bannerAdapter
    }



}