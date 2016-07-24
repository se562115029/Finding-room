package com.example.oo.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //// Text topic
    TextView coderoomT;
    TextView buildinameT;
    TextView floorT;
    TextView noteT;
    ///// display
    EditText userinput;
    TextView coderoomText;
    TextView buildinameText;
    TextView noteText;
    TextView floorText;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userinput = (EditText) findViewById(R.id.editText);
        ///// text topic
        coderoomT = (TextView)findViewById(R.id.roomcodeView);
        buildinameT = (TextView)findViewById(R.id.builingnmaeView);
        floorT = (TextView) findViewById(R.id.floorView);
        noteT = (TextView) findViewById(R.id.noteView);
        ////// display
        coderoomText = (TextView) findViewById(R.id.roodcode_actor);
        buildinameText = (TextView) findViewById(R.id.buildingname_actor);
        floorText = (TextView) findViewById(R.id.floor_actor);
        noteText = (TextView) findViewById(R.id.note_actor);
        dbHandler = new MyDBHandler(this,null,null,1);
        hideResult();
        Mock();


//        printDatabase();
    }
        public void SearchButtonClicked(View view){
        String inputSearch = userinput.getText().toString();
            String displayRoomCode =  dbHandler.getCodeNamebyCode(inputSearch);
            String displayBuildingName =  dbHandler.getBuildingnamebyCode(inputSearch);
            String displaynote =  dbHandler.getNotebyCode(inputSearch);
            String displayFloor = getFloorbyRoomcode(inputSearch);
            coderoomText.setText(displayRoomCode);
            buildinameText.setText(displayBuildingName);
            floorText.setText(displayFloor);
            noteText.setText(displaynote );
            userinput.setText("");;
            //////////// topic
            coderoomT.setText("Code Room :");
            buildinameT.setText("Building Name :");
            floorT.setText("Floor :");
            noteT.setText("Note : ");
        }

    public String getFloorbyRoomcode (String roomcode){
        String test = roomcode;
        String[] t = test.split("(?!^)");
        int count = t.length;

        int index = (count-3);

        return t[index];
    }
    public void Mock(){
        AddproductMock("เหลือง","วิจิตำ","WJ210");
        AddproductMock("แดง","เรียนร่วม5","RR5210");

    }
    public void AddproductMock(String note, String buildingname, String roomcode){
        IRoom croom = new IRoom(note, buildingname, roomcode);


        dbHandler.addroom(croom);

    }
    public void hideResult(){
        coderoomT.setText("");
        buildinameT.setText("");
        floorT.setText("");
        noteT.setText("");
        ////// display
        coderoomText.setText("");
        buildinameText.setText("");
        floorText.setText("");
        noteText.setText("");
    }
//    public void printDatabase(){
//        String dbString = dbHandler.databaseToString();
//        noteText.setText(dbString);
//        userinput.setText("");
//    }
}
