package ch.walica.temp31224_4tp_2_json;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ArrayFragment extends Fragment {

    private List<Person> persons = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_array, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnShowList = view.findViewById(R.id.btnShowList);
        TextView tvResult2 = view.findViewById(R.id.tvResult2);

        Gson gson = new Gson();

        btnShowList.setOnClickListener(v -> {
//            try {
//                JSONArray jsonArray = new JSONArray(ObjectFragment.loadJSONFromAssets("persons.json", requireActivity()));
//                for(int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    String firstName = jsonObject.getString("firstName");
//                    int age = jsonObject.getInt("age");
//                    JSONObject jsonAddress = jsonObject.getJSONObject("address");
//                    String country = jsonAddress.getString("country");
//                    String city = jsonAddress.getString("city");
//                    Person person = new Person(firstName, age, new Address(country, city));
//                    persons.add(person);
//                }
//
//                tvResult2.setText(persons.get(1).firstName());
//
//
//            } catch (JSONException error) {
//                Log.d("my_log", "error 2: " + error.getLocalizedMessage());
//            }

            Person[] persons = gson.fromJson(ObjectFragment.loadJSONFromAssets("persons.json", requireActivity()), Person[].class);
            tvResult2.setText(persons[1].firstName());
        });
    }
}