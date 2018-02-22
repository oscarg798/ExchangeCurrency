package co.com.currencyexchange.di

import co.com.currencyexchange.exchange.ExchangeActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Singleton
@Component(modules = [(RepositoryModule::class)])
interface RepositoryComponent {

    fun inject(exchangeActivity: ExchangeActivity)
}