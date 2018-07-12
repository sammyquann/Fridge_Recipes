package samstequa.com.fridge_recipes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.nav_title_recipe);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.nav_title_favorites);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.nav_title_profiles);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mTextMessage = (TextView) findViewById(R.id.recipe_header);
        final EditText search_bar = findViewById(R.id.recipe_search_bar);
        Button add_btn = findViewById(R.id.recipe_add_ingredient);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("=============Ingredient", search_bar.getText().toString());
            }
        });
    }

}
