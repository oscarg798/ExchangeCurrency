package co.com.currencyexchange.di

import co.com.currencyexchange.exchange.ExchangeActivityPresenter
import co.com.currencyexchange.preferences.PreferenceFragmentDialogPresenter
import co.com.currencyexchange.splash.SplashScreenPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Singleton
@Component(modules = [(UseCaseModule::class)])
interface UseCaseComponent {

    fun inject(splashScreenPresenter: SplashScreenPresenter)

    fun inject(exchangeActivityPresenter: ExchangeActivityPresenter)

    fun inject(preferenceDialogPresenter: PreferenceFragmentDialogPresenter)



}