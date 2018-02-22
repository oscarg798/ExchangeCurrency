package co.com.currencyexchange.exchange

import android.widget.EditText
import co.com.currencyexchange.IBaseView
import co.com.currencyexchange.data.local.models.ExchangeConversion

/**
 * Created by oscarg798 on 2/21/18.
 */
interface IExchangeActivityView : IBaseView {

    fun getValueEditText(): EditText?

    fun showConversions(conversions: List<ExchangeConversion>)

    fun clearConversions()

    fun showPreferenceDialog()
}



