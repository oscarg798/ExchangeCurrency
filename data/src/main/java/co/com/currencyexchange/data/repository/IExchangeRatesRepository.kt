package co.com.currencyexchange.data.repository

import co.com.currencyexchange.data.network.models.APICurrencyResponse
import io.reactivex.Observable
import io.reactivex.subjects.Subject

/**
 * Created by oscarg798 on 2/21/18.
 */
interface IExchangeRatesRepository {

    fun getExchangeRates(base: String, symbols: String): Observable<APICurrencyResponse>

    val mExchangePublisher: Subject<HashMap<String, Double>>

    fun calculateExchangeRate(quantity: Double)

    fun doneWithConversions()
}