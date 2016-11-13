package in.kempa.tourmanipal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

public class AddPlaceActivity extends AppCompatActivity {
    EditText newPlaceName;
    EditText newPlaceDescription;
    RatingBar newPlaceRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        newPlaceName= (EditText) findViewById(R.id.newPlaceName);
        newPlaceDescription= (EditText) findViewById(R.id.newPlaceDescription);
        newPlaceRating= (RatingBar) findViewById(R.id.newPlaceRating);
    }
    public void btnAddPlacesClick(View view){
        String placeName=newPlaceName.getText().toString();
        String placeDescription=newPlaceDescription.getText().toString();
        float placeRating=newPlaceRating.getRating();
        //JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Re)
    }
}
