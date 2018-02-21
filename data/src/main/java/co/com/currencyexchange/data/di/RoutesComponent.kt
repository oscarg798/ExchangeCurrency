package co.com.currencyexchange.data.di

import co.com.currencyexchange.data.repository.ExchangeRatesRepository

import dagger.Component

/**
 * Created by oscarg798 on 2/21/18.
 */
@RouteScope
@Component(modules = [(RouteModule::class)])
interface RoutesComponent{

    fun inject(exchangeRatesRepository: ExchangeRatesRepository)
}