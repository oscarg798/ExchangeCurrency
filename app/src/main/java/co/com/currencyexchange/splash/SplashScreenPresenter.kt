package co.com.currencyexchange.splash

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import co.com.currencyexchange.BaseApplication
import co.com.currencyexchange.core.use_cases.base.ICompletableUseCase
import co.com.currencyexchange.core.use_cases.base.ISingleUseCase
import co.com.currencyexchange.data.local.models.Currency
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/21/18.
 */
class SplashScreenPresenter : ISplashScreenPresenter {

    @Inject
    lateinit var mGetCurrenciesUseCase: ISingleUseCase<List<Currency>, Context>

    @Inject
    lateinit var mGetExchangeRateUseCase: ICompletableUseCase<Pair<String, String>>

    override var mView: ISplashScreenView? = null

    private val mDisposableBag = CompositeDisposable()

    init {
        BaseApplication.getInstance()
                .useCaseComponent.inject(this)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun loadData() {
        mView?.let {

            val disposable = object : DisposableSingleObserver<List<Currency>>() {
                override fun onSuccess(t: List<Currency>) {
                    BaseApplication.getInstance().setmCurrencies(t)
                    getExchangeRates()
                    mDisposableBag.remove(this)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    mDisposableBag.remove(this)
                }
            }
            mDisposableBag.add(disposable)
            mGetCurrenciesUseCase.execute(it.getContext(), disposable)


        }


    }

    private fun getExchangeRates() {
        val disposable = object : DisposableCompletableObserver() {
            override fun onComplete() {
                mView?.navigateToNextActivity()
                mDisposableBag.remove(this)
            }

            override fun onError(e: Throwable) {
                mDisposableBag.remove(this)
                e.printStackTrace()
            }
        }
        mDisposableBag.add(disposable)
        mGetExchangeRateUseCase.execute(Pair("USD", "EUR,JPY,GBP"), disposable)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop() {
        mDisposableBag.clear()
    }
}


