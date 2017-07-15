package br.edu.ifpb.si.pdm.coisas;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    private Button btBrowser, btDiscar, btLigar, btEmail,
            btSMS, btCompartilhar, btPonto, btRota, btYoutube, btFoto;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botoes();
        this.setListenerBotoes();
    }

    private void botoes(){
        this.btBrowser = (Button) findViewById(R.id.btBrowser);
        this.btDiscar = (Button) findViewById(R.id.btDiscar);
        this.btLigar = (Button) findViewById(R.id.btLigar);
        this.btEmail = (Button) findViewById(R.id.btEmail);
        this.btSMS = (Button) findViewById(R.id.btSMS);
        this.btCompartilhar = (Button) findViewById(R.id.btCompartilhar);
        this.btPonto = (Button) findViewById(R.id.btVisualizarPonto);
        this.btRota = (Button) findViewById(R.id.btVisualizarRota);
        this.btYoutube = (Button) findViewById(R.id.btYoutube);
        this.btFoto = (Button) findViewById(R.id.btFoto);
    }

    private void setListenerBotoes(){
        this.btBrowser.setOnClickListener(new OnClickBotao());
        this.btDiscar.setOnClickListener(new OnClickBotao());
        this.btLigar.setOnClickListener(new OnClickBotao());
        this.btEmail.setOnClickListener(new OnClickBotao());
        this.btSMS.setOnClickListener(new OnClickBotao());
        this.btCompartilhar.setOnClickListener(new OnClickBotao());
        this.btPonto.setOnClickListener(new OnClickBotao());
        this.btRota.setOnClickListener(new OnClickBotao());
        this.btYoutube.setOnClickListener(new OnClickBotao());
        this.btFoto.setOnClickListener(new OnClickBotao());

    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(MainActivity.this.btBrowser)){
                Log.i("FOFO", "Browser");
                Uri uri = Uri.parse("http://pdm.valeriacavalcanti.com.br");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }else if (v.equals(MainActivity.this.btDiscar)){
                Log.i("FOFO", "Discar");
                Uri uri = Uri.parse("tel:36121392");
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }else if (v.equals(MainActivity.this.btLigar)){
                Log.i("FOFO", "Ligar");
                Uri uri = Uri.parse("tel:988716103");
                Intent it = new Intent(Intent.ACTION_CALL, uri);
                int permissao = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
                if(permissao == PackageManager.PERMISSION_GRANTED){
                    startActivity(it);
                }else
                    Toast.makeText(MainActivity.this.getApplicationContext(),
                            "Permissão negada.\nVerifique suas configurações", Toast.LENGTH_LONG).show();
            }else if (v.equals(MainActivity.this.btEmail)){
                Log.i("FOFO", "e-mail");
                Uri uri = Uri.parse("mailto:jaeniaps@gamil.com");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra(Intent.EXTRA_SUBJECT, "Sobre uma coisa legal");
                it.putExtra(Intent.EXTRA_TEXT, "Para mais informações, favor marcar um encontro");
                startActivity(it);
            }else if (v.equals(MainActivity.this.btSMS)){
                Log.i("FOFO", "SMS");
                Uri uri = Uri.parse("sms:997561950");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(it);
            }else if (v.equals(MainActivity.this.btCompartilhar)){
                Log.i("FOFO", "Compartilhar Texto");
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT, "Testando isso de compartilhar texto. Será que funciona?");
                startActivity(Intent.createChooser(it, "Compartilhando seu texto"));
                startActivity(it);
            }else if (v.equals(MainActivity.this.btPonto)){
                Log.i("FOFO", "Visualizar Ponto");
                Uri uri = Uri.parse("geo:-7.1181783, -34.8730402");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }else if (v.equals(MainActivity.this.btRota)){
                Log.i("FOFO", "Visualizar Rota");
                String origem = "-7.1181783, -34.8730402";
                String destino = "-7.1619359, -34.8327554";
                String path = "http://maps.google.com/maps?f=&saddr=%s+&daddr=%s";
                Uri uri = Uri.parse(String.format(path, origem, destino));
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }else if (v.equals(MainActivity.this.btYoutube)){
                Log.i("FOFO", "Youtube");
                Uri uri = Uri.parse("vnd.youtube://B08iLAtS3AQ");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }else{
                Log.i("FOFO", "Foto");
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it, 0);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                Bitmap img = (Bitmap) bundle.get("data");

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                img.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bitMapData = stream.toByteArray();

                Intent it1 = new Intent(MainActivity.this, FilhaActivity.class);
                it1.putExtra("IMAGEM", bitMapData);
                startActivity(it1);

            }
        }
    }
}
