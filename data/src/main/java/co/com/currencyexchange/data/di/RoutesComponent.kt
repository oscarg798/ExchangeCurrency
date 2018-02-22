package co.com.currencyexchange.data.di

import co.com.currencyexchange.data.repository.ExchangeRatesRepository
import co.com.currencyexchange.data.repository.PreferencesRepository

import dagger.Component
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Singleton
@Component(modules = [(RouteModule::class)])
interface RoutesComponent {

    fun inject(exchangeRatesRepository: ExchangeRatesRepository)
}