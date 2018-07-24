package by.home.dartlen.myapplication

import com.google.gson.annotations.SerializedName

data class ResponseX(

	@field:SerializedName("needConfirm")
	val needConfirm: Boolean? = null,

	@field:SerializedName("token")
	val token: String? = null
)