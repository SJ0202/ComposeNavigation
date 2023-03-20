package com.seongju.composenavigation.presentation

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.seongju.composenavigation.domain.model.TestModel
import com.seongju.composenavigation.presentation.util.Screen
import com.seongju.composenavigation.ui.theme.SpaceDefault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(
    navController: NavController,
    testModel: TestModel?
) {
    val localContext = LocalContext.current
    val waitTime = remember { mutableStateOf<Long>(0L) }

    BackHandler(enabled = true) {
        if (System.currentTimeMillis() - waitTime.value >= 1500) {
            waitTime.value = System.currentTimeMillis()
            Toast.makeText(localContext, "뒤로가기 버튼을 한번 더 누르면 첫번째 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
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
                    Text(text = "Third")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (System.currentTimeMillis() - waitTime.value >= 1500) {
                                waitTime.value = System.currentTimeMillis()
                                Toast.makeText(localContext, "뒤로가기 버튼을 한번 더 누르면 첫번째 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
                            } else {
                                navController.popBackStack(
                                    route = Screen.FirstScreen.route,
                                    inclusive = false
                                )
                            }
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
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center
            ) {
                if (testModel != null) {
                    ThirdScreenBody(
                        testModel = testModel
                    )
                } else {
                    CircularProgressIndicator()
                }
            }
        }
    )
}

@Composable
fun ThirdScreenBody(
    testModel: TestModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceDefault),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "이름: ${testModel.name}",
            fontSize = 24.sp
        )
        Spacer(
            modifier = Modifier
                .height(SpaceDefault)
        )
        Text(
            text = "나이: ${testModel.age}",
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview(

) {
    val navController = rememberNavController()
    val testModel = TestModel(
        id = 1,
        name = "아무개",
        age = 25
    )

    ThirdScreen(
        navController = navController,
        testModel = testModel
    )
}