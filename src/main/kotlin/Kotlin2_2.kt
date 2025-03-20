fun main() {
    calculate(200, cardType = "Visa")
}

fun calculate(transferAmount: Int, cardType: String = "Мир", lastTranslations: Int = 0) {
    val limitPerDay = 150000
    val monthlyLimit = 600000
    when {
        (transferAmount > limitPerDay) -> println("Превышен лимит по переводу в день!")
        (transferAmount + lastTranslations > monthlyLimit) -> println("Превышен лимит по переводу в месяц!")
        (cardType == "Mastercard") -> {
            val limitMastercard = 75000
            val commission = (if (transferAmount > 75000) transferAmount * 0.006 + 20 else 0).toInt()
            println("Для суммы перевода $transferAmount руб. комиссия составит $commission руб.")
        }

        (cardType == "Visa") -> {
            val minCommission = 35
            val commission =
                (if (transferAmount * 0.0075 < minCommission) minCommission else transferAmount * 0.0075).toInt()
            println("Для суммы перевода $transferAmount руб. комиссия составит $commission руб.")
        }

        (cardType == "Мир") -> println("Для карты типа Мир комиссия не взымается. Сумма перевода $transferAmount руб.")
        else -> println("Карты такого типа не поддерживаются!")
    }
}