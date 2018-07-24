package by.home.dartlen.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST



interface apiswagger {
    @Headers("Content-Type: application/json")
    @POST("/api/v1/account/signin")
    fun Signin(@Body data: LoginData): Call<ResponseX>
}