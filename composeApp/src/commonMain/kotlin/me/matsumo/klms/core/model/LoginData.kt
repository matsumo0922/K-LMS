package me.matsumo.klms.core.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginData(
    val email: String,
    val password: String,
    val token: String,
) {
    companion object {
        fun default(): LoginData {
            return LoginData(
                email = "",
                password = "",
                token = "",
            )
        }
    }
}
