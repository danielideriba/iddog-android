package br.android.iddog.data.source

import br.android.iddog.data.error.ErrorResponse

interface RepositoryCallback {
    fun onSuccess(result: Any? = null)
    fun onFailure(error: ErrorResponse? = ErrorResponse())
}