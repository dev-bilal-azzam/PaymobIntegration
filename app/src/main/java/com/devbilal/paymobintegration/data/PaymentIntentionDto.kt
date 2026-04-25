package com.devbilal.paymobintegration.data

import com.google.gson.annotations.SerializedName

data class PaymentIntentionRequest(
    val amount: Int,
    val currency: String,

    @SerializedName("payment_methods")
    val paymentMethods: List<Any>,

    val items: List<PaymentItem>? = null,

    @SerializedName("billing_data")
    val billingData: BillingData? = null,

    val extras: Map<String, Any>? = null,

    @SerializedName("special_reference")
    val specialReference: String? = null,

    val expiration: Int? = null,

    @SerializedName("notification_url")
    val notificationUrl: String? = null,

    @SerializedName("redirection_url")
    val redirectionUrl: String? = null
)


data class PaymentItem(
    val name: String,
    val amount: Int,
    val description: String,
    val quantity: Int
)


data class BillingData(
    val apartment: String? = null,

    @SerializedName("first_name")
    val firstName: String? = null,

    @SerializedName("last_name")
    val lastName: String? = null,

    val street: String? = null,
    val building: String? = null,

    @SerializedName("phone_number")
    val phoneNumber: String? = null,

    val city: String? = null,
    val country: String? = null,
    val email: String? = null,
    val floor: String? = null,
    val state: String? = null
)



data class PaymentIntentionResponse(

    @SerializedName("payment_keys")
    val paymentKeys: List<PaymentKey> = emptyList(),

    @SerializedName("intention_order_id")
    val intentionOrderId: Long,

    val id: String,

    @SerializedName("intention_detail")
    val intentionDetail: IntentionDetail? = null,

    @SerializedName("client_secret")
    val clientSecret: String,

    @SerializedName("payment_methods")
    val paymentMethods: List<PaymentMethod> = emptyList(),

    @SerializedName("special_reference")
    val specialReference: String? = null,

    val extras: Map<String, Any>? = null,

    val confirmed: Boolean,
    val status: String,
    val created: String,

    @SerializedName("card_detail")
    val cardDetail: String? = null,

    @SerializedName("card_tokens")
    val carkens: List<String> = emptyList(),

    val `object`: String
)


data class PaymentKey(
    val integration: Int,
    val key: String,

    @SerializedName("gateway_type")
    val gatewayType: String,

    @SerializedName("iframe_id")
    val iframeId: Int? = null,

    @SerializedName("order_id")
    val orderId: Long
)


data class IntentionDetail(
    val amount: Int,
    val items: List<IntentionItem> = emptyList(),
    val currency: String,

    @SerializedName("billing_data")
    val billingData: BillingDataResponse
)


data class IntentionItem(
    val name: String,
    val amount: Int,
    val description: String,
    val quantity: Int,
    val image: String? = null
)


data class BillingDataResponse(
    val apartment: String? = null,
    val floor: String? = null,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    val street: String? = null,
    val building: String? = null,

    @SerializedName("phone_number")
    val phoneNumber: String,

    @SerializedName("shipping_method")
    val shippingMethod: String? = null,

    val city: String? = null,
    val country: String? = null,
    val state: String? = null,
    val email: String,

    @SerializedName("postal_code")
    val postalCode: String? = null
)


data class PaymentMethod(
    @SerializedName("integration_id")
    val integrationId: Int,

    val alias: String? = null,
    val name: String,

    @SerializedName("method_type")
    val methodType: String,

    val currency: String,
    val live: Boolean,

    @SerializedName("use_cvc_with_moto")
    val useCvcWithMoto: Boolean
)