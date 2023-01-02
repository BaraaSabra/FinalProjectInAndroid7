package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.finalprojectinandroid.Fragments.Adapter;
import com.example.finalprojectinandroid.Fragments.DailogTrue;
import com.example.finalprojectinandroid.Fragments.OnAnswer;
import com.example.finalprojectinandroid.Fragments.ChooseFragment;
import com.example.finalprojectinandroid.Fragments.Dialog;
import com.example.finalprojectinandroid.Fragments.FullTheBlank;
import com.example.finalprojectinandroid.Fragments.TrueorFales;
import com.example.finalprojectinandroid.RoomDataBase.Level;
import com.example.finalprojectinandroid.RoomDataBase.PuzzleData;
import com.example.finalprojectinandroid.RoomDataBase.ViewModel;
import com.example.finalprojectinandroid.RoomDataBase.puzzlepatterns;
import com.example.finalprojectinandroid.databinding.ActivityPlayeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class playe_Activity extends AppCompatActivity implements OnAnswer {
    ActivityPlayeBinding binding;
    ViewModel viewModel;
    int counter = 0;
    int timer;
    int AllTheQuestion=0;
    SharedPreferences sp= getSharedPreferences("Playe",MODE_PRIVATE) ;//الملف الافتراضي للمشروع باكمله
    SharedPreferences.Editor edit=sp.edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Timer();

        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);

            }
        });

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        Jison();
        viewModel.getallpuzzeldata().observe(this, new Observer<List<PuzzleData>>() {
            @Override
            public void onChanged(List<PuzzleData> puzzleData) {
                for (int i = 0; i < puzzleData.size(); i++) {
                    if (puzzleData.get(i).getPattern_id() == (1) && puzzleData.get(i).getLevelnum() == getIntent().getIntExtra("LevelNum", 0)) {
                        TrueorFales trueorFales = TrueorFales.newInstance(puzzleData.get(i).getPuzzle_text(), puzzleData.get(i).getTrue_answer());
                        Log.d("answer", puzzleData.get(i).getTrue_answer());
                        fragmentArrayList.add(trueorFales);
                   AllTheQuestion= AllTheQuestion + 1;
                    } else if (puzzleData.get(i).getPattern_id() == (2) && puzzleData.get(i).getLevelnum() == getIntent().getIntExtra("LevelNum", 0)) {
                        ChooseFragment chooseFragment = ChooseFragment.newInstance(puzzleData.get(i).getPuzzle_text(), puzzleData.get(i).getAnswer_1(), puzzleData.get(i).getAnswer_2(), puzzleData.get(i).getAnswer_3(), puzzleData.get(i).getAnswer_4(), puzzleData.get(i).getTrue_answer());
                        fragmentArrayList.add(chooseFragment);
                        AllTheQuestion= AllTheQuestion + 1;
                    } else if (puzzleData.get(i).getPattern_id() == (3) && puzzleData.get(i).getLevelnum() == getIntent().getIntExtra("LevelNum", 0)) {
                        FullTheBlank fullTheBlank = FullTheBlank.newInstance(puzzleData.get(i).getPuzzle_text(), puzzleData.get(i).getTrue_answer());
                        fragmentArrayList.add(fullTheBlank);
                        AllTheQuestion= AllTheQuestion + 1;
                    }
                }
                binding.numofQuestion.setText(String.valueOf(AllTheQuestion));
//           int NumOfLevel= getIntent().getIntExtra("LevelNum",0);
//                binding.numoflevel.setText(String.valueOf(NumOfLevel));

            }

        });


        Adapter adapter = new Adapter(this, fragmentArrayList);
        binding.ViewPager.setAdapter(adapter);

    }

    private void Timer() {

            new CountDownTimer(30000, 1000) {
                public void onTick(long millisUntilFinished) {
                    binding.timer.setText(String.valueOf(timer));
                    timer++;
                }

                public void onFinish() {
                    binding.timer.setText("FINISH!!");
                }
            }.start();
    }


    private void Jison() {
        String jsonStr = AppUtility.readFromAssests(getApplicationContext(), "Json");
        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
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
                    PuzzleData puzzleData = new PuzzleData(id, title, answer_1, answer_2, answer_3, answer_4, true_answer, points, duration, pattern_name, num_level, hint, pattern_id);
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

    @Override
    public void ChecktheAnswer(String TrueAnsewr, String UserAnswer, int pattern) {
        MediaPlayer mediaPlayer_fales = MediaPlayer.create(this, R.raw.fals);
        MediaPlayer mediaPlayer_true = MediaPlayer.create(this, R.raw.tru);

        if (pattern == 1) {
            if (TrueAnsewr.equals(UserAnswer)) {
                counter = counter + 1;
                binding.point.setText(String.valueOf(counter));
                DailogTrue dialog = DailogTrue.newInstance();
                dialog.show(getSupportFragmentManager(), null);
                mediaPlayer_true.start();
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);

            } else {
                Dialog dialog = Dialog.newInstance(TrueAnsewr);
                dialog.show(getSupportFragmentManager(), null);
                mediaPlayer_fales.start();
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);
            }
        } else if (pattern == 2) {
            if (TrueAnsewr.equals(UserAnswer)) {
                counter = counter + 2;
                DailogTrue dialog = DailogTrue.newInstance();
                dialog.show(getSupportFragmentManager(), null);
                binding.point.setText(String.valueOf(counter));
                mediaPlayer_true.start();
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);
            } else {
                Dialog dialog = Dialog.newInstance(TrueAnsewr);
                dialog.show(getSupportFragmentManager(), null);
                mediaPlayer_fales.start();
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);
            }

        } else if (pattern == 3) {
            if (TrueAnsewr.equals(UserAnswer)) {
                counter = counter + 5;
                DailogTrue dialog = DailogTrue.newInstance();
                dialog.show(getSupportFragmentManager(), null);
                binding.point.setText(String.valueOf(counter));
                mediaPlayer_true.start();
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);
            } else {
                Dialog dialog = Dialog.newInstance(TrueAnsewr);
                dialog.show(getSupportFragmentManager(), null);
                mediaPlayer_fales.start();
                binding.ViewPager.setCurrentItem(binding.ViewPager.getCurrentItem() + 1);
            }
        }
        edit.putString("counter",String.valueOf(counter));
        edit.apply();

    }


}

