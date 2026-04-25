package com.devbilal.paymobintegration.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devbilal.paymobintegration.data.PaymentRepository
import com.paymob.paymob_sdk.ui.PaymobSdkListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

sealed class PaymentEffect {
    data class StartPayment(val clientSecret: String) : PaymentEffect()
    data class ShowToast(val message: String?) : PaymentEffect()
}

data class PaymentState(
    val amount: String = "",
    val isLoading: Boolean = false
)

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val repo: PaymentRepository
) : ViewModel(), PaymobSdkListener {

    private val _state = MutableStateFlow(PaymentState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PaymentEffect>()
    val effect = _effect.asSharedFlow()

    fun onPayClicked() {
        viewModelScope.launch {

            val amountInt = _state.value.amount.toIntOrNull()
            if (amountInt == null || amountInt == 0) {
                _effect.emit(PaymentEffect.ShowToast("The amount can't be zero"))
                return@launch
            }

            _state.update { it.copy(isLoading = true) }

            try {
                val clientSecret = repo.getClientSecretKey(amountInt)

                _effect.emit(PaymentEffect.StartPayment(clientSecret))

            } catch (e: HttpException) {
                val message = e.response()?.errorBody()?.string()
                _effect.emit(PaymentEffect.ShowToast(message))
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    fun onAmountChanged(amount: String) {
        _state.update { it.copy(amount = amount) }
    }

    // paymob sdk callbacks

    override fun onSuccess(payResponse: HashMap<String, String?>) {
        viewModelScope.launch {
            _effect.emit(PaymentEffect.ShowToast("Payment Successful"))
        }
    }

    override fun onFailure(msg: String?) {
        viewModelScope.launch {
            _effect.emit(PaymentEffect.ShowToast("Payment Failed : $msg"))
        }
    }

    override fun onPending() {
    }
}