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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class ObjectFragment extends Fragment {

    String json = "{\n" +
            "  \"firstName\": \"Jan\",\n" +
            "  \"age\": 23,\n" +
            "  \"address\": {\n" +
            "    \"country\": \"Polska\",\n" +
            "    \"city\": \"Cieszyn\"\n" +
            "  }\n" +
            "}";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_object, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnShowObj = view.findViewById(R.id.btnShowObj);
        TextView tvResult1 = view.findViewById(R.id.tvResult1);

        btnShowObj.setOnClickListener(v -> {
            try {
                JSONObject person = new JSONObject(loadJSONFromAssets("person.json"));
                String firstName = person.getString("firstName");
                int age = person.getInt("age");
                JSONObject address = person.getJSONObject("address");
                String country = address.getString("country");
                String city = address.getString("city");
                String msg = firstName + " " + age + "\n" + country + " " + city;
                tvResult1.setText(msg);
            } catch (JSONException error) {
                Log.d("my_log", "error: " + error.getLocalizedMessage());
            }

        });
    }

    private String loadJSONFromAssets(String file) {
        String json = null;
        try {
            InputStream inputStream = requireActivity().getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}