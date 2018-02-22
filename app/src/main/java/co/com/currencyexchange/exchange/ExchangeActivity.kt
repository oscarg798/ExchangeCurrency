package co.com.currencyexchange.exchange

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.EditText
import co.com.currencyexchange.BaseApplication
import co.com.currencyexchange.R
import co.com.currencyexchange.data.local.models.Currency
import co.com.currencyexchange.data.local.models.ExchangeConversion
import io.reactivex.Single
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_exchange.*

class ExchangeActivity : AppCompatActivity(), IExchangeActivityView {


    private val mPresenter: IExchangeActivityPresenter = ExchangeActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exchange)
        lifecycle.addObserver(mPresenter)
        mPresenter.bind(this)
        initComponents()

    }

    override fun initComponents() {
        mRVExchanges?.setHasFixedSize(false)
        mRVExchanges?.layoutManager = LinearLayoutManager(this)
        Single.create<Map<String, Currency>> { emitter ->
            val map = HashMap<String, Currency>()
            BaseApplication.getInstance().getmCurrencies().forEach {
                map[it.code] = it
            }
            emitter.onSuccess(map)
        }.subscribe(Consumer<Map<String, Currency>> {
                    mRVExchanges?.adapter = ExchangeRVAdapter(it)
                })
    }


    override fun showProgressBar() {
    }

    override fun hideProgressBar() {
    }

    override fun showConversions(conversions: List<ExchangeConversion>) {
        mRVExchanges?.adapter?.let {
            (it as ExchangeRVAdapter).clear()
            (it as ExchangeRVAdapter).addConversions(conversions)

        }
    }

    override fun clearConversions() {
        mRVExchanges?.adapter?.let {
            (it as ExchangeRVAdapter).clear()
        }
    }

    override fun getValueEditText(): EditText? {
        return mETValue
    }
}
