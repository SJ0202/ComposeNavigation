package com.seongju.composenavigation.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.seongju.composenavigation.ui.theme.BoxRoundShapes
import com.seongju.composenavigation.ui.theme.SkyBlue
import com.seongju.composenavigation.ui.theme.SpaceDefault
import com.seongju.composenavigation.ui.theme.SpaceSmall

@Composable
fun StandardButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = SkyBlue,
                disabledContentColor = Color.White,
                contentColor = Color.White
            ),
            shape = BoxRoundShapes,
            enabled = enabled
        ) {
            Text(
                text = buttonText,
                modifier = Modifier
                    .padding(vertical = SpaceSmall)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StandardButtonPreview(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceDefault)
    ) {
        StandardButton(
            buttonText = "테스트"
        ) {

        }
    }
}