package informatico.to.drawgeometricasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
    }
    class Lienzo extends View {
        public Lienzo(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            //Obetenemos el ancho y el alto de la vista
            int x = getWidth();
            int y = getHeight();
            //creamos una variable para el radio del circulo
            int radius;
            //instanciamos a la variable radio
            radius = 100;
            //creamos un objeto de la clase paint y lo guardamos en una variable
            Paint paint = new Paint();
            //Indicamos el tipo de trazo de paint
            paint.setStyle(Paint.Style.FILL);
            //indicamos el fondo de la vista
            paint.setColor(Color.parseColor("#5F6A6A"));
            //pintamos el fondo
            canvas.drawPaint(paint);
            //Circulo
            paint.setColor(Color.parseColor("#B7950B"));
            canvas.drawCircle(x / 2, 140, radius, paint);
            //Rectangulo
            paint.setColor(Color.parseColor("#1F618D"));
            canvas.drawRect((x/2)-200,280,(y/2),400,paint);
            //Cuadrado
            paint.setColor(Color.parseColor("#F7F9F9"));
            canvas.drawRect((x/2)-200,440,(y/2),700,paint);
            //Triangulo
            Path path = new Path();
            path.moveTo(x/2, y/2 - 50);
            path.lineTo(x/2 - 200, y/2 + 180);
            path.lineTo(800, y/2 + 180);
            paint.setStyle(Paint.Style.FILL); // el tipo de trazado
            // convertimos un color Hexa en un android.graphics.Color
            paint.setColor(Color.parseColor("#C0392B"));
            // pintamos un triangulo
            canvas.drawPath(path, paint);
            //Poligono
            //Dibujo con Shadeintsnaciamos a SweepGradient
            //Realizamos un arreglo de colores
            int[] colors = {Color.RED, Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK};
            //indicamos a shader cx,cy,lista de colores,posicion
            Shader shader = new SweepGradient(x/2, (y/2)+260,colors, null);
            //indicamos que paint guarde a shade
            paint.setShader(shader);
            canvas.drawOval((x/2)-200,1000,(y/2),1200,paint);
            // pintar una linea
            canvas.drawLine(100, 30, 1000, 30, paint);
            paint.setStrokeWidth(10);   } }
}