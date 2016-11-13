package in.kempa.tourmanipal.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import in.kempa.tourmanipal.R;
import in.kempa.tourmanipal.places.Places;


/**
 * Created by Ganesh Poojary on 11/6/2016.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceView> {
    ArrayList<Places> places = new ArrayList<Places>();

    public PlaceAdapter(ArrayList<Places> places) {
        this.places = places;
    }

    @Override
    public PlaceView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_item_view, parent, false);
        return new PlaceView(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceView holder, int position) {
        holder.placeName.setText(places.get(position).getName());
        holder.placeDesc.setText(places.get(position).getDescription());
        holder.placeRating.setRating(places.get(position).getRatings());
    }

    @Override
    public int getItemCount() {
        return this.places.size();
    }

    class PlaceView extends RecyclerView.ViewHolder {
        TextView placeName;
        TextView placeDesc;
        RatingBar placeRating;

        public PlaceView(View itemView) {
            super(itemView);
            placeName = (TextView) itemView.findViewById(R.id.rowPlaceName);
            placeDesc = (TextView) itemView.findViewById(R.id.rowPlaceDesc);
            placeRating = (RatingBar) itemView.findViewById(R.id.rowPlaceRating);
        }
    }
}
