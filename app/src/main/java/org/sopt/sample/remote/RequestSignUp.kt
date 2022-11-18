package org.sopt.sample.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUp(
    @SerialName("email")
    val email : String,
    @SerialName("password")
    val password : String,
    @SerialName("name")
    val name : String
)
