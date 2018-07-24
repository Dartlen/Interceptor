package by.home.dartlen.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LoginData(@field:SerializedName("email")
                @field:Expose
                var login: String?, @field:SerializedName("password")
                @field:Expose
                var password: String?)