package lucasveras.com.br.projetofinal.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.banner_view_image_item.view.*
import lucasveras.com.br.projetofinal.R

/*
 * Created by LucasVeras on 30/05/18.
 */

class BannerViewAdapter(var context: Context, private var images: Array<Int>) : PagerAdapter() {

    private lateinit var inflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as LinearLayout

    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image: ImageView

        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = inflater.inflate(R.layout.banner_view_image_item, container, false)
        image = view.banner_view_image
        image.setBackgroundResource(images[position])
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}