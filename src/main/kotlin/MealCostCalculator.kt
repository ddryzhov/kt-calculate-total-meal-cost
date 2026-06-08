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
    val baseCost = 100.0
    val taxRate = 0.1
    val tipPercentage = 0.15
    val discount = 10.0

    val totalMealCost = calculateTotalMealCost(baseCost, taxRate, tipPercentage, discount)
    println("Total meal cost: $$totalMealCost")
}
