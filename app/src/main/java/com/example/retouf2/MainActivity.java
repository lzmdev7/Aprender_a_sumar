package com.example.retouf2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected Button boton1;
    protected Button boton2;
    protected Button boton3;
    private int[] numeros = new int[5];
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label1 = (TextView) findViewById(R.id.label1_start);
        label2 = (TextView) findViewById(R.id.label2_start);
        boton1 = (Button) findViewById(R.id.boton1_start);
        boton2 = (Button) findViewById(R.id.boton2_start);
        boton3 = (Button) findViewById(R.id.boton3_start);

        numeros[0] = (int) (Math.random() * 10);
        numeros[1] = (int) (Math.random() * 10);
        numeros[2] = (int) (Math.random() * 3 + 1);
        numeros[3] = (int) (Math.random() * 15 + 1);
        numeros[4] = (int) (Math.random() * 15 + 1);

        //para que la app nos siga sacando sumas una detrás de otra
        while (numeros[3] == numeros[0] + numeros[1] || numeros[4] == numeros[0] + numeros[1] || numeros[3] == numeros[4]) {
            numeros[3] = (int) (Math.random() * 15 + 1);
            numeros[4] = (int) (Math.random() * 15 + 1);
        }
        //aqui asigno al label la suma que se va a realizar
        label2.setText(numeros[0] + " + " + numeros[1]);

        //asignamos el resultado de nuestra suma a uno de los botones
        if (numeros[2] == 1) {
            boton1.setText(Integer.toString(numeros[0] + numeros[1]));
            boton2.setText(Integer.toString(numeros[3]));
            boton3.setText(Integer.toString(numeros[4]));
        } else if (numeros[2] == 2) {
            boton2.setText(Integer.toString(numeros[0] + numeros[1]));
            boton1.setText(Integer.toString(numeros[3]));
            boton3.setText(Integer.toString(numeros[4]));
        } else {
            boton3.setText(Integer.toString(numeros[0] + numeros[1]));
            boton2.setText(Integer.toString(numeros[3]));
            boton1.setText(Integer.toString(numeros[4]));
        }

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si el valor de la suma del label es igual al valor del boton elegido
                if (boton1.getText().equals(Integer.toString(numeros[0] + numeros[1]))) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.correcto);
                    MainActivity.this.recreate();
                } else {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.incorrecto);
                }
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mp.stop();
                    }
                });
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boton2.getText().equals(Integer.toString(numeros[0] + numeros[1]))) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.correcto);
                    MainActivity.this.recreate();
                } else {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.incorrecto);
                }
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mp.stop();
                    }
                });
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boton3.getText().equals(Integer.toString(numeros[0] + numeros[1]))) {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.correcto);
                    MainActivity.this.recreate();
                } else {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.incorrecto);
                }
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mp.stop();
                    }
                });
            }
        });
    }
}