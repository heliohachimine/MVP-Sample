package com.example.mvpsample.login

import com.example.mvpsample.AuthUtils

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun start() {
        view.bindViews()
    }

    override fun isLoginValid(username: String, password: String) {
        if (username.isEmpty() or password.isEmpty()) {
            view.displayErrorMessage()
        } else {
            if ((password == AuthUtils.PASSWORD) and (username == AuthUtils.USERNAME)) {
                view.displaySuccessMessage()
                view.startMainActivity()
            } else {
                view.displayErrorMessage()
            }
        }
    }
}