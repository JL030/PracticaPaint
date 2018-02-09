package databinding.android.vogella.com.paint.Modelo.Poso;

import android.graphics.Paint;

/**
 * Created by javierlopezgirela on 9/2/18.
 */

public class Circle extends Object{

    private float xi, yi, radio;
    private Paint pincel;

    public Circle() {
    }

    public Circle(float xi, float yi, float radio, Paint pincel) {
        this.xi = xi;
        this.yi = yi;
        this.radio = radio;
        this.pincel = pincel;
    }

    public float getXi() {
        return xi;
    }

    public void setXi(float xi) {
        this.xi = xi;
    }

    public float getYi() {
        return yi;
    }

    public void setYi(float yi) {
        this.yi = yi;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public Paint getPincel() {
        return pincel;
    }

    public void setPincel(Paint pincel) {
        this.pincel = pincel;
    }
}
