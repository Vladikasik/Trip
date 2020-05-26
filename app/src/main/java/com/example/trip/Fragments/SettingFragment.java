package com.example.trip.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trip.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SettingFragment extends Fragment {
    private ArrayList<String> selectedItems;

    private TextView mTextViewReplyFromServer;
    private String Answer = "kek";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        selectedItems = new ArrayList<>();
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView chl= getView().findViewById(R.id.checkable_list);
        //set multiple selection mode
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Достопримечательности","Религиозные","Развлечения","Опера и балет","Интересные музеи","Научные музеи","Исторические музеи"};
        //supply data items to ListView
        ArrayAdapter<String> aa=new ArrayAdapter<String>(requireActivity(), R.layout.checkable_list_layout, R.id.txt_title, items);
        chl.setAdapter(aa);
        //set OnItemClickListener
        chl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items

            }

        });

        getView().findViewById(R.id.btshow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedItems(v);
            }
        });
    }

    public void showSelectedItems(View view){
        String selItems="";
        for(String item:selectedItems){
            if(selItems=="")
                selItems=item;
            else
                selItems +=";"+item;
        }

        Toast toast = Toast.makeText(getContext(),
                "Ваши предпочтения были успешно сохранены", Toast.LENGTH_SHORT);
        toast.show();
        sendMessage(selItems);
    }

    private void sendMessage(final String msg) {

        final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //Replace below IP with the IP of that device in which server socket open.
                    //If you change port then change the port number in the server side code also.
                    Socket s = new Socket("194.67.78.210", 2048);

                    s.setReceiveBufferSize(10000);

                    OutputStream out = s.getOutputStream();

                    PrintWriter output = new PrintWriter(out);

                    output.println(msg);
                    output.flush();
                    BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));

                    final String st = input.readLine();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String s = msg;

                            if (st != null)
                                Answer = st ;
                                System.out.println("Receive - " + Answer);
                                System.out.println("Symbols received = " + Answer.length());
                                makeJson(Answer);
                        }
                    });

                    output.close();
                    out.close();
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }


    private void makeJson(String data){
        try {
            JSONArray jsonObject = new JSONArray(data);
            writeToJson(jsonObject  );
        }catch (JSONException err){
            err.printStackTrace();
        }

    }

    private void writeToJson(JSONArray jsonObject){
        try {
            File fileName = new File(getContext().getFilesDir(), "places.json");
            FileWriter file = new FileWriter(fileName);
            file.write(String.valueOf(jsonObject));
            file.close();
            System.out.println("File was succesfully downloaded");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
