@file:OptIn(ExperimentalUuidApi::class)

package com.devbilal.paymobintegration.data

import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi

class PaymentRepository  @Inject constructor(private val api: PaymentService) {
    suspend fun getClientSecretKey(amount: Int): String {
        val amountInCents = amount * 100
        val paymentRequest = PaymentIntentionRequest(
            amount = amountInCents, // should be in cents
            currency = "EGP",

            paymentMethods = listOf(
                ONLINE_CARD_PAYMENT_METHOD_ID,
                MOBILE_WALLET_PAYMENT_METHOD_ID
            ),

            items = listOf(
                PaymentItem(
                    name = "Test Product",
                    // this amount should be the same the amount above
                    amount = amountInCents,
                    description = "Dummy item for testing",
                    quantity = 1
                )
            ),
            billingData = BillingData(
                firstName = "Bilal",
                lastName = "Azzam",
                email = "bilal@test.com",
                phoneNumber = "01000000000",
            )
        )

        return api.createPaymentIntention(paymentRequest).clientSecret
    }
}