package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalprojectinandroid.RoomDataBase.Level;
import com.example.finalprojectinandroid.RoomDataBase.LevelAdapter;
import com.example.finalprojectinandroid.RoomDataBase.ViewModel;
import com.example.finalprojectinandroid.RoomDataBase.puzzlepatterns;
import com.example.finalprojectinandroid.databinding.ActivityLevelBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity {
    ActivityLevelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        //                myViewModel= new ViewModelProvider(this).get(MyViewModel.class);
//                parseJson();
//
//                myViewModel.getAllLevel().observe(this, new Observer<List<Level>>() {
//                    @Override
//                    public void onChanged(List<Level> levels) {
//
//                        LevelAdapter levelAdapter = new LevelAdapter((ArrayList<Level>) levels, PlayingStart.this, new OnClickItem() {
//                            @Override
//                            public void onclick(int levelnum) {
//                                Puzzle puzzle=new Puzzle();
//                                puzzle.setNum_level(levelnum);
//                                int puzzle_num_level=      puzzle.getNum_level();
//                                if (levelnum==puzzle_num_level){
//                                    Intent intent=new Intent(PlayingStart.this,LevelActivity.class);
//                                    intent.putExtra("level_num",levelnum);
//                                    startActivity(intent);
//                                }
//                            }
//                        });

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
                ViewModel viewModel=new ViewModel(getApplication());
                viewModel.insertLevle(level);

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
                    puzzlepatterns pattern=new puzzlepatterns(pattern_id,pattern_name);

                }


                 viewModel=new ViewModelProvider(this).get(ViewModel.class);

                viewModel.getLevel().observe(this, new Observer<List<Level>>() {
                    @Override
                    public void onChanged(List<Level> levels) {
                        LevelAdapter adapter = new LevelAdapter(levelArrayList, getBaseContext());
                        binding.RV.setAdapter(adapter);
                        binding.RV.setLayoutManager(new LinearLayoutManager(LevelActivity.this,
                                RecyclerView.VERTICAL, false));

                    }
                });



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}