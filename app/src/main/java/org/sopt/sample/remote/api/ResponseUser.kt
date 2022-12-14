package org.sopt.sample.remote.api

import kotlinx.serialization.Serializable

@Serializable
data class ResponseUser(
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
) {
    @Serializable
    data class User(
        val avatar: String,
        val email: String,
        val first_name: String,
        val id: Int,
        val last_name: String
    )
    @Serializable
    data class Support(
        val text: String,
        val url: String
    )
}
