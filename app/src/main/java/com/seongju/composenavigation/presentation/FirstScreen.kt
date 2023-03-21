package com.seongju.composenavigation.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.seongju.composenavigation.domain.model.TestModel
import com.seongju.composenavigation.presentation.components.StandardButton
import com.seongju.composenavigation.presentation.components.StandardTextField
import com.seongju.composenavigation.presentation.util.Screen
import com.seongju.composenavigation.presentation.util.makeNumberOnly
import com.seongju.composenavigation.ui.theme.SpaceDefault

@Composable
fun FirstScreen(
    navController: NavController
) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                FirstScreenBody(
                    navController = navController
                )
            }
        }
    )
}

@Composable
fun FirstScreenBody(
    navController: NavController
) {
    val localContext: Context = LocalContext.current

    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceDefault)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StandardTextField(
                value = name.value,
                hint = "이름",
                onValueChange = {
                    name.value = it
                }
            )
            Spacer(
                modifier = Modifier
                    .height(SpaceDefault)
            )
            StandardTextField(
                value = age.value,
                hint = "나이",
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
                onValueChange = {
                    age.value = makeNumberOnly(it)
                }
            )
        }
        StandardButton(
            buttonText = "다음"
        ) {
            if (name.value == "" || age.value == "") {
                Toast.makeText(localContext, "입력값을 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val testModel = TestModel(
                    id = 0,
                    name = name.value,
                    age = age.value.toInt()
                )

                navController.navigate(
                    Screen.SecondScreen.passTestModel(
                        testModel = testModel
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview(

) {
    val navController = rememberNavController()

    FirstScreen(
        navController = navController
    )
}