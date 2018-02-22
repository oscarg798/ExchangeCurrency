package co.com.currencyexchange.data.network.models

/**
 * Created by oscarg798 on 2/21/18.
 */
data class APICurrencyResponse(val base: String,
                               val date: String,
                               val rates: HashMap<String, Double>)