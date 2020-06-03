package com.example.cook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.content.Context;

import android.util.Log;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;




public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private Context mContext;
    private ArrayList<GuideStep> mGuideStep;


    public RecyclerViewAdapter(Context context, ArrayList<GuideStep> guideStep) {
        mGuideStep = guideStep;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("00000000", "displayed times");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_by_step_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(mGuideStep.get(position).getDescription());
        holder.image.setImageResource(mGuideStep.get(position).getStepPicture());
    }

    @Override
    public int getItemCount() {
        return mGuideStep.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.text_content);
        }
    }
}