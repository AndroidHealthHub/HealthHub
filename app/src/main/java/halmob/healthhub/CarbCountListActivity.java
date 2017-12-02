package halmob.healthhub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import halmob.healthhub.EventListeners.MealListener;
import halmob.healthhub.Models.Meal;

/**
 * Created by hakan on 2.12.2017.
 */

public class CarbCountListActivity extends AppCompatActivity implements MealListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carb_count_meal_list);

        FirebaseTransaction.setmMealListener(this);
        FirebaseTransaction.getMeals();
    }

    @Override
    public void mealsRead(List<Meal> mealList){
        ListAdapter carbCountListAdapter = new CustomCarbCountAdapter(this, mealList);
        ListView listViewCarbCountMeals = (ListView) findViewById(R.id.listViewCarbCountMeals);
        listViewCarbCountMeals.setAdapter(carbCountListAdapter);
    }
}
