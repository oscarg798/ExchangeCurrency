package co.com.currencyexchange.splash

import android.content.Context
import co.com.currencyexchange.IBaseView
import java.lang.ref.WeakReference

/**
 * Created by oscarg798 on 2/21/18.
 */
interface ISplashScreenView : IBaseView {

    fun navigateToNextActivity()

    fun getContext(): Context
}