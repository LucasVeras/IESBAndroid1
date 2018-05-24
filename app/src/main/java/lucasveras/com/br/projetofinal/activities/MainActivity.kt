package lucasveras.com.br.projetofinal.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import lucasveras.com.br.projetofinal.R
import org.androidannotations.annotations.*

@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    @Click
    protected open fun registerButton(){
        RegisterActivity_.intent(this).start()
    }

    @Click
    protected open fun forgotPasswordTextView(){
        ForgotPasswordActivity_.intent(this).start()
    }
}
