package databinding.android.vogella.com.paint.Modelo.Poso;

import android.graphics.Paint;

/**
 * Created by javierlopezgirela on 9/2/18.
 */

public class Square {

    private Float xi, yi, xf, yf;
    private Paint pincel;

    public Square(Float xi, Float yi, Float xf, Float yf, Paint pincel) {
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.pincel = pincel;
    }

    public Float getXi() {
        return xi;
    }

    public void setXi(Float xi) {
        this.xi = xi;
    }

    public Float getYi() {
        return yi;
    }

    public void setYi(Float yi) {
        this.yi = yi;
    }

    public Float getXf() {
        return xf;
    }

    public void setXf(Float xf) {
        this.xf = xf;
    }

    public Float getYf() {
        return yf;
    }

    public void setYf(Float yf) {
        this.yf = yf;
    }

    public Paint getPincel() {
        return pincel;
    }

    public void setPincel(Paint pincel) {
        this.pincel = pincel;
    }
}
