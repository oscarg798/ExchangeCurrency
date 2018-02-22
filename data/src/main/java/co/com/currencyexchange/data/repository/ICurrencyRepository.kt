package co.com.currencyexchange.data.repository

import android.content.Context
import co.com.currencyexchange.data.local.models.Currency
import io.reactivex.Single


/**
 * Created by oscarg798 on 2/21/18.
 */
interface ICurrencyRepository {
    var mCurrencies: List<Currency>?

    fun getCurrencies(context: Context): Single<List<Currency>>
}