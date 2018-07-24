package by.home.dartlen.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val client = OkHttpClient().newBuilder()
                //.cache(cache)
                //.addInterceptor(apiKey,cacheDuration)
                .addInterceptor(AuthHeaderInterceptor())
                .build()*/

        val retrofit = Retrofit.Builder()
                .baseUrl("http://fotcher-temp.balinasoft.com/")
                .client(OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val Service = retrofit.create(apiswagger::class.java)

        val call = Service.Signin(LoginData("dartlen@tut.by","12345678"))
                .enqueue(object : retrofit2.Callback<ResponseX> {
                    override fun onFailure(call: retrofit2.Call<ResponseX>?, t: Throwable) {
                        Log.d("das", t.message)
                    }

                    override fun onResponse(call: retrofit2.Call<ResponseX>?,
                                            response: Response<ResponseX>) {
                        if (response.isSuccessful) {

                        }

                    }
                })

    }
}
