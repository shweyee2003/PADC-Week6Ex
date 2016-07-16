package xyz.aungpyaephyo.padc.myanmarattractions.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import de.greenrobot.event.EventBus;
import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.R;
import xyz.aungpyaephyo.padc.myanmarattractions.adapters.AttractionAdapter;
import xyz.aungpyaephyo.padc.myanmarattractions.adapters.UserAdapter;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;
import xyz.aungpyaephyo.padc.myanmarattractions.events.DataEvent;
import xyz.aungpyaephyo.padc.myanmarattractions.fragments.LogInFragment;
import xyz.aungpyaephyo.padc.myanmarattractions.fragments.RegisterFragment;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

public class UserActivity extends AppCompatActivity {
    private UserAdapter mUserAdapter;
    public static Intent newIntent() {
        Intent intent = new Intent(MyanmarAttractionsApp.getContext(), UserActivity.class);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        Boolean istablet= false;

        if(MyanmarAttractionsConstants.IS_TABLET==true) {
            LogInFragment loginfragment = new LogInFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, loginfragment).commit();
        }
        else {
            if(MyanmarAttractionsConstants.IS_BTNREGISTER==true)
            {
                RegisterFragment registerfragment=new RegisterFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,registerfragment).commit();
            }
            else
            {
                LogInFragment loginfragment = new LogInFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, loginfragment).commit();
            }
        }
        if(findViewById(R.id.fl_container_2) != null)
        {
            RegisterFragment registerfragment=new RegisterFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_2,registerfragment).commit();
        }

        Button loginbutton=(Button) findViewById(R.id.btn_login);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LoginFragment loginFragment=new LoginFragment();
                LogInFragment fragment=LogInFragment.newInstance();
              /*  Bundle bundle=new Bundle();
                bundle.putString(LoginFragment.BARG_DUMMY_USERNAME,"dummy");
                loginFragment.setArguments(bundle);*/
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragment).commit();
            }
        });
    }

    public static boolean isTablet(Context context)
    {
        if((context.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE)
        {
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }

    public void onEventMainThread(DataEvent.UserDataLoadedEvent user) {
        String extra = user.getExtraMessage();
        Toast.makeText(getApplicationContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();


        List<UserVO> newUserList = user.getUserList();
        mUserAdapter.setNewData(newUserList);
    }
}
