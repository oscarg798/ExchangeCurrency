package co.com.currencyexchange.data.network.routes

import co.com.currencyexchange.data.network.models.APICurrencyResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by oscarg798 on 2/21/18.
 */
interface IConvertRoute {

    @GET("latest")
    fun getCurrencyConvertion(@Query("base") base: String,
                              @Query("symbols") symbols: String): Flowable<APICurrencyResponse>

}