package ir.ah.newsapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.ah.newsapp.other.*

import retrofit2.Response

abstract class BaseViewModel : ViewModel() {


    fun <T> handleResponse(response: Response<T>, data: MutableLiveData<Resource<T>>) {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                data.postValue(Resource.Success(resultResponse))
            }
        } else {
            data.postValue(Resource.Error(response.message(), null, response.code()))
        }
    }


}