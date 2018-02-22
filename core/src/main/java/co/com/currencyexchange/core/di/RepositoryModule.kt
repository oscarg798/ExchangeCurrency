package co.com.currencyexchange.core.di

import co.com.currencyexchange.data.repository.ICurrencyRepository
import co.com.currencyexchange.data.repository.IExchangeRatesRepository
import co.com.currencyexchange.data.repository.IRepositoryFactory
import co.com.currencyexchange.data.repository.RepositoryFactory
import dagger.Module
import dagger.Provides

/**
 * Created by oscarg798 on 2/21/18.
 */
@RepositoryScope
@Module
class RepositoryModule {


    @Provides
    fun providesRepositoryFactory(): IRepositoryFactory {
        return RepositoryFactory.instance
    }

    @Provides
    fun providesExchangeRatesRepository(repositoryFactory: IRepositoryFactory): IExchangeRatesRepository {
        return repositoryFactory.getExchangeRepository()
    }

    @Provides
    fun providesCurrencyRepository(repositoryFactory: IRepositoryFactory): ICurrencyRepository {
        return repositoryFactory.getCurrencyRepository()
    }



}