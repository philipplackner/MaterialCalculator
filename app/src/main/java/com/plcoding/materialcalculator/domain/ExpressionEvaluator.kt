package com.plcoding.materialcalculator.domain


/**
 * Uses the following grammar
 * expression :	term | term + term | term − term
 * term :		factor | factor * factor | factor / factor | factor % factor
 * factor : 	number | ( expression ) | + factor | − factor
 */
class ExpressionEvaluator(
    private val expression: List<ExpressionPart>
) {

    fun evaluate(): Double {
        return evalExpression(expression).value
    }

    private fun evalExpression(expression: List<ExpressionPart>): ExpressionResult {
        val result = evalTerm(expression)
        var remaining = result.remainingExpression
        var sum = result.value
        while(true) {
            when(remaining.firstOrNull()) {
                ExpressionPart.Op(Operation.ADD) -> {
                    val term = evalTerm(remaining.drop(1))
                    sum += term.value
                    remaining = term.remainingExpression
                }
                ExpressionPart.Op(Operation.SUBTRACT) -> {
                    val term = evalTerm(remaining.drop(1))
                    sum -= term.value
                    remaining = term.remainingExpression
                }
                else -> return ExpressionResult(remaining, sum)
            }
        }
    }

    private fun evalTerm(expression: List<ExpressionPart>): ExpressionResult {
        val result = evalFactor(expression)
        var remaining = result.remainingExpression
        var sum = result.value
        while(true) {
            when(remaining.firstOrNull()) {
                ExpressionPart.Op(Operation.MULTIPLY) -> {
                    val factor = evalFactor(remaining.drop(1))
                    sum *= factor.value
                    remaining = factor.remainingExpression
                }
                ExpressionPart.Op(Operation.DIVIDE) -> {
                    val factor = evalFactor(remaining.drop(1))
                    sum /= factor.value
                    remaining = factor.remainingExpression
                }
                ExpressionPart.Op(Operation.PERCENT) -> {
                    val factor = evalFactor(remaining.drop(1))
                    sum *= (factor.value / 100.0)
                    remaining = factor.remainingExpression
                }
                else -> return ExpressionResult(remaining, sum)
            }
        }
    }

    // A factor is either a number or an expression in parentheses
    // e.g. 5.0, -7.5, -(3+4*5)
    // But NOT something like 3 * 5, 4 + 5
    private fun evalFactor(expression: List<ExpressionPart>): ExpressionResult {
        return when(val part = expression.firstOrNull()) {
            ExpressionPart.Op(Operation.ADD) -> {
                evalFactor(expression.drop(1))
            }
            ExpressionPart.Op(Operation.SUBTRACT) -> {
                evalFactor(expression.drop(1)).run {
                    ExpressionResult(remainingExpression, -value)
                }
            }
            ExpressionPart.Parentheses(ParenthesesType.Opening) -> {
                evalExpression(expression.drop(1)).run {
                    ExpressionResult(remainingExpression.drop(1), value)
                }
            }
            ExpressionPart.Op(Operation.PERCENT) -> evalTerm(expression.drop(1))
            is ExpressionPart.Number -> ExpressionResult(
                remainingExpression = expression.drop(1),
                value = part.number
            )
            else -> throw RuntimeException("Invalid part")
        }
    }

    data class ExpressionResult(
        val remainingExpression: List<ExpressionPart>,
        val value: Double
    )
}