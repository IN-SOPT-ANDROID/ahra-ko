package org.sopt.sample.remote.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMusicAddDTO(
    @SerialName("statusCode")
    val statusCode: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int,
        @SerialName("image")
        val image: String,
        @SerialName("title")
        val title: String,
        @SerialName("singer")
        val singer: String
    )
}
