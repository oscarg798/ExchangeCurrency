package co.com.currencyexchange.data.repository

import co.com.currencyexchange.data.di.DaggerRoutesComponent
import co.com.currencyexchange.data.di.NetworkModule

/**
 * Created by oscarg798 on 2/21/18.
 */
class RepositoryFactory : IRepositoryFactory {


    private val mComponent by lazy {
        DaggerRoutesComponent.builder()
                .networkModule(NetworkModule())
                .build()
    }


    override var mExchangeRatesRepository: ExchangeRatesRepository? = null


    override var mCurrencyRepository: CurrencyRepository? = null


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


}