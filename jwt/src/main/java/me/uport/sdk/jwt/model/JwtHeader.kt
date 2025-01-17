@file:Suppress("EXPERIMENTAL_API_USAGE")

package me.uport.sdk.jwt.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

/**
 * Standard JWT header
 */
@Serializable
class JwtHeader(
    val typ: String = "JWT",

    val alg: String = ES256K
) {

    fun toJson(): String = jsonAdapter.stringify(serializer(), this)

    companion object {
        const val ES256K = "ES256K"
        const val ES256K_R = "ES256K-R"

        fun fromJson(headerString: String): JwtHeader =
            jsonAdapter.parse(serializer(), headerString)

        private val jsonAdapter = Json(JsonConfiguration(strictMode = false))
    }
}
