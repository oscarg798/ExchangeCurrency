package co.com.currencyexchange.data.repository

import co.com.currencyexchange.data.network.models.APICurrencyResponse
import io.reactivex.Flowable

/**
 * Created by oscarg798 on 2/21/18.
 */
interface IExchangeRatesRepository {

    fun getExchangeRates(base: String, symbols: String): Flowable<APICurrencyResponse>
}