package com.example.mvpsample.login

import com.example.mvpsample.BasePresenter
import com.example.mvpsample.BaseView

interface LoginContract {
    interface View: BaseView<LoginPresenter> {
        fun displayErrorMessage()
        fun displaySuccessMessage()
        fun startMainActivity()
        fun clearErrors()
    }
    interface Presenter: BasePresenter {
        fun isLoginValid(username: String, password: String)
    }
}