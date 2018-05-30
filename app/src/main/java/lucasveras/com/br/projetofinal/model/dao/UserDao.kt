package lucasveras.com.br.projetofinal.model.dao

import android.arch.persistence.room.*
import lucasveras.com.br.projetofinal.model.User

/*
 * Created by LucasVeras on 28/05/18.
 */

@Dao
interface UserDao {

    @get:Query("SELECT * FROM user")
    val all: List<User>

    @Query("SELECT * FROM user WHERE email LIKE :email LIMIT 1")
    fun findByEmail(email: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User): List<Long>

    @Delete
    fun delete(user: User)

}