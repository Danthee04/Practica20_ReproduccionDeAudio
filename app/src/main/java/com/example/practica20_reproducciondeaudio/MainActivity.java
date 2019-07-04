package com.example.practica20_reproducciondeaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Creamos 2 objetos y una variable de tipo int
    Button play;
    SoundPool sp;
    int sonido_de_reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button)findViewById(R.id.button_play);//Relacion objeto y parte grafica

        //Los 3 parametros solicitados son:
        // 1.- Maximo de reproducciones simultaneas
        // 2.- Tipo de STREAM de audio
        // 3.- Calidad de reproduccion,(aunque actualmente ya no se utiliza)
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);

        //Cargamos la pista que se va a reproducir, el segundo parametro es la ruta de la cancion.
        sonido_de_reproduccion = sp.load(this, R.raw.sound_short, 1);
    }

    //MEtodo para el boton SoundPool
    public void AudioSoundPool(View view){
        //El netodo play, reproduce la pista que cargamos previamente en nuestra variable int
        //1.- variable tipo int (sonido_de_reproduccion)
        //2.- Voluymen de lado izquierdo y derecho
        //3.- Prioridad
        //4.- Numero de repeticiones("-1= siempre se estara repitiendo", "0= se reproduce una sola vez", "1= se va a estar repitiendo automaticamente cada que termine")
        //5.- Modifica la velocidad o beat de reproduccion
        sp.play(sonido_de_reproduccion, 1,1, 1,0, 0);
    }

    //Metodo para el boton MEdiaPlayer
    public void AudioMediaPlayer(View view){
        //Metodo para cargar nuestro archivo de audio, segundo parametro incluye la ruta del archivo
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_long);
        //Iniciamos la reproduccion del archivo de audio
        mp.start();
    }
}
