package lucasveras.com.br.projetofinal.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.Util.Util
import lucasveras.com.br.projetofinal.model.User
import lucasveras.com.br.projetofinal.model.dao.UserBO
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity

/*
 * Created by LucasVeras on 23/05/18.
 */

@EActivity(R.layout.activity_register)
open class RegisterActivity : AppCompatActivity() {

    @Bean
    protected lateinit var userBO: UserBO

    @AfterViews
    protected open fun afterViews(){
        Toast.makeText(this, userBO.getUsers().first().email, Toast.LENGTH_LONG).show()

    }

    @Click
    protected open fun registerNewUserButton(){
        if (registerEmailEditText.text.isNullOrEmpty() ||
                registerPasswordEditText.text.isNullOrEmpty() ||
                registerConfirmPasswordEditText.text.isNullOrEmpty()){


            Toast.makeText(this, getString(R.string.register_field_null), Toast.LENGTH_LONG).show()

            return
        }

        if (!Util.isEmailValid(registerEmailEditText.text.toString())){
            Toast.makeText(this, getString(R.string.email_invalid), Toast.LENGTH_LONG).show()

            return
        }

        val user = User()
        user.email = "lucasvac@gmail.com"
        user.password = "12345678"

        val id = userBO.insertUser(user)

        Toast.makeText(this, id.toString(), Toast.LENGTH_LONG).show()


    }

}