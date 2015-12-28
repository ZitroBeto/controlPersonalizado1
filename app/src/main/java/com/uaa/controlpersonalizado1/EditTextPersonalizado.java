package com.uaa.controlpersonalizado1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Robert on 28/09/2015.
 */
public class EditTextPersonalizado extends EditText {

    //para generar un control a partir de uno ya existente el control del cual esta basado

    private Paint p1;
    private Paint p2;

    private float densidad;

    //constructores utilizados

    public EditTextPersonalizado(Context context){
        super(context);
        init();
    }

    public EditTextPersonalizado(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public EditTextPersonalizado(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    //aqui inicializamos configuracion de nuestros pinceles y densidad de la pantalla
    private void init(){
        this.p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.p1.setColor(Color.BLACK);
        this.p1.setStyle(Paint.Style.FILL);

        this.p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.p1.setColor(Color.WHITE);
        //this.p1.setStyle(Paint.Style.FILL);

        this.densidad = getResources().getDisplayMetrics().density;
    }

    //este metodo se manda llamar automaticamente para pintar el control en la pantalla recibe de parámetros un objeto canvas
    @Override
    public void onDraw(Canvas canvas){
        //dibujamos el fondo negro del contador dibujando un rectangulo
        //utilizando el metodo  drawRect que recibe de parametro coordenadas relativas al tamanño de nuestro
        //control (float left, float top, float right, float bottom), Paint paint)
        float izquierda = this.getWidth() - 30* this.densidad,
                arriba = 5 * this.densidad,
                derecha = this.getWidth() - 5 * this.densidad,
                abajo = 20 * this.densidad;
        canvas.drawRect(izquierda, arriba, derecha, abajo, p1);

        //como dibujaremos texto debemos especificar sobre el contador utilizando el metodo draw text,
        //tambien utilia las coordenadas relativas de nuestro control, note que se multiplica por la densidad
        //de pantalla ya que estos valores estan dados en pixeles
        int tamanoTexto = this.getText().toString().length();
        float x = this.getWidth() -28*this.densidad,
                y = 17 *this.densidad;
        canvas.drawText(String.valueOf(tamanoTexto),x,y, p2);

    }
}
