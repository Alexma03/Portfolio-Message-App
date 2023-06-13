package com.alexma.messagelist.message.data

import com.alexma.messagelist.message.data.model.MessageModel
import retrofit2.Response
import retrofit2.http.GET

interface MessageApi {
    @GET("message")
    suspend fun getMessages(): Response<List<MessageModel>>
}