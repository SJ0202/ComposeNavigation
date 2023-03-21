package com.seongju.composenavigation.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestModel(
    val id: Int,
    val name: String,
    val age: Int
): Parcelable
