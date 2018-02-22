package co.com.currencyexchange.preferences

import co.com.currencyexchange.IBasePresenter
import co.com.currencyexchange.IBaseView

/**
 * Created by oscarg798 on 2/22/18.
 */
interface IPreferenceFragmentDialogPresenter:IBasePresenter<IPreferenceFragmentDialogView>{


    fun onDonePressed()

}