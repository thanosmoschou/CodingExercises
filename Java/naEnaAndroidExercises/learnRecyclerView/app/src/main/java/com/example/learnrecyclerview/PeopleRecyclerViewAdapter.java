/*
Author: Thanos Moschou
Description: This is a simple project in order to learn about card views, recycler view and glide.
 */

package com.example.learnrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PeopleRecyclerViewAdapter extends RecyclerView.Adapter<PeopleRecyclerViewAdapter.ViewHolder>
{

    private ArrayList<Person> people = new ArrayList<>();
    private Context context;

    public PeopleRecyclerViewAdapter(Context aContext)
    {
        this.context = aContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //Here we instantiate the view holder class. First we need to create a View object
        //The ViewGroup is the parent of all layout files.
        //We pass parent because we want to attach this view object to its parent.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);

        //Now that I have the view object I can create an instance of my view holder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //The most important method of this class
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        //here we use the properties of our view holder class
        holder.txtName.setText(people.get(position).getNameField());

        //Let's create a listener for each element. I will implement a listener for the relative layout and not only for the text view
        //that is inside my layout file
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, people.get(position).getNameField() + " Selected!", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(people.get(position).getImageUrl())
                .into(holder.personImage);
    }

    @Override
    public int getItemCount()
    {
        return people.size();
    }

    public void setPeople(ArrayList<Person> people)
    {
        this.people = people;
        notifyDataSetChanged(); //notify the adapter that the data have changed
    }

    //This inner class is going to hold the view items for every item in our recycler view.
    //I can instantiate all the view items that are inside my names list item layout file inside the constructor of this inner class.
    //In order to have access to elements inside the view objects you need to declare to the inner class.
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtName; //If I have more elements inside my layout file I can add them in the same way I did here.
        private ImageView personImage;
        private CardView parent; //If you want to add a listener to the whole item


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            personImage = itemView.findViewById(R.id.personImage);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
