fun String.isValidPhoneNumber(): Boolean {
    return Regex("\\+\\d{12}").matches(this)
}

fun Double.toDh(): String {
    return "$this dhs"
}
