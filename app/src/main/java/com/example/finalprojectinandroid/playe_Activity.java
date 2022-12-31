package com.example.finalprojectinandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.finalprojectinandroid.Fragments.Adapter;
import com.example.finalprojectinandroid.Fragments.ChooseFragment;
import com.example.finalprojectinandroid.Fragments.FullTheBlank;
import com.example.finalprojectinandroid.Fragments.TrueorFales;
import com.example.finalprojectinandroid.RoomDataBase.Level;
import com.example.finalprojectinandroid.RoomDataBase.PuzzleData;
import com.example.finalprojectinandroid.RoomDataBase.ViewModel;
import com.example.finalprojectinandroid.RoomDataBase.puzzlepatterns;
import com.example.finalprojectinandroid.databinding.ActivityPlayeBinding;
import com.example.finalprojectinandroid.databinding.ActivityProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class playe_Activity extends AppCompatActivity {
    ActivityPlayeBinding binding;
    ViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        Jison();
        viewModel.getallpuzzeldata().observe(this, new Observer<List<PuzzleData>>() {
            @Override
            public void onChanged(List<PuzzleData> puzzleData) {
                for (int i = 0; i < puzzleData.size(); i++) {
                    if (puzzleData.get(i).getPattern_id()==(1) && puzzleData.get(i).getLevelnum() == getIntent().getIntExtra("LevelNum", 0)) {
                        TrueorFales trueorFales = TrueorFales.newInstance(puzzleData.get(i).getPuzzle_text(), puzzleData.get(i).getTrue_answer());
                        fragmentArrayList.add(trueorFales);
                    } else if (puzzleData.get(i).getPattern_id()==(2) && puzzleData.get(i).getLevelnum() == getIntent().getIntExtra("LevelNum", 0)) {
                        ChooseFragment chooseFragment = ChooseFragment.newInstance(puzzleData.get(i).getPuzzle_text(), puzzleData.get(i).getAnswer_1(), puzzleData.get(i).getAnswer_2(), puzzleData.get(i).getAnswer_3(), puzzleData.get(i).getAnswer_4(), puzzleData.get(i).getTrue_answer());
                        fragmentArrayList.add(chooseFragment);
                    } else if (puzzleData.get(i).getPattern_id()==(3) && puzzleData.get(i).getLevelnum() == getIntent().getIntExtra("LevelNum", 0)) {
                        FullTheBlank fullTheBlank = FullTheBlank.newInstance(puzzleData.get(i).getPuzzle_text(), puzzleData.get(i).getTrue_answer());
                        fragmentArrayList.add(fullTheBlank);
                    }

                }


            }

        });






        Adapter adapter = new Adapter(this, fragmentArrayList);
        binding.ViewPager.setAdapter(adapter);

    }



    private void Jison() {
        String jsonStr = AppUtility.readFromAssests(getApplicationContext(), "Json");
        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
//            ArrayList arrayListplayer=new ArrayList();
//            ArrayList<Level> levelArrayList=new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
//                new JSONObject(questionsjsonArray.get(j).toString());
//                JSONObject jsonObject=jsonArray.getJSONObject(i);
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                int num_level = jsonObject.getInt("level_no");
                int unlock_points = jsonObject.getInt("unlock_points");
                Level level = new Level(num_level, unlock_points);
                ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
                viewModel.insertLevle(level);

                JSONArray questionsjsonArray = jsonObject.getJSONArray("questions");
                for (int j = 0; j < questionsjsonArray.length(); j++) {
                    JSONObject questionjesonobject = new JSONObject(questionsjsonArray.get(j).toString());
                    int id = questionjesonobject.getInt("id");
                    String title = questionjesonobject.getString("title");
                    String answer_1 = questionjesonobject.getString("answer_1");
                    String answer_2 = questionjesonobject.getString("answer_2");
                    String answer_3 = questionjesonobject.getString("answer_3");
                    String answer_4 = questionjesonobject.getString("answer_4");
                    String true_answer = questionjesonobject.getString("true_answer");
                    int points = questionjesonobject.getInt("points");
                    int duration = questionjesonobject.getInt("duration");
                    JSONObject patternjsonobject = questionjesonobject.getJSONObject("pattern");
                    int pattern_id = patternjsonobject.getInt("pattern_id");
                    String pattern_name = patternjsonobject.getString("pattern_name");
                    String hint = questionjesonobject.getString("hint");
                    puzzlepatterns pattern = new puzzlepatterns(pattern_id, pattern_name, num_level);
                    PuzzleData puzzleData = new PuzzleData(id, title, answer_1, answer_2, answer_3, answer_4, true_answer, points, duration, pattern_name, num_level, hint,pattern_id);
                    viewModel.insertPuzzleData(puzzleData);
                    viewModel.insertpuzzlepatterns(pattern);
                    viewModel.insertLevle(level);
                    Log.d("question", String.valueOf(jsonObject));




                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





}