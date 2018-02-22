package co.com.currencyexchange.exchange

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import co.com.currencyexchange.R
import co.com.currencyexchange.data.network.models.APICurrencyResponse
import co.com.currencyexchange.data.repository.IExchangeRatesRepository
import co.com.currencyexchange.di.DaggerRepositoryComponent
import co.com.currencyexchange.di.RepositoryModule
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_exchange.*
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern
import javax.inject.Inject

class ExchangeActivity : AppCompatActivity() {

    @Inject
    lateinit var mExchangeRepository: IExchangeRatesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)
        DaggerRepositoryComponent.builder()
                .repositoryModule(RepositoryModule())
                .build()
                .inject(this)




        mExchangeRepository.mExchangePublisher
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    for ((key, value) in it) {
                        Log.i("Exchange", "$key = $value")
                    }
                }

        mExchangeRepository
                .getExchangeRates("USD", "EUR,JPY,GBP")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<APICurrencyResponse>() {
                    override fun onComplete() {

                    }

                    override fun onNext(t: APICurrencyResponse) {
                        Log.i("RESPONSE", t.rates["EUR"].toString())

                        RxTextView.afterTextChangeEvents(mETValue).skipInitialValue()
                                .delay(100, TimeUnit.MILLISECONDS)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe {
                                    it.editable()?.let {
                                        if(TextUtils.isDigitsOnly(it) && !TextUtils.isEmpty(it)){
                                            mExchangeRepository
                                                    .calculateExchangeRate(it.toString().toDouble())
                                        }

                                    }
                                }

                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })

    }
}
