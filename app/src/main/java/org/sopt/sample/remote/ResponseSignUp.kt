package org.sopt.sample.remote

import kotlinx.serialization.Serializable

data class ResponseSignUp(
    val message: String,
    val newInfo: NewInfo,
    val status: Int
) {
    @Serializable
    data class NewInfo(
        val bio: String?,
        val email: String,
        val id: Int,
        val name: String,
        val password: String,
        val profileImage: String?
    )
}
