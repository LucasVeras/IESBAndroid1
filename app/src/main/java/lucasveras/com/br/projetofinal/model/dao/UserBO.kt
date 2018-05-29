package lucasveras.com.br.projetofinal.model.dao

import android.arch.persistence.room.Room
import android.content.Context
import lucasveras.com.br.projetofinal.model.User
import org.androidannotations.annotations.AfterInject
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EBean
import org.androidannotations.annotations.RootContext

/*
 * Created by LucasVeras on 28/05/18.
 */

@EBean(scope = EBean.Scope.Singleton)
open class UserBO {

    @RootContext
    protected lateinit var context: Context

    protected lateinit var database: AppDatabase

    @AfterInject
    protected fun afterInject(){
        database = Room.databaseBuilder(context, AppDatabase::class.java, "alunoonline-db").allowMainThreadQueries().build()
    }

    fun getUsers(): List<User>{
        return database.userDao().all
    }

    fun insertUser(user: User): Long{
        val ids = database.userDao().insertUsers(user)
        if (ids.isNotEmpty()){
            return ids.get(0)
        }

        return -1
    }

}