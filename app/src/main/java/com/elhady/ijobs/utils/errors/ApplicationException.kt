package com.elhady.ijobs.utils.errors


data class ApplicationException(
    val type: ErrorType,
    val errorMessage: String? = null,
    val errorMessageRes: Int? = null,
    val throwable: Throwable? = null
) : RuntimeException()

sealed class ErrorType {

    sealed class Network : ErrorType() {
        object BadRequest : Network()
        object Unauthorized : Network()
        object ResourceNotFound : Network()
        object UnProcessableEntity : Network()
        object Unexpected : Network()
        object NoInternetConnection : Network()
    }

    object None : ErrorType()
    object Warning : ErrorType()
    object Unexpected : ErrorType()
    object UserError : ErrorType()

}