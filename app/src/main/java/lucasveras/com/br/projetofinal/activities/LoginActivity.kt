package lucasveras.com.br.projetofinal.activities

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.Util.Util
import org.androidannotations.annotations.*

@EActivity(R.layout.activity_login)
open class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    @Click
    protected open fun loginButton(){
        showLoadingDialog()
        if (validateLogin()){
            createUserBO()
            val userInDb = userBO?.getUser(emailEditText.text.toString())
            dismissUserBO()

            if (userInDb == null || !userInDb.password.equals(passwordEditText.text.toString())){
                Util.showToast(this, getString(R.string.login_invalid))
            }else{
                NewsListActivity_.intent(this)
                        .flags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        .start()
            }
        }
    }

    @Click
    protected open fun registerButton(){
        RegisterActivity_.intent(this).start()
    }

    @Click
    protected open fun forgotPasswordTextView(){
        ForgotPasswordActivity_.intent(this).start()
    }

    private fun validateLogin(): Boolean{
        if (emailEditText.text.isNullOrEmpty() ||
                passwordEditText.text.isNullOrEmpty()){
            Util.showToast(this, getString(R.string.register_field_null))

            return false
        }

        if (!Util.isEmailValid(emailEditText.text.toString())){
            Util.showToast(this, getString(R.string.email_invalid))

            return false
        }

        return true
    }
}
