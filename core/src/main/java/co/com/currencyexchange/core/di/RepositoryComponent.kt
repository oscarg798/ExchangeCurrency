package co.com.currencyexchange.core.di

import co.com.currencyexchange.core.use_cases.currency.GetCurrenciesUsecase
import co.com.currencyexchange.core.use_cases.currency.SubscribeEditTextChangesUseCase
import co.com.currencyexchange.core.use_cases.currency.SubscribeToCurrencyConversionsUseCase
import co.com.currencyexchange.core.use_cases.exchange.CalculateExchangeRateUseCase
import co.com.currencyexchange.core.use_cases.exchange.GetExchangeRatesUseCase
import dagger.Component

/**
 * Created by oscarg798 on 2/21/18.
 */
@RepositoryScope
@Component(modules = [(RepositoryModule::class)])
interface RepositoryComponent {

    fun inject(getCurrenciesUseCase: GetCurrenciesUsecase)

    fun inject(getExchangeRatesUseCase: GetExchangeRatesUseCase)

    fun inject(subscribeEditTextChangesUseCase: SubscribeEditTextChangesUseCase)

    fun inject(subscribeToCurrencyConversionsUseCase: SubscribeToCurrencyConversionsUseCase)

    fun inject(calculateExchangeRateUseCase: CalculateExchangeRateUseCase)
}