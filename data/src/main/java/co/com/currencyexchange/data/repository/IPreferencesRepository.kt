package co.com.currencyexchange.data.repository

import android.content.Context

/**
 * Created by oscarg798 on 2/22/18.
 */
interface IPreferencesRepository {

    fun createLocalStorage(context: Context)

    fun storeData(key: String, param: String)

    fun getData(key: String): String?

    fun removeData(key: String)
}