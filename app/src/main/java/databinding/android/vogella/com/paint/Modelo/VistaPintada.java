package databinding.android.vogella.com.paint.Modelo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import databinding.android.vogella.com.paint.Modelo.Poso.Circle;
import databinding.android.vogella.com.paint.Modelo.Poso.Line;
import databinding.android.vogella.com.paint.Modelo.Poso.Square;

public class VistaPintada extends View {
    private Bitmap mapaDeBits;
    private Canvas canvasFondo;
    private String color = "#B576AD";
    private float xi, yi, xf, yf;
    private float radio;
    private boolean pintando = false;
    private Path rectaPoligonal = new Path();
    private String queEs = "";
    private ArrayList<Object> dibujos = new ArrayList<>();

    public VistaPintada(Context context) {
        super(context);
    }
    public VistaPintada(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void circle(Paint pincel, Canvas canvas){
        pincel.setColor(Color.parseColor(getColor()));
        pincel.setStrokeWidth(10);
        pincel.setStyle(Paint.Style.STROKE);
        if (pintando) {
            canvas.drawCircle(xi, yi, radio, pincel);
        } else {
            Circle circle = new Circle(xi, yi, radio, pincel);
            canvasFondo.drawCircle(xi, yi, radio, pincel);
            dibujos.add(circle);
        }

    }

    private void square(Paint pincel, Canvas canvas){
        pincel.setColor(Color.parseColor(getColor()));
        pincel.setStrokeWidth(10);
        pincel.setStyle(Paint.Style.STROKE);
        if (pintando) {
            canvas.drawRect(xi, yi, xf, yf ,pincel);
        } else {
            Square square = new Square(xi, yi, xf, yf ,pincel);
            canvasFondo.drawRect(xi, yi, xf, yf ,pincel);
            dibujos.add(square);
        }
    }

    private void line(Paint pincel, Canvas canvas){
        pincel.setColor(Color.parseColor(getColor()));
        pincel.setStrokeWidth(10);
        pincel.setStyle(Paint.Style.STROKE);
        if (pintando) {
            canvas.drawLine(xi, yi, xf, yf, pincel);
        } else{
            Line lines = new Line(xi, yi, xf, yf ,pincel);
            dibujos.add(lines);
            canvasFondo.drawLine(xi, yi, xf, yf, pincel);
        }
    }

    public void deleteAll(){
        dibujos.clear();
        if (dibujos.size() == 0){
            canvasFondo.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        }
    }

    public void undo() {
        if (dibujos.size() != 0){
            dibujos.remove(dibujos.size() - 1);
            canvasFondo.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            for (int i = 0; i < dibujos.size(); i++) {
                if (dibujos.get(i).getClass().equals(Circle.class)) {
                    Circle circle = (Circle) dibujos.get(i);
                    Log.v("xyxy", "Circulo" + dibujos.get(i));
                    System.out.println(dibujos.size());
                    canvasFondo.drawCircle(circle.getXi(), circle.getYi(), circle.getRadio(), circle.getPincel());
                }else if(dibujos.get(i).getClass().equals(Square.class)){
                    Square square = (Square) dibujos.get(i);
                    canvasFondo.drawRect(square.getXi(), square.getYi(), square.getXf(), square.getYf(), square.getPincel());
                }else if (dibujos.get(i).getClass().equals(Line.class)){
                    Line line = (Line) dibujos.get(i);
                    canvasFondo.drawLine(line.getXi(), line.getXf(), line.getYi(), line.getYf(), line.getPincel());
                }
            }
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincel = new Paint();
        canvas.drawBitmap(mapaDeBits, 0, 0, null);
        switch (queEs){
            case "circle":
                circle(pincel, canvas);
                break;
            case "square":
                square(pincel, canvas);
                break;
            case "line":
                line(pincel, canvas);
                break;
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mapaDeBits = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvasFondo = new Canvas(mapaDeBits);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v("TAG", "onTouchEvent");
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // Pulsar el dedo
                pintando = true;
                xf = xi = x;
                yf = yi = y;
                //rectaPoligonal.reset();
                //rectaPoligonal.moveTo(xi, yi);
                break;
            case MotionEvent.ACTION_MOVE: // Mover el dedo
                //xi = xf;
                //yi = yf;
                xf = x;
                yf = y;
                //rectaPoligonal.quadTo(xi, yi, (x + xi) / 2, (y + yi) / 2);
                break;
            case MotionEvent.ACTION_UP: // Quitar el dedo
                pintando = false;
                //i = xf;
                //yi = yf;
                xf = x;
                yf = y;
                break;
        }
        radio = (float) Math.sqrt(Math.pow(xf - xi, 2) + Math.pow(yf - yi, 2));

        invalidate(); // Le dices a la vista que se tiene que redibujar
        return true;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setQueEs(String queEs) {
        this.queEs = queEs;
    }

    public String getColor() {
        return color;
    }
}
