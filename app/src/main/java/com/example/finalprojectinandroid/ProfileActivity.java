package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.finalprojectinandroid.RoomDataBase.Users;
import com.example.finalprojectinandroid.RoomDataBase.ViewModel;
import com.example.finalprojectinandroid.databinding.ActivityProfileBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;


import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int m=R.id.rab1_Male;
        int f=R.id.red1_Female;

        binding.tvBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                  @Override
                public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                      binding.tvBirthdate.setText(dayOfMonth
                              + "/" +(monthOfYear+1)  + "/" + year);
              }
            },
                        now.get(Calendar.YEAR), // Initial year selection
                        now.get(Calendar.MONTH), // Initial month selection
                        now.get(Calendar.DAY_OF_MONTH) // Inital day selection
                );
// If you're calling this from a support Fragment
                dpd.show(getSupportFragmentManager(), "Datepickerdialog");
            }
        });

        ViewModel viewModel=new ViewModelProvider(this).get(ViewModel.class);
        Users users=new Users("Baraa","bara.a@gamil.com","3/4/2003","F","Palestin");
        viewModel.insertUsers(users);
        binding.tvCountry.setText(users.getCountry());
        binding.tvBirthdate.setText(users.getDate());
        binding.tvEmail.setText(users.getEmail());
        binding.tvName.setText(users.getName());
        Log.d("users", String.valueOf(users));

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=binding.tvName.getText().toString();
                String Email=binding.tvEmail.getText().toString();
                String BirthDate=binding.tvBirthdate.getText().toString();
                String Country=binding.tvCountry.getText().toString();
                String Gender=binding.checkGeender.getTransitionName();
//                binding.checkGeender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                        switch (i){
//                            if()
//                        }
//                    }
//                });
                Users users1=new Users(Name,Email,BirthDate,Country,Gender);
                viewModel.updateUsers(users1);
                Log.d("users2", Name+Email+BirthDate+Country);
                Toast.makeText(ProfileActivity.this, "Saving completed successfullyء", Toast.LENGTH_SHORT).show();
                binding.tvName.setText(Name);
                binding.tvEmail.setText(Email);
                binding.tvBirthdate.setText(BirthDate);
                binding.tvCountry.setText(Country);



            }
        });


    }
}