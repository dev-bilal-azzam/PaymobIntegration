package com.devbilal.paymobintegration.data

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PaymentService {

    // remember that secret key shouldn't reside in mobile it should be on the server instead
    @Headers("Authorization: Token $SECRET_KEY")
    @POST("v1/intention/")
    suspend fun createPaymentIntention(@Body paymentRequest: PaymentIntentionRequest): PaymentIntentionResponse
}