package com.plcoding.materialcalculator.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import com.plcoding.materialcalculator.domain.CalculatorAction
import com.plcoding.materialcalculator.domain.Operation

val calculatorActions = listOf(
    CalculatorUiAction(
        text = "AC",
        highlightLevel = HighlightLevel.Highlighted,
        action = CalculatorAction.Clear
    ),
    CalculatorUiAction(
        text = "()",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculatorAction.Parentheses
    ),
    CalculatorUiAction(
        text = "%",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculatorAction.Op(Operation.PERCENT)
    ),
    CalculatorUiAction(
        text = "÷",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculatorAction.Op(Operation.DIVIDE)
    ),
    CalculatorUiAction(
        text = "7",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(7)
    ),
    CalculatorUiAction(
        text = "8",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(8)
    ),
    CalculatorUiAction(
        text = "9",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(9)
    ),
    CalculatorUiAction(
        text = "x",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculatorAction.Op(Operation.MULTIPLY)
    ),
    CalculatorUiAction(
        text = "4",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(4)
    ),
    CalculatorUiAction(
        text = "5",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(5)
    ),
    CalculatorUiAction(
        text = "6",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(6)
    ),
    CalculatorUiAction(
        text = "-",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculatorAction.Op(Operation.SUBTRACT)
    ),
    CalculatorUiAction(
        text = "1",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(1)
    ),
    CalculatorUiAction(
        text = "2",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(2)
    ),
    CalculatorUiAction(
        text = "3",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(3)
    ),
    CalculatorUiAction(
        text = "+",
        highlightLevel = HighlightLevel.SemiHighlighted,
        action = CalculatorAction.Op(Operation.ADD)
    ),
    CalculatorUiAction(
        text = "0",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Number(0)
    ),
    CalculatorUiAction(
        text = ".",
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Decimal
    ),
    CalculatorUiAction(
        text = null,
        content = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        highlightLevel = HighlightLevel.Neutral,
        action = CalculatorAction.Delete
    ),
    CalculatorUiAction(
        text = "=",
        highlightLevel = HighlightLevel.StronglyHighlighted,
        action = CalculatorAction.Calculate
    ),
)