package com.devbilal.paymobintegration.presentation

import android.content.Context
import com.devbilal.paymobintegration.data.PUBLIC_KEY
import com.paymob.paymob_sdk.PaymobSdk
import com.paymob.paymob_sdk.ui.PaymobSdkListener

fun launchPaymobSdk(
    context: Context,
    paymobSdkListener: PaymobSdkListener,
    clientSecret: String,
    publicKey: String = PUBLIC_KEY // pass your own public key here
) {

    PaymobSdk.Builder(
        context = context,
        clientSecret = clientSecret,
        publicKey = publicKey,
        paymobSdkListener = paymobSdkListener
    ).build().start()
}