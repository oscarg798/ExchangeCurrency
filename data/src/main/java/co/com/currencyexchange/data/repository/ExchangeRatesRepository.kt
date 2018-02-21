package co.com.currencyexchange.data.repository

import co.com.currencyexchange.data.network.models.APICurrencyResponse
import co.com.currencyexchange.data.network.routes.IConvertRoute
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/21/18.
 */
class ExchangeRatesRepository : IExchangeRatesRepository {

    @Inject
    lateinit var mConvertRoute: IConvertRoute


    override fun getExchangeRates(base: String, symbols: String): Flowable<APICurrencyResponse> {
        return mConvertRoute.getCurrencyConvertion(base, symbols)

    }



}