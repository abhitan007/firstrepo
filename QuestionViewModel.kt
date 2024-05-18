package com.example.tiptime.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiptime.model.SubData
import com.example.tiptime.network.ApiService
import kotlinx.coroutines.launch

class QuestionViewModel : ViewModel() {

    private var _questionListResponse = MutableLiveData<List<SubData>>()
    val questionListResponse: LiveData<List<SubData>> = _questionListResponse

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun getQuestionList(type: Int, difficulty: String) {
        viewModelScope.launch {
            try {
                val questionResponse = ApiService.getInstance().getQuestions(type, difficulty)
                if (questionResponse.response_code == 0) {
                    _questionListResponse.postValue(questionResponse.results)
                } else {
                    _errorMessage.postValue("Failed to fetch questions")
                }
            } catch (e: Exception) {
                _errorMessage.postValue(e.message ?: "Unknown error occurred")
            }
        }
    }
}