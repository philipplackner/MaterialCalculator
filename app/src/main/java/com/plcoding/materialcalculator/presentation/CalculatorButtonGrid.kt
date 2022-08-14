package com.plcoding.materialcalculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.materialcalculator.domain.CalculatorAction

@Composable
fun CalculatorButtonGrid(
    actions: List<CalculatorUiAction>,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        content = {
            items(actions) { action ->
                CalculatorButton(
                    action = action,
                    modifier = Modifier.aspectRatio(1f),
                    onClick = { onAction(action.action) }
                )
            }
        }
    )
}