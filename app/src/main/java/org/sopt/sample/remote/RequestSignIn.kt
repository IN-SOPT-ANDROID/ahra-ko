package org.sopt.sample.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignIn(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String
)
