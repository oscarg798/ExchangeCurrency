package co.com.currencyexchange.core.di

import co.com.currencyexchange.core.use_cases.currency.GetCurrenciesUsecase
import co.com.currencyexchange.core.use_cases.system.SubscribeEditTextChangesUseCase
import co.com.currencyexchange.core.use_cases.system.SubscribeToCurrencyConversionsUseCase
import co.com.currencyexchange.core.use_cases.exchange.CalculateExchangeRateUseCase
import co.com.currencyexchange.core.use_cases.exchange.GetExchangeRatesUseCase
import co.com.currencyexchange.core.use_cases.preferences.GetFavoriteCurrenciesUseCase
import co.com.currencyexchange.core.use_cases.preferences.SaveFavoriteCurrenciesUseCase
import co.com.currencyexchange.core.use_cases.system.CreateLocalStorageUseCase
import dagger.Component
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Singleton
@Component(modules = [(RepositoryModule::class)])
interface RepositoryComponent {

    fun inject(getCurrenciesUseCase: GetCurrenciesUsecase)

    fun inject(getExchangeRatesUseCase: GetExchangeRatesUseCase)

    fun inject(subscribeEditTextChangesUseCase: SubscribeEditTextChangesUseCase)

    fun inject(subscribeToCurrencyConversionsUseCase: SubscribeToCurrencyConversionsUseCase)

    fun inject(calculateExchangeRateUseCase: CalculateExchangeRateUseCase)

    fun inject(getFavoriteCurrenciesUseCase: GetFavoriteCurrenciesUseCase)

    fun inject(saveFavoriteCurrenciesUseCase: SaveFavoriteCurrenciesUseCase)

    fun inject(createLocalStorageUseCase: CreateLocalStorageUseCase)
}