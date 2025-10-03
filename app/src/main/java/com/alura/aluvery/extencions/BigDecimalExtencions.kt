package com.alura.aluvery.extencions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toBrazilianCurrency(): String {
    val locale = Locale.forLanguageTag("pt-BR")
    return NumberFormat
        .getCurrencyInstance(locale)
        .format(this)
}
