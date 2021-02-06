package com.reactive.learning.model

data class CoinBaseResponse(var data: Data) {

    data class Data(var base:String, var currency: String, var amount: String)
}
