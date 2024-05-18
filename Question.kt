package com.example.tiptime.model

data class Question(
    val response_code:Int,
    val results: List<SubData>,

    )


data class SubData(
    val category:String,
    val type:String,
    val difficulty:String,
    val question:String,
    val correct_answer:String,
    val incorrect_answers:List<String>,
)

