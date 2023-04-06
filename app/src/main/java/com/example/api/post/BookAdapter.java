package com.example.api.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.api.R;
import com.example.api.post.holper.BookPojo;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    Context context;
    List<BookPojo> pojoList;

    public BookAdapter(Context context, List<BookPojo> pojoList) {
        this.context = context;
        this.pojoList = pojoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_items, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.ivBook.setText(pojoList.get(position).studentId +"");
//        holder.tvBooKId.setText(pojoList.get(position).name);
//        holder.tvBookName.setText(pojoList.get(position).email);
//        holder.tvAuther.setText(pojoList.get(position).address);
    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvBooKId;
        TextView tvBookName;
        TextView tvAuther;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvBooKId = itemView.findViewById(R.id.tv_bookId);
//            tvBookName = itemView.findViewById(R.id.tv_bookName);
//            tvAuther = itemView.findViewById(R.id.tv_auther);
        }
    }
}
