package lucasveras.com.br.projetofinal.model.dao

import android.arch.persistence.room.Room
import android.content.Context
import lucasveras.com.br.projetofinal.model.User

/*
 * Created by LucasVeras on 28/05/18.
 */

open class UserBO(context: Context) {

    private var database: AppDatabase

    init {
        database = Room.databaseBuilder(context, AppDatabase::class.java, "alunoonline-db").allowMainThreadQueries().build()
    }

    fun getUsers(): List<User>{
        return database.userDao().all
    }

    fun getUser(email: String): User?{
        return database.userDao().findByEmail(email)
    }

    fun insertUser(user: User): Long{
        val ids = database.userDao().insertUsers(user)
        if (ids.isNotEmpty()){
            return ids.get(0)
        }

        return -1
    }

}