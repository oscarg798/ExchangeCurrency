package co.com.currencyexchange.exchange

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import co.com.currencyexchange.R

/**
 * Created by oscarg798 on 2/21/18.
 */
class ExchangeViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView) {


    val mTVCurrencySymbol = mItemView.findViewById<TextView>(R.id.mTVCurrencySymbol)
    val mTVCurrencyAbbreviation = mItemView.findViewById<TextView>(R.id.mTVCurrencyAbbreviation)
    val mTVCurrencyName = mItemView.findViewById<TextView>(R.id.mTVCurrencyName)
    val mTVValue = mItemView.findViewById<TextView>(R.id.mTVValue)
}