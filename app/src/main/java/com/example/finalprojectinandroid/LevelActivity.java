package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finalprojectinandroid.databinding.ActivityLevelBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {
    ActivityLevelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

     parsejsonFromAssest();
    }

    private void parsejsonFromAssest() {
        String jsonStr= AppUtility.readFromAssests(getApplicationContext(),"Json");
        try {
            JSONArray jsonArray=new JSONArray(jsonStr);
            ArrayList arrayListplayer=new ArrayList();
            ArrayList<Level> levelArrayList=new ArrayList<>();
            for (int i = 0; i <jsonArray.length() ; i++) {
                JSONObject jsonObject=new JSONObject(jsonArray.get(i).toString());
               int num_level=jsonObject.getInt("level_no");
               int unlock_points=jsonObject.getInt("unlock_points");
               Level level=new Level(num_level,unlock_points);

               JSONArray questionsjsonArray=jsonObject.getJSONArray("questions");
               ArrayList questionarrayList=new ArrayList();
                for (int j = 0; j < questionsjsonArray.length(); j++) {
                    JSONObject questionjesonobject=new JSONObject(questionsjsonArray.get(j).toString());
                    int id=questionjesonobject.getInt("id");
                    String title=questionjesonobject.getString("title");
                    String answer_1=questionjesonobject.getString("answer_1");
                    String answer_2=questionjesonobject.getString("answer_2");
                    String answer_3=questionjesonobject.getString("answer_3");
                    String answer_4=questionjesonobject.getString("answer_4");
                    String true_answer=questionjesonobject.getString("true_answer");
                    int points=questionjesonobject.getInt("points");
                    int duration=questionjesonobject.getInt("duration");
                    JSONObject patternjsonobject=questionjesonobject.getJSONObject("pattern");
                    int pattern_id=patternjsonobject.getInt("pattern_id");
                    String pattern_name=patternjsonobject.getString("pattern_name");
                    Pattern pattern=new Pattern(pattern_id,pattern_name);

                }




            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}