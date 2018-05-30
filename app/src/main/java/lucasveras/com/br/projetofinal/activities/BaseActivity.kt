package lucasveras.com.br.projetofinal.activities

import android.support.annotation.UiThread
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import lucasveras.com.br.projetofinal.R
import lucasveras.com.br.projetofinal.model.dao.UserBO

/*
 * Created by LucasVeras on 29/05/18.
 */

abstract class BaseActivity: AppCompatActivity() {

    open var userBO: UserBO? = null

    private var dialog: AlertDialog? = null


    @UiThread
    open fun hideDialog() {
        dialog?.dismiss()
        dialog = null
    }

    open fun showLoadingDialog() {
        dialog?.dismiss()
        dialog = null

        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.dialog_progress).setCancelable(false)

        dialog = builder.create()

        val width = resources.getDimensionPixelSize(R.dimen.progress_dialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.progress_dialog_height)

        dialog?.show()
        dialog?.window?.setLayout(width, height)
    }

    open fun createUserBO() = if (userBO == null) { userBO = UserBO(this) } else {}
    open fun dismissUserBO() {
        userBO = null
    }

}