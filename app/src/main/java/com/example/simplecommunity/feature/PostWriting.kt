package com.example.simplecommunity.feature


import android.graphics.Color
import android.os.Bundle
import com.example.simplecommunity.databinding.ActivityWritingBinding
import com.example.simplecommunity.feature.singup.BaseActivity
import jp.wasabeef.richeditor.RichEditor.OnTextChangeListener


class PostWriting : BaseActivity<ActivityWritingBinding>({ ActivityWritingBinding.inflate(it)}){

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
        //binding.actionInsertImage.setOnClickListener{binding.editor.insertImage()}

        //유튜브 삽입
        //binding.actionInsertYoutube.setOnClickListener{binding.editor.insertYoutubeVideo("")}

        //링크 삽입
//        binding.actionInsertLink.setOnClickListener {
//            binding.editor.insertLink("https://github.com/wasabeef", "wasabeef")
//        }

    }
}