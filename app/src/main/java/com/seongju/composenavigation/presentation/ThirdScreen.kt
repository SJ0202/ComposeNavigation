package com.seongju.composenavigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seongju.composenavigation.domain.model.TestModel

@Composable
fun ThirdScreen(
    navController: NavHostController,
    testModel: TestModel?,
    activityFinish: () -> Unit
) {

}

@Composable
fun ThirdScreenBody(

) {

}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview(

) {
    val navController = rememberNavController()
}