package com.plcoding.materialcalculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ExpressionWriterTest {

    private lateinit var writer: ExpressionWriter

    @Before
    fun setUp() {
        writer = ExpressionWriter()
    }

    @Test
    fun `Initial parentheses parsed`() {
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Number(5))
        writer.processAction(CalculatorAction.Op(Operation.ADD))
        writer.processAction(CalculatorAction.Number(4))
        writer.processAction(CalculatorAction.Parentheses)

        assertThat(writer.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `Closing parentheses at the start not parsed`() {
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Parentheses)

        assertThat(writer.expression).isEqualTo("((")
    }

    @Test
    fun `Parentheses around a number are parsed`() {
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Number(6))
        writer.processAction(CalculatorAction.Parentheses)

        assertThat(writer.expression).isEqualTo("(6)")
    }
}