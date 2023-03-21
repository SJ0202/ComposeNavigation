package com.seongju.composenavigation.presentation.util

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seongju.composenavigation.domain.model.TestModel
import com.seongju.composenavigation.presentation.FirstScreen
import com.seongju.composenavigation.presentation.SecondScreen
import com.seongju.composenavigation.presentation.ThirdScreen
import com.seongju.composenavigation.presentation.util.Screen.Companion.TEST_MODEL
import com.seongju.composenavigation.presentation.util.navType.TestModelType

@Composable
fun Navigation(
    activityFinish: () -> Unit
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(
            route = Screen.FirstScreen.route
        ) {
            FirstScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.SecondScreen.route + "/{$TEST_MODEL}",
            arguments = listOf(
                navArgument(
                    name = TEST_MODEL
                ) {
                    type = TestModelType()
                }
            )
        ) {
            val testModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.arguments?.getParcelable(
                    TEST_MODEL,
                    TestModel::class.java
                )
            } else {
                it.arguments?.getParcelable(
                    TEST_MODEL
                )
            }

            SecondScreen(
                navController = navController,
                testModel = testModel,
                activityFinish = activityFinish
            )
        }
        composable(
            route = Screen.ThirdScreen.route + "/{$TEST_MODEL}",
            arguments = listOf(
                navArgument(
                    name = TEST_MODEL
                ) {
                    type = TestModelType()
                }
            )
        ) {
            val testModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.arguments?.getParcelable(
                    TEST_MODEL,
                    TestModel::class.java
                )
            } else {
                it.arguments?.getParcelable(
                    TEST_MODEL
                )
            }

            ThirdScreen(
                navController = navController,
                testModel = testModel
            )
        }
    }
}