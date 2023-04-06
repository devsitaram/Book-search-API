package com.example.api.Books;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    // creating variables for arraylist and context.
    private ArrayList<BookPojo> bookPojoArrayList;
    private Context context;

    // creating constructor for array list and context.
    public BookAdapter(ArrayList<BookPojo> bookPojoArrayList, Context context) {
        this.bookPojoArrayList = bookPojoArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        // inside on bind view holder method we are
        // setting our data to each UI component.
        BookPojo bookPojo = bookPojoArrayList.get(position);
        holder.nameTV.setText(bookPojo.getTitle());
        holder.publisherTV.setText(bookPojo.getPublisher());
        holder.pageCountTV.setText("No of Pages : " + bookPojo.getPageCount());
        holder.dateTV.setText(bookPojo.getPublishedDate());
        // below line is use to set image from URL in our image view.
        Picasso.get().load(bookPojo.getThumbnail()).into(holder.bookIV);

        // below line is use to add on click listener for our item of recycler view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inside on click listener method we are calling a new activity
                // and passing all the data of that item in next intent.
                Intent i = new Intent(context, BookDetailsActivity.class);
                i.putExtra("title", bookPojo.getTitle());
                i.putExtra("subtitle", bookPojo.getSubtitle());
                i.putExtra("authors", bookPojo.getAuthors());
                i.putExtra("publisher", bookPojo.getPublisher());
                i.putExtra("publishedDate", bookPojo.getPublishedDate());
                i.putExtra("description", bookPojo.getDescription());
                i.putExtra("pageCount", bookPojo.getPageCount());
                i.putExtra("thumbnail", bookPojo.getThumbnail());
                i.putExtra("previewLink", bookPojo.getPreviewLink());
                i.putExtra("infoLink", bookPojo.getInfoLink());
                i.putExtra("buyLink", bookPojo.getBuyLink());

                // after passing that data we are
                // starting our new  intent.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookPojoArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        // below line is use to initialize
        // our text view and image views.
        TextView nameTV, publisherTV, pageCountTV, dateTV;
        ImageView bookIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.idTVBookTitle);
            publisherTV = itemView.findViewById(R.id.idTVpublisher);
            pageCountTV = itemView.findViewById(R.id.idTVPageCount);
            dateTV = itemView.findViewById(R.id.idTVDate);
            bookIV = itemView.findViewById(R.id.idIVbook);
        }
    }
}
