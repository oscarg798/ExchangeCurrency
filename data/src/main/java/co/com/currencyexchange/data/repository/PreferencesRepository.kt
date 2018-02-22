package co.com.currencyexchange.data.repository

import android.content.Context
import co.com.currencyexchange.data.local.ILocalStorage
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/22/18.
 */
class PreferencesRepository : IPreferencesRepository {

    @Inject
    lateinit var mLocalStorage: ILocalStorage

    override fun createLocalStorage(context: Context) {
        mLocalStorage.create(context)
    }

    override fun storeData(key: String, param: String) {
        mLocalStorage.storeData(key, param)
    }

    override fun getData(key: String): String? {
        return mLocalStorage.getData(key)
    }

    override fun removeData(key: String) {
        mLocalStorage.removeData(key)
    }


}