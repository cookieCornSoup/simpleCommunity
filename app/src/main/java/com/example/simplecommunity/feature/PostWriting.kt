package com.example.simplecommunity.feature


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import com.example.simplecommunity.databinding.ActivityWritingBinding
import com.example.simplecommunity.base.BaseActivity
import jp.wasabeef.richeditor.RichEditor.OnTextChangeListener

lateinit var imageUri: Uri
lateinit var thumbnailUri: Uri
var thumbnaiTrigger = false

class PostWriting : BaseActivity<ActivityWritingBinding>({ ActivityWritingBinding.inflate(it)}){
    val PICK_IMAGE = 1111

    //https://github.com/wasabeef/richeditor-android/blob/master/sample/src/main/java/jp/wasabeef/sample/MainActivity.java
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.editor.setEditorHeight(200)
        binding.editor.setEditorFontSize(22)
        binding.editor.setEditorFontColor(Color.BLACK)

        binding.editor.setPadding(10, 10, 10, 10)
        binding.editor.setPlaceholder("내용을 적어주세요.")

        binding.editor.setOnTextChangeListener(OnTextChangeListener { text -> binding.preview.setText(text) })

        binding.actionUndo.setOnClickListener{binding.editor.undo()}

        binding.actionRedo.setOnClickListener{binding.editor.redo()}

        binding.actionBold.setOnClickListener{binding.editor.setBold()}

        binding.actionItalic.setOnClickListener{binding.editor.setItalic()}

        binding.actionSubscript.setOnClickListener{binding.editor.setSubscript()}

        binding.actionSuperscript.setOnClickListener{binding.editor.setSuperscript()}

        binding.actionStrikethrough.setOnClickListener{binding.editor.setStrikeThrough()}

        binding.actionUnderline.setOnClickListener{binding.editor.setUnderline()}

        binding.actionHeading1.setOnClickListener{binding.editor.setHeading(1)}

        binding.actionHeading2.setOnClickListener{binding.editor.setHeading(2)}

        binding.actionHeading3.setOnClickListener{binding.editor.setHeading(3)}

        binding.actionHeading4.setOnClickListener{binding.editor.setHeading(4)}

        binding.actionHeading5.setOnClickListener{binding.editor.setHeading(5)}

        binding.actionHeading6.setOnClickListener{binding.editor.setHeading(6)}

        binding.actionTxtColor.setOnClickListener{
            var isChanged = false
            binding.editor.setTextColor(if (isChanged) Color.BLACK else Color.RED)
            isChanged = !isChanged
        }

        binding.actionBgColor.setOnClickListener{
            var isChanged = false
            binding.editor.setTextBackgroundColor(if (isChanged) Color.TRANSPARENT else Color.YELLOW)
            isChanged = !isChanged
        }

        binding.actionOutdent.setOnClickListener{binding.editor.setOutdent()}

        binding.actionAlignLeft.setOnClickListener{binding.editor.setAlignLeft()}

        binding.actionAlignCenter.setOnClickListener{binding.editor.setAlignCenter()}

        binding.actionAlignRight.setOnClickListener{binding.editor.setAlignRight()}

        binding.actionInsertBullets.setOnClickListener{binding.editor.setBullets()}

        binding.actionInsertNumbers.setOnClickListener{binding.editor.setNumbers()}

        //이미지 삽입
        binding.actionInsertImage.setOnClickListener{
            thumbnaiTrigger = false
            loadImage()



        }

        //유튜브 삽입
        //binding.actionInsertYoutube.setOnClickListener{binding.editor.insertYoutubeVideo("")}

        //링크 삽입
//        binding.actionInsertLink.setOnClickListener {
//            binding.editor.insertLink("https://github.com/wasabeef", "wasabeef")
//        }

        binding.thumbnailBtn.setOnClickListener{
            thumbnaiTrigger = true
            loadImage()


        }
//        binding.writingDoneBtn.setOnClickListener {
//            Client.retrofitService.feedsCreate(
//                binding.titleEdittext.toString(),
//                thumbnailUri,

//            ).enqueue(object : Callback<FeedsCreateResponse> {
//                @SuppressLint("ShowToast")
//                override fun onResponse(
//                    call: Call<FeedsCreateResponse>?,
//                    response: Response<FeedsCreateResponse>?
//                ) {
//                    when (response!!.code()) {
//                        200 -> {
//
//                        }
//                        405 -> Toast.makeText(
//                            this@PostWriting,
//                            "로그인 실패 : 아이디나 비번이 올바르지 않습니다",
//                            Toast.LENGTH_LONG
//                        ).show()
//                        500 -> Toast.makeText(
//                            this@PostWriting,
//                            "로그인 실패 : 서버 오류",
//                            Toast.LENGTH_LONG
//                        ).show()
//                        401 -> Toast.makeText(
//                            this@PostWriting,
//                            "잘못된 인증자격(리프레시 토큰으로 바꾸기)",
//                            Toast.LENGTH_LONG
//                        )
//                    }
//                }
//
//                override fun onFailure(call: Call<FeedsCreateResponse>, t: Throwable) {
//
//                }
//            })
//
//        }
    }

    fun loadImage() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        val mimeTypes = arrayOf("image/jpeg", "image/png")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        startActivityForResult(intent, PICK_IMAGE)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            if (data == null) {
                return
            }
            val selectedImage: Uri? = data.data
            if (thumbnaiTrigger == true) {
                thumbnailUri = selectedImage!!
                binding.thumbnailImageview.setImageURI(thumbnailUri)
            }else{
                val imageString = selectedImage.toString()
                imageUri = selectedImage!!
                binding.editor.insertImage(imageString,"image")
            }
        }
    }
}