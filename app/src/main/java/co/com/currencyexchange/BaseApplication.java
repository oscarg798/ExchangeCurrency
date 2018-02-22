package co.com.currencyexchange;

import android.app.Application;

import java.util.List;

import co.com.currencyexchange.data.local.models.Currency;
import co.com.currencyexchange.di.DaggerUseCaseComponent;
import co.com.currencyexchange.di.UseCaseComponent;
import co.com.currencyexchange.di.UseCaseModule;

/**
 * Created by oscarg798 on 2/21/18.
 */

public class BaseApplication extends Application {


    private static BaseApplication instance;

    private UseCaseComponent mUseCaseComponent;

    private List<Currency> mCurrencies;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public UseCaseComponent getUseCaseComponent() {
        if (mUseCaseComponent == null) {
            mUseCaseComponent = DaggerUseCaseComponent.builder()
                    .useCaseModule(new UseCaseModule())
                    .build();
        }
        return mUseCaseComponent;
    }


    public static BaseApplication getInstance() {
        return instance;
    }

    public List<Currency> getmCurrencies() {
        return mCurrencies;
    }

    public void setmCurrencies(List<Currency> mCurrencies) {
        this.mCurrencies = mCurrencies;
    }
}
