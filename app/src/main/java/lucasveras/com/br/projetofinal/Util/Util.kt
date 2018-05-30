package lucasveras.com.br.projetofinal.Util

import android.content.Context
import android.widget.Toast
import lucasveras.com.br.projetofinal.activities.BaseActivity
import java.util.regex.Pattern

/*
 * Created by LucasVeras on 28/05/18.
 */

class Util {
    companion object {
        fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }

        fun showToast(context: Context, message: String){
            (context as BaseActivity).hideDialog()
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}