package com.example.jason_valley.homeFragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.*;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentContainerView;

import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.most_popular.king_solomon;
import com.example.jason_valley.usermodel.Books;

import java.util.ArrayList;
import java.util.List;


public class Search extends Fragment  {
    ListView bookL;
   static   List<Books> books;
    ArrayList<Books> allBooks;
    static BooksAdapter booksAdapter;
    FragmentContainerView fragment;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v =  inflater.inflate(R.layout.fragment_search, container, false);
        DataBase b = new DataBase(v.getContext());
        bookL = v.findViewById(R.id.book_list);
        SearchView search = (SearchView)  v.findViewById(R.id.search);
        search.clearFocus();
        Button show;
        show = v.findViewById(R.id.show);
        LinearLayout hide;
            hide = v.findViewById(R.id.scroll);

        books = b.getAllBooks();
        allBooks = new ArrayList<>(books);
        booksAdapter = new BooksAdapter(v.getContext(), allBooks);
        bookL.setAdapter(booksAdapter);
        bookL.setClickable(true);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setIconified(false);
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                booksAdapter.getFilter().filter(s);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String text) {
                booksAdapter.getFilter().filter(text);
                return false;
            }
        });
        bookL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
                Bundle bundle = new Bundle();
                String title = allBooks.get(i).getTitle();
                String author = allBooks.get(i).getAuthor();
                String desc = allBooks.get(i).getDescription();
                String lang = allBooks.get(i).getLanguage();
                String genre = allBooks.get(i).getCategory();
                String picture = allBooks.get(i).getImages();
                String pdf = allBooks.get(i).getPdf();
                int resId = getContext().getResources().getIdentifier(String.format("drawable/%s", picture), null, getContext().getPackageName());
                bundle.putString("author", author);
                bundle.putString("desc", desc);
                bundle.putString("lang", lang);
                bundle.putString("genre", genre);
                bundle.putString("title", title);
                bundle.putInt("picture", resId);
                bundle.putString("pdf", pdf);
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.searchFrag, all_books.class, bundle).commit();
                hide.setVisibility(View.GONE);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < allBooks.size(); i++){
                    Button ts = new Button(getContext());
                    System.out.println("Title: "+allBooks.get(i).getTitle()+" author:  "+allBooks.get(i).getAuthor()+" Genre: "+allBooks.get(i).getCategory());
                }
            }
        });
        return  v;
    }
}