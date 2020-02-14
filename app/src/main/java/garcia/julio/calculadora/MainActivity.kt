package garcia.julio.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ant: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{
            type(btn_0)
        }

        btn_1.setOnClickListener{
            type(btn_1)
        }

        btn_2.setOnClickListener{
            type(btn_2)
        }

        btn_3.setOnClickListener{
            type(btn_3)
        }

        btn_4.setOnClickListener{
            type(btn_4)
        }

        btn_5.setOnClickListener{
            type(btn_5)
        }

        btn_6.setOnClickListener{
            type(btn_6)
        }

        btn_7.setOnClickListener{
            type(btn_7)
        }

        btn_8.setOnClickListener{
            type(btn_8)
        }

        btn_9.setOnClickListener{
            type(btn_9)
        }

        btn_sum.setOnClickListener{
            typeOp(btn_sum)
        }

        btn_res.setOnClickListener{
            typeOp(btn_res)
        }

        btn_mul.setOnClickListener{
            typeOp(btn_mul)
        }

        btn_div.setOnClickListener{
            typeOp(btn_div)
        }

        btn_eq.setOnClickListener{
            equal()
        }

        btn_del.setOnClickListener{
            del()
        }
    }


    fun type(btn: Button){
        tv_input.append(btn.text)
    }

    fun del(){
        tv_input.setText("")
        tv_op.setText("")
        tv_resultado.setText("")
    }

    fun typeOp(btn: Button){
        try {
            ant = tv_input.text.toString().toDouble()
            tv_op.setText(btn.text)
        }catch (e: Exception){
            Toast.makeText(applicationContext, "No hay números!", Toast.LENGTH_LONG).show()
        }

        tv_resultado.setText(tv_input.text)
        tv_input.setText("")
    }

    fun equal(){
        eval(ant, tv_input.text.toString().toDouble(), tv_op.text.toString().get(0))
        tv_input.setText("")
    }

    fun eval(num1: Double, num2: Double, op: Char){
        when(op){
            '+' -> {
                var res= num1+num2
                tv_input.setText("")
                tv_op.setText("")
                tv_resultado.setText("$res")
            }
            '-'->{
                var res= num1-num2
                tv_input.setText("")
                tv_op.setText("")
                tv_resultado.setText("$res")
            }
            '*'->{
                var res= num1*num2
                tv_input.setText("")
                tv_op.setText("")
                tv_resultado.setText("$res")
            }
            '/'->{
                if(num2!=0.0){
                var res= num1/num2
                tv_resultado.setText("$res")
                }else{
                    Toast.makeText(applicationContext, "El segundo num. no puede ser 0", Toast.LENGTH_LONG).show()
                    tv_input.setText("")
                    tv_op.setText("")
                    tv_resultado.setText("")
                }
            }
            else -> Toast.makeText(applicationContext, "WTF?", Toast.LENGTH_LONG).show()
        }
    }
}
