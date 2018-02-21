package co.com.currencyexchange.exchange

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.com.currencyexchange.R
import co.com.currencyexchange.data.network.models.APICurrencyResponse
import co.com.currencyexchange.data.repository.RepositoryFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class ExchangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)

        RepositoryFactory.instance.mExchangeRatesRepository
                .getExchangeRates("USD", "EUR")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<APICurrencyResponse> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(s: Subscription?) {
                    }

                    override fun onNext(t: APICurrencyResponse?) {
                        t?.let {
                            Log.i("RESPONSE", t.rates["EUR"])
                        }
                    }

                    override fun onError(t: Throwable?) {
                        t?.printStackTrace()
                    }
                })

    }
}
