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
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCaseFactory(): IUseCaseFactory {
        return UseCaseFactory()
    }

    @Provides
    @Singleton
    fun providesGetCurrenciesUseCase(useCaseFactory: IUseCaseFactory): ISingleUseCase<List<Currency>, Context> {
        return useCaseFactory.getCurrenciesUsecase
    }

    @Provides
    @Singleton
    fun providesGetExchangeRatesUSeCase(useCaseFactory: IUseCaseFactory): ICompletableUseCase<Pair<String, String>> {
        return useCaseFactory.getExchangeRateUseCase
    }

    @Provides
    @Singleton
    fun providesSubscribeEditTextChangeUseCase(useCaseFactory: IUseCaseFactory):
            IObservableUseCase<TextViewAfterTextChangeEvent, EditText> {
        return useCaseFactory.subscribeToEditTextChangesUseCase
    }

    @Provides
    @Singleton
    fun providesSubscribeToCurrencyConversionUseCase(useCaseFactory: IUseCaseFactory):
            IObservableUseCase<List<ExchangeConversion>, Any?> {
        return useCaseFactory.subscribeToCurrencyConversionsUSeCase
    }


    @Provides
    @Singleton
    fun providesCalculateExchangeRateUseCase(useCaseFactory: IUseCaseFactory): ICompletableUseCase<Double> {
        return useCaseFactory.calculateExchangeRateUseCase
    }

    @Provides
    @Singleton
    fun providesCreateLocalStorageUseCase(useCaseFactory: IUseCaseFactory): ICompletableUseCase<Context> {
        return useCaseFactory.createLocalStorageUseCase
    }

    @Provides
    @Singleton
    fun providesGetFavoriteCurrenciesUseCase(useCaseFactory: IUseCaseFactory): ISingleUseCase<List<String>, Any?> {
        return useCaseFactory.getFavoriteCurrenciesUSeCase
    }

    @Provides
    @Singleton
    fun providesSaveFavoriteCurrenciesUseCase(useCaseFactory: IUseCaseFactory): ICompletableUseCase<List<String>> {
        return useCaseFactory.saveFavoriteCurrenciesUseCase
    }


    @Provides
    @Singleton
    fun providesGetHAsWacthedPreferenceDialog(useCaseFactory: IUseCaseFactory): ISingleUseCase<Boolean, Any?> {
        return useCaseFactory.getHasWacthedPreferenceDialogUseCase
    }

    @Provides
    @Singleton
    fun providesSaveHasWatchedPreferenceDialog(useCaseFactory: IUseCaseFactory): ICompletableUseCase<Boolean> {
        return useCaseFactory.saveHAsWacthedFavoriteDialog
    }


}