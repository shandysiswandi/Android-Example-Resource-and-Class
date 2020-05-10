import com.squareup.moshi.Json

data class User(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "avatar") val avatar: String
)