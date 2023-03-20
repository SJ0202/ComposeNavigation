package com.seongju.composenavigation.presentation.util

fun makeNumberOnly(text: String): String {
    return Regex("[^0-9]").replace(text, "")
}