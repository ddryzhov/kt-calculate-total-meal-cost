const val DEFAULT_BASE_COST = 100.0
const val STANDARD_TAX_RATE = 0.1
const val PREFERRED_TIP_PERCENTAGE = 0.15
const val SPECIAL_DISCOUNT = 10.0

fun calculateTotalMealCost(
    baseCost: Double,
    taxRate: Double,
    tipPercentage: Double,
    discount: Double = 0.0
): Double {
    fun applyTax(cost: Double): Double {
        return cost + (cost * taxRate)
    }

    fun applyTip(costWithTax: Double): Double {
        return costWithTax + (costWithTax * tipPercentage)
    }

    fun applyDiscount(finalCost: Double): Double {
        return if (discount > 0.0) {
            finalCost - discount
        } else {
            finalCost
        }
    }

    val costWithTax = applyTax(baseCost)
    val costWithTip = applyTip(costWithTax)
    val finalTotal = applyDiscount(costWithTip)

    return finalTotal
}

fun main() {
    val totalMealCost = calculateTotalMealCost(
        baseCost = DEFAULT_BASE_COST,
        taxRate = STANDARD_TAX_RATE,
        tipPercentage = PREFERRED_TIP_PERCENTAGE,
        discount = SPECIAL_DISCOUNT
    )
    println("Total meal cost: $$totalMealCost")
}
