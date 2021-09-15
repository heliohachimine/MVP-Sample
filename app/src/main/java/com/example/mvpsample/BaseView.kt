package com.example.mvpsample

interface BaseView<T> {
    var presenter: T
    fun bindViews()
}