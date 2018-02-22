package co.com.currencyexchange.data.di

import co.com.currencyexchange.data.repository.PreferencesRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/22/18.
 */
@Singleton
@Component(modules = [(PersistenceModule::class)])
interface PersistenceComponent {


    fun inject(preferencesRepository: PreferencesRepository)

}