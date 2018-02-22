package co.com.currencyexchange.data.di

import co.com.currencyexchange.data.local.ILocalStorage
import co.com.currencyexchange.data.local.LocalStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/22/18.
 */
@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun providesLocalStorage(): ILocalStorage {
        return LocalStorage()
    }
}