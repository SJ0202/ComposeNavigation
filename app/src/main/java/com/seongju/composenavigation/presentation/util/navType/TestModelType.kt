package com.seongju.composenavigation.presentation.util.navType

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.seongju.composenavigation.domain.model.TestModel

class TestModelType: NavType<TestModel>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): TestModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, TestModel::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): TestModel {
        return Gson().fromJson(value, TestModel::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: TestModel) {
        bundle.putParcelable(key, value)
    }
}