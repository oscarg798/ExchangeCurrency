package co.com.currencyexchange.data.local

import android.content.Context
import android.content.SharedPreferences
import co.com.currencyexchange.data.PREF_NAME

/**
 * Created by oscarg798 on 2/22/18.
 */
class LocalStorage : ILocalStorage {

    private var mSharedPreference: SharedPreferences? = null


    override fun create(context: Context) {
        mSharedPreference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun storeData(key: String, param: String) {
        mSharedPreference?.edit()?.putString(key, param)?.apply()
    }

    override fun getData(key: String): String? {
        return mSharedPreference?.getString(key, null)
    }

    override fun removeData(key: String) {
        mSharedPreference?.edit()?.remove(key)?.apply()
    }


}