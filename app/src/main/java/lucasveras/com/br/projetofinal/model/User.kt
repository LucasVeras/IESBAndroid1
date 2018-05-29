package lucasveras.com.br.projetofinal.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
 * Created by LucasVeras on 28/05/18.
 */

@Entity
class User {

    @PrimaryKey
    var email: String = ""

    var password: String? = null

}