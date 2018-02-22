package co.com.currencyexchange.data.repository

import co.com.currencyexchange.data.di.DaggerPersistenceComponent
import co.com.currencyexchange.data.di.DaggerRoutesComponent
import co.com.currencyexchange.data.di.NetworkModule
import co.com.currencyexchange.data.di.PersistenceModule

/**
 * Created by oscarg798 on 2/21/18.
 */
class RepositoryFactory : IRepositoryFactory {


    private val mComponent by lazy {
        DaggerRoutesComponent.builder()
                .networkModule(NetworkModule())
                .build()



    }

    private val mPreferenceComponent =
            DaggerPersistenceComponent.builder()
                    .persistenceModule(PersistenceModule())
                    .build()


    private var mExchangeRatesRepository: ExchangeRatesRepository? = null


    private var mCurrencyRepository: CurrencyRepository? = null

    private var mPreferencesRepository: PreferencesRepository? = null


    override fun getCurrencyRepository(): ICurrencyRepository {
        if (mCurrencyRepository === null) {
            mCurrencyRepository = CurrencyRepository()
        }

        return mCurrencyRepository!!
    }

    override fun getExchangeRepository(): IExchangeRatesRepository {
        if (mExchangeRatesRepository === null) {
            mExchangeRatesRepository = ExchangeRatesRepository()
            mComponent.inject(mExchangeRatesRepository!!)
        }
        return mExchangeRatesRepository!!
    }

    override fun getPreferenceRepository(): IPreferencesRepository {
        if (mPreferencesRepository === null) {
            mPreferencesRepository = PreferencesRepository()
            mPreferenceComponent.inject(mPreferencesRepository!!)
        }

        return mPreferencesRepository!!
    }


}