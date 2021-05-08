package com.example.bakkaldefteri.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.bakkaldefteri.R
import com.example.bakkaldefteri.database.Spending

class BindingAdapter {
    companion object {
        @BindingAdapter("imSpendingType")
        @JvmStatic
        fun ImageView.setImSpendingType(spending: Spending?) {
            spending?.let {
                setImageResource(
                    when (spending.imageCategory) {
                        "bill" -> R.drawable.ic_bill
                        "shopping" -> R.drawable.ic_shopping
                        else -> R.drawable.ic_others
                    }
                )
            }
        }

        @BindingAdapter("app:tvSpendingDescription")
        @JvmStatic
        fun TextView.setTvSpendingDescription(spending: Spending?) {
            spending?.let {
                text = spending.description
            }
        }


        @BindingAdapter("app:tvCost")
        @JvmStatic
        fun TextView.setTvCost(spending: Spending?) {
            spending?.let {
                text = spending.spendingCost.toString()
            }
        }

//        @BindingAdapter("app:tvTotalExpense")
//        @JvmStatic
//        fun TextView.setTvTotalExpense(spending: Spending?) {
//            expense?.let {
//                text = expense.total.toString()
//            }
//        }

//        @BindingAdapter("app:tvName")
//        @JvmStatic
//        fun TextView.setTvName(profile: Profile?) {
//            profile?.let {
//                when (profile.gender) {
//                    "male" -> text = profile.name + " Bey"
//                    "female" -> text = profile.name + " Hanım"
//                    else -> text = profile.name
//                }
//            }
//        }


    }
}