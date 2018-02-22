package co.com.currencyexchange.preferences

import co.com.currencyexchange.IBaseView
import co.com.currencyexchange.data.local.models.Currency

/**
 * Created by oscarg798 on 2/22/18.
 */
interface IPreferenceFragmentDialogView : IBaseView {

    fun showFavoritesCurrencies(currencies: List<Currency>, favoriteCurrencies: ArrayList<String>)

    fun getFavoriteCurrencies(): List<String>?

    fun updateDone()
}