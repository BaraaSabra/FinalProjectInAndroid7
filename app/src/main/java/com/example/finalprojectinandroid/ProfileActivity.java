package com.example.finalprojectinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        Users users=new Users("Baraa","bara.a@gamil.com","","F","Palestin");
        viewModel.insertUsers(users);
        Log.d("users", String.valueOf(users));

        binding.edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=binding.tvName.getText().toString();
                String Email=binding.tvEmail.getText().toString();
                String BirthDate=binding.tvBirthdate.getText().toString();
                String Country=binding.tvCountry.getText().toString();
                String Gender=binding.checkGeender.getTransitionName();
                Users users1=new Users(Name,Email,BirthDate,Country,Gender);
                viewModel.updateUsers(users1);
            }
        });


    }
}