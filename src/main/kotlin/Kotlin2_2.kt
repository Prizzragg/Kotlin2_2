fun main() {
    calculate(10000, cardType = "Mastercard", lastTranslations = 70000)
}

fun calculate(transferAmount: Int, cardType: String = "Мир", lastTranslations: Int = 0) {
    val limitPerDay = 150000
    val monthlyLimit = 600000
    when {
        (transferAmount > limitPerDay) -> println("Превышен лимит по переводу в день!")
        (transferAmount + lastTranslations > monthlyLimit) -> println("Превышен лимит по переводу в месяц!")
        (cardType == "Mastercard") -> {
            val limitMastercard = 75000
            var commission = 0
            when {
                (lastTranslations > limitMastercard) -> commission = (transferAmount * 0.006 + 20).toInt()
                (transferAmount + lastTranslations > limitMastercard) -> commission =
                    ((transferAmount + lastTranslations - limitMastercard) * 0.006 + 20).toInt()
            }
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