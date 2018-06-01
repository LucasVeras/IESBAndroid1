package lucasveras.com.br.projetofinal.model

import android.os.Parcel
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

/*
 * Created by LucasVeras on 31/05/18.
 */

@Parcelize
class News (
        var titleNews: String? = null,
        var date: String? = null,
        var image: Int? = null,
        var description: String? = null
): Parcelable