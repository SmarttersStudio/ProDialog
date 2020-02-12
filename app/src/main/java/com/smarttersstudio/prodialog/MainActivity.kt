package com.smarttersstudio.prodialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.smarttersstudio.prodialoglibrary.ProDialog

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  fun simpleDialog(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .show()
  }
  fun withAction(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setPositiveButton("yes", View.OnClickListener {
        Toast.makeText(this,"Yes clicked",Toast.LENGTH_SHORT).show()
      }).setNegativeButton("no", View.OnClickListener {
        Toast.makeText(this,"No clicked",Toast.LENGTH_SHORT).show()
      })
      .show()
  }
  fun withProgress(view: View) {
    ProDialog(this)
      .showProgress(true)
      .show()
  }
  fun buttonTextChanged(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setOkButtonText("Anything 1")
      .setCancelButtonText("Anything 2")
      .show()
  }
  fun popupAnimation(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setAnimation(ProDialog.ProAnimation.POP_UP)
      .show()
  }
  fun fadeAnimation(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setAnimation(ProDialog.ProAnimation.FADE)
      .show()
  }
  fun rightLeftAnimation(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setAnimation(ProDialog.ProAnimation.RIGHT_LEFT)
      .show()
  }
  fun leftRightAnimation(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setAnimation(ProDialog.ProAnimation.LEFT_RIGHT)
      .show()
  }
  fun upDownAnimation(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setAnimation(ProDialog.ProAnimation.UP_DOWN)
      .show()
  }
  fun downUpAnimation(view: View) {
    ProDialog(this)
      .setHeading("Are you sure")
      .setMessage("Do you really want to do the task ?")
      .setAnimation(ProDialog.ProAnimation.DOWN_UP)
      .show()
  }
}
