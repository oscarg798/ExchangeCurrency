package co.com.currencyexchange.di

import co.com.currencyexchange.data.repository.IExchangeRatesRepository
import co.com.currencyexchange.data.repository.IRepositoryFactory
import co.com.currencyexchange.data.repository.RepositoryFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Singleton
@Module
class RepositoryModule {


    @Provides
    fun providesRepositoryFactory(): IRepositoryFactory {
        return RepositoryFactory()
    }

    @Provides
    fun providesExchangeRatesRepository(repositoryFactory: IRepositoryFactory): IExchangeRatesRepository {
        return repositoryFactory.mExchangeRatesRepository
    }
}