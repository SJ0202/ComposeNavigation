package com.seongju.composenavigation.presentation.util

import android.net.Uri
import com.google.gson.Gson
import com.seongju.composenavigation.domain.model.TestModel

sealed class Screen(val route:String) {

    object FirstScreen: Screen("first_screen")
    object SecondScreen: Screen("second_screen") {
        fun passTestModel(testModel: TestModel): String {
            val json = Uri.encode(Gson().toJson(testModel))
            return "second_screen/$json"
        }
    }
    object ThirdScreen: Screen("third_screen") {
        fun passTestModel(testModel: TestModel): String {
            val json = Uri.encode(Gson().toJson(testModel))
            return "third_screen/$json"
        }
    }

    companion object {
        const val TEST_MODEL = "test_model"
    }
}