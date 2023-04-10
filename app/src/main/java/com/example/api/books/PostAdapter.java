package com.example.api.books;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.R;
import com.example.api.books.helper.AuthorsItem;
import com.example.api.books.helper.BooksPojo;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context context;
    List<BooksPojo> booksPojoList;

    public PostAdapter(List<BooksPojo> booksPojoList, Context context) {
        this.context = context;
        this.booksPojoList = booksPojoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_items,parent,false);
        return new MyViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PostAdapter.MyViewHolder holder, int position) {
        BooksPojo book = booksPojoList.get(position);
        holder.titleTextView.setText(book.getTitle());

        // Get the author list from the BooksPojo object at the given position
        List<AuthorsItem> authorsItemList = book.getAuthors();

        // Loop through the author list and append each author's name to a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < authorsItemList.size(); i++) {
            stringBuilder.append(authorsItemList.get(i).getName());
            if (i != authorsItemList.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        System.out.println("Auther: "+stringBuilder);

//        StringBuilder authors = new StringBuilder();
//        for(AuthorsItem item :book.getAuthors() ){
//            authors.append(" ").append(item.getName());
//        }

        // Set the final author names string to the authorTextView
        holder.authorTextView.setText(stringBuilder.toString());
        holder.authorTextView.setText(book.getAuthors().get(0).getName());
        holder.urlTextView.setText(book.getDownloadCount() + "");
    }

    @Override
    public int getItemCount() {
        return booksPojoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView authorTextView;
        public TextView urlTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tvTitle);
            authorTextView = itemView.findViewById(R.id.tvAuthor);
            urlTextView = itemView.findViewById(R.id.tvUrl);
        }
    }
}
