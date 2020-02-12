package com.smarttersstudio.prodialoglibrary

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.view_pro_dialog.*


class ProDialog : Dialog {
  private var activity: Context
  private var okClickListener: View.OnClickListener? = null
  private var cancelClickListener: View.OnClickListener? = null

  constructor(context: Context) : super(context) {
    activity = context
    setCanceledOnTouchOutside(true)
    setCancelable(true)
    create()
  }

  constructor(context: AppCompatActivity, cancelable: Boolean, oKClickListener: View.OnClickListener?) : super(context) {
    activity = context
    okClickListener = oKClickListener
    setCanceledOnTouchOutside(cancelable)
    setCancelable(cancelable)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    setContentView(R.layout.view_pro_dialog)
    window!!.attributes.windowAnimations = R.style.popAnimation
    window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    showProgress(false)
    cancelButton.setOnClickListener { v: View? ->
      if (cancelClickListener != null) {
        cancelClickListener?.onClick(v)
      } else {
        dismiss()
      }
    }
    okButton.setOnClickListener { v: View? ->
      if (okClickListener != null) {
        okClickListener?.onClick(v)
      } else {
        dismiss()
      }
    }
  }
  fun setIsCancelable(cancelable: Boolean):ProDialog{
    setCancelable(cancelable)
    return this
  }

  fun setHeading(resId: Int):ProDialog {
    dialogMessage.setText(resId)
    return this
  }
  fun setHeading(text: String):ProDialog {
    dialogMessage.text = text
    return this
  }
  fun setMessage(resId: Int) :ProDialog{
    dialogMessage.setText(resId)
    return this
  }

  fun setMessage(message: String?):ProDialog {
    dialogMessage.text = message
    return  this
  }

  fun setCancelButtonText(text: String?):ProDialog {
    cancelButton.text = text
    return this
  }

  fun setOkButtonText(text: String?):ProDialog {
    okButton.text = text
    return this
  }

  fun setPositiveButton(text:String,okClickListener: View.OnClickListener?) :ProDialog{
    okButton.text=text
    this.okClickListener = okClickListener
    return this
  }

  fun setNegativeButton(text:String,cancelClickListener: View.OnClickListener?):ProDialog{
    cancelButton.text=text
    this.cancelClickListener = cancelClickListener
    return this
  }
  fun getPositiveButton():MaterialButton{
    return okButton
  }
  fun getNegativeButton():MaterialButton{
    return cancelButton
  }
  fun getTitleText():TextView{
    return dialogTitle
  }
  fun getMessageText():TextView{
    return dialogMessage
  }
  fun getProgressBar():ProgressBar{
    return progressBar
  }
  fun setAnimation(animation:ProAnimation):ProDialog{
    when(animation){
      ProAnimation.LEFT_RIGHT->window!!.attributes.windowAnimations = R.style.leftRightAnimation
      ProAnimation.RIGHT_LEFT->window!!.attributes.windowAnimations = R.style.rightLeftAnimation
      ProAnimation.UP_DOWN->window!!.attributes.windowAnimations = R.style.upDownAnimation
      ProAnimation.DOWN_UP->window!!.attributes.windowAnimations = R.style.downUpAnimation
      ProAnimation.FADE->window!!.attributes.windowAnimations = R.style.fadeAnimation
      ProAnimation.POP_UP->window!!.attributes.windowAnimations = R.style.popAnimation
    }
    return  this
  }

  fun showProgress(b: Boolean):ProDialog {
    if (b) {
      progressBar.visibility = View.VISIBLE
      dialogContent.visibility = View.INVISIBLE
    } else {
      progressBar.visibility = View.INVISIBLE
      dialogContent.visibility = View.VISIBLE
    }
    return this
  }
  enum class ProAnimation{
    LEFT_RIGHT,RIGHT_LEFT,UP_DOWN,DOWN_UP,FADE,POP_UP
  }
  companion object{
    @JvmStatic
    fun getInstance(context: AppCompatActivity):ProDialog{
      return ProDialog(context)
    }
  }
}

