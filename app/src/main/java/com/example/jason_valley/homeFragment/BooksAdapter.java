package com.example.jason_valley.homeFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jason_valley.R;
import com.example.jason_valley.usermodel.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends ArrayAdapter<Books> {
     static Books book;
     private List<Books> itemList;
    public BooksAdapter(Context context, ArrayList<Books> bookList){
        super(context,R.layout.list_book,bookList);
    }

    public void setFilter(List<Books> filter){
        this.itemList = filter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        book = getItem(position);
        if(convertView == null){
         convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_book,parent,false);
        }
        ImageView img = convertView.findViewById(R.id.img);
        int resId = getContext().getResources().getIdentifier(String.format("drawable/%s", book.getImages()), null, getContext().getPackageName());
        TextView title = convertView.findViewById(R.id.title);
        TextView author = convertView.findViewById(R.id.author);
        TextView lang = convertView.findViewById(R.id.lang);
        TextView genre = convertView.findViewById(R.id.genre);
        img.setImageResource(resId);
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        lang.setText(book.getLanguage());
        genre.setText(book.getCategory());
        return convertView;
    }
   


}
