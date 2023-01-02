package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.finalprojectinandroid.RoomDataBase.Action;
import com.example.finalprojectinandroid.RoomDataBase.Level;
import com.example.finalprojectinandroid.RoomDataBase.LevelAdapter;
import com.example.finalprojectinandroid.RoomDataBase.PuzzleData;
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
    SharedPreferences sp= getSharedPreferences("Playe",MODE_PRIVATE) ;//الملف الافتراضي للمشروع باكمله
    SharedPreferences.Editor edit=sp.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        parsejsonFromAssest();




        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);

        viewModel.getLevel().observe(this, new Observer<List<Level>>() {
            @Override
            public void onChanged(List<Level> levels) {
                LevelAdapter adapter = new LevelAdapter((ArrayList<Level>) levels, getBaseContext(), new Action() {
                    @Override
                    public void OnClik(int levlenum) {
                        Level level=new Level();
                        Intent intent = new Intent(getBaseContext(), playe_Activity.class);
                              intent.putExtra("LevelNum",levlenum);
                              startActivity(intent);

//                        PuzzleData puzzle = new PuzzleData();
//                        puzzle.setPuzzle_number(levlenum);
//                        int puzzle_num_level = puzzle.getPuzzle_number();
//                        if (levlenum == puzzle_num_level) {
//                            Intent intent = new Intent(getBaseContext(), playe_Activity.class);
//                            intent.putExtra("LevelNum", levlenum);
//                            startActivity(intent);

                    }


                });
                binding.RV.setAdapter(adapter);
                binding.RV.setLayoutManager(new LinearLayoutManager(LevelActivity.this,
                        RecyclerView.VERTICAL, false));
            }
        });



    }

    private void parsejsonFromAssest() {
        String jsonStr = AppUtility.readFromAssests(getApplicationContext(), "Json");
        try {
            ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);

            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
                int num_level = jsonObject.getInt("level_no");
                int unlock_points = jsonObject.getInt("unlock_points");
                Level level = new Level(num_level, unlock_points);
                viewModel.insertLevle(level);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}