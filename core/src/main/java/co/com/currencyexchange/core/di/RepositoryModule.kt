package co.com.currencyexchange.core.di

import co.com.currencyexchange.data.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun providesRepositoryFactory(): IRepositoryFactory {
        return RepositoryFactory()
    }

    @Provides
    @Singleton
    fun providesExchangeRatesRepository(repositoryFactory: IRepositoryFactory): IExchangeRatesRepository {
        return repositoryFactory.getExchangeRepository()
    }

    @Provides
    @Singleton
    fun providesCurrencyRepository(repositoryFactory: IRepositoryFactory): ICurrencyRepository {
        return repositoryFactory.getCurrencyRepository()
    }

    @Provides
    @Singleton
    fun providesPreferenceRepository(repositoryFactory: IRepositoryFactory):IPreferencesRepository{
        return repositoryFactory.getPreferenceRepository()
    }

}