package com.lon.taskhub.login

import android.content.Context
import com.lon.bas.BaseDialog
import com.lon.taskhub.BR
import com.lon.taskhub.R
import com.lon.taskhub.databinding.DialogLoginBinding

class LoginDialog(context: Context) : BaseDialog<DialogLoginBinding, LoginViewModel>(context) {
    override fun getLayoutId(): Int = R.layout.dialog_login

    override fun getViewModelId(): Int =BR.login

}