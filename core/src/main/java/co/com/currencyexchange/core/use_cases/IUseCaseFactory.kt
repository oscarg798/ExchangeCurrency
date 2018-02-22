package co.com.currencyexchange.core.use_cases

import android.content.Context
import android.widget.EditText
import co.com.currencyexchange.core.use_cases.base.ICompletableUseCase
import co.com.currencyexchange.core.use_cases.base.IObservableUseCase
import co.com.currencyexchange.core.use_cases.base.ISingleUseCase
import co.com.currencyexchange.data.local.models.Currency
import co.com.currencyexchange.data.local.models.ExchangeConversion
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent

/**
 * Created by oscarg798 on 2/21/18.
 */
interface IUseCaseFactory {
    val getCurrenciesUsecase: ISingleUseCase<List<Currency>, Context>
    val getExchangeRateUseCase: ICompletableUseCase<Pair<String, String>>
    val subscribeToEditTextChangesUseCase: IObservableUseCase<TextViewAfterTextChangeEvent, EditText>
    val subscribeToCurrencyConversionsUSeCase: IObservableUseCase<List<ExchangeConversion>, Any?>
    val calculateExchangeRateUseCase: ICompletableUseCase<Double>
}