package com.seongju.composenavigation.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val BoxRoundShapes = RoundedCornerShape(
    10.dp
)

val ButtonInnerPadding = PaddingValues(
    start = 20.dp,
    top = 10.dp,
    bottom = 10.dp,
    end = 20.dp
)