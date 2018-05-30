package lucasveras.com.br.projetofinal.activities

import kotlinx.android.synthetic.main.activity_register.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.Util.Util
import lucasveras.com.br.projetofinal.model.User
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity
import java.util.regex.Pattern

/*
 * Created by LucasVeras on 23/05/18.
 */

@EActivity(R.layout.activity_register)
open class RegisterActivity : BaseActivity() {

    @Click
    protected open fun registerNewUserButton(){
        showLoadingDialog()
        if (validateRegister()){
            hideDialog()

            val newUser = User()

            newUser.email = registerEmailEditText.text.toString()
            newUser.password = registerPasswordEditText.text.toString()

            createUserBO()
            userBO?.insertUser(newUser)
            dismissUserBO()

            Util.showToast(this, getString(R.string.register_success))
            finish()
        }
    }

    private fun validateRegister(): Boolean{
        if (registerEmailEditText.text.isNullOrEmpty() ||
                registerPasswordEditText.text.isNullOrEmpty() ||
                registerConfirmPasswordEditText.text.isNullOrEmpty()){
            Util.showToast(this, getString(R.string.register_field_null))

            return false
        }

        if (!Util.isEmailValid(registerEmailEditText.text.toString())){
            Util.showToast(this, getString(R.string.email_invalid))

            return false
        }

        if (registerPasswordEditText.text.length < 6){
            Util.showToast(this, getString(R.string.password_invalid_length))

            return false
        }

        if (!registerPasswordEditText.text.toString().equals(registerConfirmPasswordEditText.text.toString())){
            Util.showToast(this, getString(R.string.password_and_confirmation_diferent))

            return false
        }

        if (!Pattern.compile(".*[A-Z].*").matcher(registerPasswordEditText.text.toString()).matches()){
            Util.showToast(this, getString(R.string.password_at_least_one_uppercase))

            return false
        }

        if (!Pattern.compile(".*\\d.*").matcher(registerPasswordEditText.text.toString()).matches()){
            Util.showToast(this, getString(R.string.password_at_least_one_digit))

            return false
        }

        if (!Pattern.compile(".*[!@#\$%^&*].*").matcher(registerPasswordEditText.text.toString()).matches()){
            Util.showToast(this, getString(R.string.password_at_least_one_special_caracter))

            return false
        }

        createUserBO()
        if (userBO?.getUser(registerEmailEditText.text.toString()) != null){
            dismissUserBO()
            Util.showToast(this, getString(R.string.email_already_registered))

            return false
        }
        dismissUserBO()

        return true
    }

}