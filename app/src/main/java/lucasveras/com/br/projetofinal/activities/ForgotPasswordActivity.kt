package lucasveras.com.br.projetofinal.activities

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.Util.Util
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity

/*
 * Created by LucasVeras on 23/05/18.
 */
@EActivity(R.layout.activity_forgot_password)
open class ForgotPasswordActivity : BaseActivity() {

    @Click
    protected open fun resetPasswordButton(){
        if (validateField()){

        }
    }

    private fun validateField(): Boolean{
        if (forgotEmailEditText.text.isNullOrEmpty()){
            Util.showToast(this, getString(R.string.required_email))

            return false
        }

        if (!Util.isEmailValid(forgotEmailEditText.text.toString())){
            Util.showToast(this, getString(R.string.email_invalid))

            return false
        }

        return true
    }
}