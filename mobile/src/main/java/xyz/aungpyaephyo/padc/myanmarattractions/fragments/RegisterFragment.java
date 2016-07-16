package xyz.aungpyaephyo.padc.myanmarattractions.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import xyz.aungpyaephyo.padc.myanmarattractions.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;


/**
 * Created by windows on 7/15/2016.
 */
public class RegisterFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    EditText etDateOfBirth;
    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register, container, false);

        etDateOfBirth=(EditText)view.findViewById(R.id.et_date_of_birth);
        etDateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    showDatePicker();
                    showThirdPartyDialog();
                }
            }
        });
        etDateOfBirth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDatePicker();
                showThirdPartyDialog();
            }
        });
        return view;
    }
    private void showDatePicker(){
        DialogFragment newFragment= new DialogFragment();
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    private void showThirdPartyDialog(){
        Calendar now=Calendar.getInstance();
        DatePickerDialog thirdPartyDatePicker = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        thirdPartyDatePicker.show(getActivity().getFragmentManager(), "ThirdPartyDatePicker");
    }
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        etDateOfBirth.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
        //Toast.makeText(getContext(),"Year"+year+"Month"+monthOfYear+"Day"+dayOfMonth,Toast.LENGTH_SHORT).show();
    }
//    private void showDatePicker(){
//        DialogFragment newFragment=new MyDatePickerDialog();
//        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
//    }

//    private void showThirdPartyDialog(){
//        Calendar now=Calendar.getInstance();
//
//        DatePickerDialog thirdPartyDatePicker = DatePickerDialog.newInstace(
//                this,
//                now.get(Calendar.YEAR),
//                now.get(Calendar.MONTH),
//                now.get(Calendar.DAY_OF_MONTH)
//        );
//        thirdPartyDatePicker.show(getActivity().getFragmentManager(), "ThirdPartyDatePicker");
//    }

}
