package lucasveras.com.br.projetofinal.model.dao

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import lucasveras.com.br.projetofinal.model.User

/*
 * Created by LucasVeras on 28/05/18.
 */

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}