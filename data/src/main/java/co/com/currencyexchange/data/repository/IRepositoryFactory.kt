package co.com.currencyexchange.data.repository

/**
 * Created by oscarg798 on 2/21/18.
 */
interface IRepositoryFactory {

    fun getExchangeRepository(): IExchangeRatesRepository

    fun getCurrencyRepository(): ICurrencyRepository

    fun getPreferenceRepository(): IPreferencesRepository
}