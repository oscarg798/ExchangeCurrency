package co.com.currencyexchange.data.di

import co.com.currencyexchange.data.network.routes.IConvertRoute
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by oscarg798 on 2/21/18.
 */
@RouteScope
@Module(includes = [(NetworkModule::class)])
class RouteModule {

    @Provides
    fun provideConvertRoute(retrofit: Retrofit): IConvertRoute = retrofit.create(IConvertRoute::class.java)


}