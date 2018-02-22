package co.com.currencyexchange.di

import android.content.Context
import android.widget.EditText
import co.com.currencyexchange.core.use_cases.IUseCaseFactory
import co.com.currencyexchange.core.use_cases.UseCaseFactory
import co.com.currencyexchange.core.use_cases.base.ICompletableUseCase
import co.com.currencyexchange.core.use_cases.base.IObservableUseCase
import co.com.currencyexchange.core.use_cases.base.ISingleUseCase
import co.com.currencyexchange.data.local.models.Currency
import co.com.currencyexchange.data.local.models.ExchangeConversion
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Singleton
@Module
class UseCaseModule {

    @Provides
    fun provideUseCaseFactory(): IUseCaseFactory {
        return UseCaseFactory()
    }

    @Provides
    fun providesGetCurrenciesUseCase(useCaseFactory: IUseCaseFactory): ISingleUseCase<List<Currency>, Context> {
        return useCaseFactory.getCurrenciesUsecase
    }

    @Provides
    fun providesGetExchangeRatesUSeCase(useCaseFactory: IUseCaseFactory): ICompletableUseCase<Pair<String, String>> {
        return useCaseFactory.getExchangeRateUseCase
    }

    @Provides
    fun providesSubscribeEditTextChangeUseCase(useCaseFactory: IUseCaseFactory):
            IObservableUseCase<TextViewAfterTextChangeEvent, EditText> {
        return useCaseFactory.subscribeToEditTextChangesUseCase
    }

    @Provides
    fun providesSubscribeToCurrencyConversionUseCase(useCaseFactory: IUseCaseFactory):
            IObservableUseCase<List<ExchangeConversion>, Any?> {
        return useCaseFactory.subscribeToCurrencyConversionsUSeCase
    }

    @Provides
    fun providesCalculateExchangeRateUseCase(useCaseFactory: IUseCaseFactory): ICompletableUseCase<Double> {
        return useCaseFactory.calculateExchangeRateUseCase
    }


}