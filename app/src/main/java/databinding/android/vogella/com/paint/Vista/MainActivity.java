package databinding.android.vogella.com.paint.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import databinding.android.vogella.com.paint.R;
import databinding.android.vogella.com.paint.Modelo.VistaPintada;

public class MainActivity extends AppCompatActivity {

    private VistaPintada vistaPintada;

    private void init(){
        Toast.makeText(getBaseContext(), "Seleccione color y tipo de figura que desee dibujar", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Button change = findViewById(R.id.changeColor);
        Button circle = findViewById(R.id.circle);
        Button square = findViewById(R.id.square);
        Button line = findViewById(R.id.Line);
        Button purple = findViewById(R.id.purple);
        Button deleteAll = findViewById(R.id.deleteAll);
        Button undo = findViewById(R.id.undo);
        vistaPintada = findViewById(R.id.view2);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ha seleccionado el color rojo", Toast.LENGTH_SHORT).show();
                vistaPintada.setColor("#FF0000");
            }
        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ha seleccionado el circulo", Toast.LENGTH_SHORT).show();
                vistaPintada.setQueEs("circle");
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ha seleccionado el cuadrado", Toast.LENGTH_SHORT).show();
                vistaPintada.setQueEs("square");
            }
        });
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ha seleccionado la linea", Toast.LENGTH_SHORT).show();
                vistaPintada.setQueEs("line");
            }
        });
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ha seleccionado el color violeta", Toast.LENGTH_SHORT).show();
                vistaPintada.setColor("#B576AD");
            }
        });
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "BORRADO", Toast.LENGTH_SHORT).show();
                vistaPintada.deleteAll();
            }
        });
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vistaPintada.undo();
            }
        });
    }
}
