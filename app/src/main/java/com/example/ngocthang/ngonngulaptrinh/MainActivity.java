package com.example.ngocthang.ngonngulaptrinh;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> arrThumnai;
    private ArrayList<Language> arrLanguages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvNgonNgu = (ListView) findViewById(R.id.listViewLanguages);
        arrLanguages = new ArrayList<>();
        //Tạo mảng lưu cái item trong file languages.xml
        final String arrName[]=getResources().getStringArray(R.array.languages);
        final String arrDetail[]=getResources().getStringArray(R.array.Detail);
        //Hàm khởi tạo mảng lưu các item image languauage
        CreateThumbnai();
        //Mảng lưu item name và detail item, item image.
        for (int i = 0; i < arrName.length; i++) {
            Language nn = new Language(arrName[i], arrDetail[i], arrThumnai.get(i));
            arrLanguages.add(nn);
        }
        //tạo đối tượng view cho danh sách các ngôn ngữ
        MyAdapter adt = new MyAdapter(MainActivity.this, R.layout.detail_language, arrLanguages);
        //Set đối tượng view vào list view
        lvNgonNgu.setAdapter(adt);
        //override h lắng nghe sự kiện khi chọn item
        lvNgonNgu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, arrNgonNgu.get(position).getDetail(), Toast.LENGTH_LONG).show();
                AlertDialog myAlertDialog = CreateAlertDialog(arrLanguages.get(position).getName(), arrLanguages.get(position).getDetail());
                myAlertDialog.show();
            }
        });
    }

    //Hàm khởi tạo Dialog
    private AlertDialog CreateAlertDialog(String nn, String detail){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Thiết lập tiêu đề hiển thị
        builder.setTitle("Thông tin về ngôn ngữ " + nn);
        //Thiết lập thông báo hiển thị
        builder.setMessage(detail);
        builder.setCancelable(false);
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
    //Khởi tạo mảng và lưu các item image
    public void CreateThumbnai(){
        arrThumnai = new ArrayList<>();
        arrThumnai.add(R.drawable.java);
        arrThumnai.add(R.drawable.c);
        arrThumnai.add(R.drawable.cplusplus);
        arrThumnai.add(R.drawable.csharp);
        arrThumnai.add(R.drawable.python);
        arrThumnai.add(R.drawable.php);
        arrThumnai.add(R.drawable.ruby);
        arrThumnai.add(R.drawable.html);
        arrThumnai.add(R.drawable.css);
        arrThumnai.add(R.drawable.javascript);

    }

}
