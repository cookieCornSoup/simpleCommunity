package com.example.simplecommunity.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class InputUtility(val context: Context) {

    fun hideKeyborad(view: View){
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


}