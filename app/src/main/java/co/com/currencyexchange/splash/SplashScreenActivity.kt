package co.com.currencyexchange.splash

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.com.currencyexchange.R
import co.com.currencyexchange.exchange.ExchangeActivity

class SplashScreenActivity : AppCompatActivity(), ISplashScreenView {

    private val mPresenter: ISplashScreenPresenter = SplashScreenPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        lifecycle.addObserver(mPresenter)
        mPresenter.bind(this)
    }

    override fun initComponents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToNextActivity() {
        startActivity(Intent(this, ExchangeActivity::class.java))
    }

    override fun getContext(): Context {
        return this
    }

}
