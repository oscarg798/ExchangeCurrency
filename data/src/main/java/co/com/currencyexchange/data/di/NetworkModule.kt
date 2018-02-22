package co.com.currencyexchange.data.di

import co.com.currencyexchange.data.BASEURL
import co.com.currencyexchange.data.DATE_FORMAT
import co.com.currencyexchange.data.network.ToStringConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by oscarg798 on 2/21/18.
 */
@Module
class NetworkModule {


    @Provides
    fun provideLoginInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
        builder.networkInterceptors().add(httpLoggingInterceptor)

        return builder.build()
    }

    @Provides
    fun provideGson(): Gson =
            GsonBuilder()
                    .setDateFormat(DATE_FORMAT)
                    .setLenient()
                    .create()

    @Provides
    @Singleton
    fun provideRetroFit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ToStringConverterFactory())
                .build()
    }


}