package com.example.sunil.imagesel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int CAMERA_PIC_REQUEST = 22;

    Uri cameraUri;
   // private static final int RESULT_LOAD_IMAGE = 1;//by sunil
    Button BtnSelectImage;
    private ImageView ImgPhoto;
    private String Camerapath ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgPhoto = (ImageView) findViewById(R.id.ImgPhoto);

        BtnSelectImage = (Button) findViewById(R.id.BtnSelectImg);
        BtnSelectImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                try {

                   // Intent i = new Intent(
                         //   Intent.ACTION_PICK,
                         //   android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    //startActivityForResult(i, RESULT_LOAD_IMAGE);


                  Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                   startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);




                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Couldn't load photo", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         try {
            switch (requestCode) {
                case CAMERA_PIC_REQUEST:
                   if (resultCode == RESULT_OK) {
                        try {
                            Bitmap photo = (Bitmap) data.getExtras().get("data");

                            ImgPhoto.setImageBitmap(photo);

                      } catch (Exception e) {
                           Toast.makeText(this, "Couldn't load photo", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                default:
                    break;
           }
       } catch (Exception e) {
        }
    }


}