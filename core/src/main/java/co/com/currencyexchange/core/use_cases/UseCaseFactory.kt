package co.com.currencyexchange.core.use_cases

import android.content.Context
import android.widget.EditText
import co.com.currencyexchange.core.di.DaggerRepositoryComponent
import co.com.currencyexchange.core.di.RepositoryModule
import co.com.currencyexchange.core.use_cases.base.ICompletableUseCase
import co.com.currencyexchange.core.use_cases.base.IObservableUseCase
import co.com.currencyexchange.core.use_cases.base.ISingleUseCase
import co.com.currencyexchange.core.use_cases.currency.GetCurrenciesUsecase
import co.com.currencyexchange.core.use_cases.system.SubscribeEditTextChangesUseCase
import co.com.currencyexchange.core.use_cases.system.SubscribeToCurrencyConversionsUseCase
import co.com.currencyexchange.core.use_cases.exchange.CalculateExchangeRateUseCase
import co.com.currencyexchange.core.use_cases.exchange.GetExchangeRatesUseCase
import co.com.currencyexchange.core.use_cases.preferences.GetFavoriteCurrenciesUseCase
import co.com.currencyexchange.core.use_cases.preferences.SaveFavoriteCurrenciesUseCase
import co.com.currencyexchange.core.use_cases.system.CreateLocalStorageUseCase
import co.com.currencyexchange.data.local.models.Currency
import co.com.currencyexchange.data.local.models.ExchangeConversion
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by oscarg798 on 2/21/18.
 */
class UseCaseFactory : IUseCaseFactory {

    private val mRepostoryComponent by lazy {
        DaggerRepositoryComponent.builder()
                .repositoryModule(RepositoryModule())
                .build()
    }

    override val getCurrenciesUsecase: ISingleUseCase<List<Currency>, Context>
        get() {
            val iterator = GetCurrenciesUsecase(Schedulers.io(),
                    AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val getExchangeRateUseCase: ICompletableUseCase<Pair<String, String>>
        get() {
            val iterator = GetExchangeRatesUseCase(Schedulers.io(),
                    AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val subscribeToEditTextChangesUseCase: IObservableUseCase<TextViewAfterTextChangeEvent, EditText>
        get() {
            val iterator = SubscribeEditTextChangesUseCase(Schedulers.io(),
                    AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val subscribeToCurrencyConversionsUSeCase: IObservableUseCase<List<ExchangeConversion>, Any?>
        get() {
            val iterator = SubscribeToCurrencyConversionsUseCase(Schedulers.io(),
                    AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val calculateExchangeRateUseCase: ICompletableUseCase<Double>
        get() {
            val iterator = CalculateExchangeRateUseCase(Schedulers.io(),
                    AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val getFavoriteCurrenciesUSeCase: ISingleUseCase<List<String>, Any?>
        get() {
            val iterator = GetFavoriteCurrenciesUseCase(Schedulers.io(), AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val saveFavoriteCurrenciesUseCase: ICompletableUseCase<List<String>>
        get() {
            val iterator = SaveFavoriteCurrenciesUseCase(Schedulers.io(), AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }

    override val createLocalStorageUseCase: ICompletableUseCase<Context>
        get() {
            val iterator = CreateLocalStorageUseCase(Schedulers.io(), AndroidSchedulers.mainThread())
            mRepostoryComponent.inject(iterator)
            return iterator
        }
}