package br.edu.ifpb.si.pdm.coisas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.Serializable;

public class FilhaActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filha);

        Bundle bundle = this.getIntent().getExtras();

        img = (ImageView) findViewById(R.id.ivFoto);

        byte[] imagemByteArray = bundle.getByteArray("IMAGEM");
        Bitmap imagem = BitmapFactory.decodeByteArray(imagemByteArray, 0, imagemByteArray.length);

        img.setImageBitmap(imagem);
    }
}
