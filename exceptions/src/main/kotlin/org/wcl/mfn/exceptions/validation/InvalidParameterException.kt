package org.wcl.mfn.exceptions.validation

class InvalidParameterException: Exception {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}
