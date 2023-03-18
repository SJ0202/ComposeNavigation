package com.seongju.composenavigation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seongju.composenavigation.domain.model.TestModel

@Composable
fun SecondScreen(
    navController: NavHostController,
    testModel: TestModel?
) {

}

@Composable
fun SecondScreenBody(

) {

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview(

) {
    val navController = rememberNavController()
}