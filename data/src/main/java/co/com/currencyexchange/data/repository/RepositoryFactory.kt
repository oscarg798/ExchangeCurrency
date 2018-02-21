package co.com.currencyexchange.data.repository

import co.com.currencyexchange.data.di.DaggerRoutesComponent
import co.com.currencyexchange.data.di.NetworkModule

/**
 * Created by oscarg798 on 2/21/18.
 */
class RepositoryFactory private constructor() : IRepositoryFactory {


    private val mComponent by lazy {
        DaggerRoutesComponent.builder()
                .networkModule(NetworkModule())
                .build()
    }

    override val mExchangeRatesRepository: IExchangeRatesRepository
        get() {
            val repository = ExchangeRatesRepository()
            mComponent.inject(repository)
            return repository
        }


    private object HOLDER {

        val INSTACE = RepositoryFactory();

    }

    companion object {
        val instance by lazy {
            HOLDER.INSTACE
        }
    }
}