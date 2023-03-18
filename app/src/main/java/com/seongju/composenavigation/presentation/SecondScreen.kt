package com.seongju.composenavigation.presentation

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.seongju.composenavigation.domain.model.TestModel
import com.seongju.composenavigation.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    navController: NavHostController,
    testModel: TestModel?
) {
    val localContext = LocalContext.current
    val waitTime = remember { mutableStateOf<Long>(0L) }

    BackHandler(enabled = true) {
        if (System.currentTimeMillis() - waitTime.value >= 1500) {
            waitTime.value = System.currentTimeMillis()
            Toast.makeText(localContext, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            navController.popBackStack(
                route = Screen.FirstScreen.route,
                inclusive = false
            )
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Second")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack(
                                route = Screen.FirstScreen.route,
                                inclusive = false
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            if (testModel != null) {
                SecondScreenBody(
                    testModel = testModel
                )
            } else {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun SecondScreenBody(
    testModel: TestModel
) {

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview(

) {
    val navController = rememberNavController()
    val testModel = TestModel(
        id = 1,
        name = "아무개",
        age = 25
    )

    SecondScreen(
        navController = navController,
        testModel = testModel
    )
}