package org.sopt.sample.remote.api

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

@Serializable
data class ResponseSignUp(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("newUser")
    val newUser: NewUser
) {
    @Serializable
    data class NewUser(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String,
        @SerialName("profileImage")
        val profileImage: String?,
        @SerialName("bio")
        val bio: String?,
        @SerialName("email")
        val email: String,
        @SerialName("password")
        val password: String
    )
}