package com.furkancosgun.code

import android.os.Bundle
import android.util.Log
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import com.furkancosgun.code.Model.Code
import com.furkancosgun.code.Rules.LanguageRulesPython
import com.furkancosgun.code.Shell.APIUtil
import com.furkancosgun.code.Shell.CodeDAOInterface
import com.furkancosgun.code.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cdi = APIUtil.sendCodeDAOInterface()
        val languageRules = LanguageRulesPython()
        var colours: Colours = ColoursDark()
        

        val textHighlight = TextHighlight(
            binding.edtCode,
            languageRules,
            colours
        )
        textHighlight.start()

        binding.btnRun.setOnClickListener {
            compileCode(cdi)
            binding.scrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)


        }
    }

    fun compileCode(cdi: CodeDAOInterface) {
        val text = binding.edtCode.text.toString()
        val body = Code(text, "python")

        cdi.sendCode(body).enqueue(object : Callback<Code> {
            override fun onResponse(call: Call<Code>?, response: Response<Code>?) {
                response?.let {
                    Log.d("XFC", "S" + it.body())
                    binding.edtShell.setText(it.body().code)
                }
            }

            override fun onFailure(call: Call<Code>?, t: Throwable?) {
                t?.let {
                    Log.d("XFC", "E" + it.message)
                    binding.edtShell.setText(it.localizedMessage)
                }
            }
        })
    }

}