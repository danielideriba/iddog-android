package br.android.iddog.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import br.android.iddog.R
import br.android.iddog.ui.main.MainActivity

object AlertDialogs {
    fun showDialogRedirect(context: Context, title: String, bodyMsg: String): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(bodyMsg)
        return builder
    }

    fun showDialog(context: Context, msg: String) {
        AlertDialog.Builder(context)
            .setTitle(context.resources.getString(R.string.atenttion))
            .setMessage(msg)
            .setPositiveButton(context.resources.getString(R.string.ok)) { _, _ ->
                false
            }
            .setCancelable(false)
            .show()
    }
}