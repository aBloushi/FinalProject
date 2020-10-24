package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        RecyclerView rv = findViewById(R.id.rec);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        Books HarryPotter1 = new Books("Harry Potter and the Philosopher's Stone", R.drawable.harry1, "June 26, 1997", getResources().getString(R.string.Harry1), "h1.pdf", "https://www.youtube.com/watch?v=WUALEh54jBA&t");
        Books HarryPotter2 = new Books("Harry Potter and the Chamber of Secrets", R.drawable.harry2, "July 2, 1998", getResources().getString(R.string.Harry2), "h2.pdf", "https://www.youtube.com/watch?v=ICjCL-Azokk");
        Books HarryPotter3 = new Books("Harry Potter and the Prisoner of Azkaban", R.drawable.harry3, "July 8, 1999", getResources().getString(R.string.Harry3), "h3.pdf", "https://www.youtube.com/watch?v=WUALEh54jBA&t");
        Books TheHungerGames1 = new Books("The Hunger Games", R.drawable.hunger1, "September 14, 2008", getResources().getString(R.string.Hunger1), "hu1.pdf", "https://www.youtube.com/watch?v=Lfi82CbVw1c");
        Books TheHungerGames2 = new Books("The Hunger Games: Catching Fire", R.drawable.hunger2, "September 1, 2009", getResources().getString(R.string.Hunger2), "hu2.pdf", "https://www.youtube.com/watch?v=WUALEh54jBA&t");
        Books IT = new Books("IT", R.drawable.it, "September 15, 1986", getResources().getString(R.string.it), "h3.pdf", "https://www.youtube.com/watch?v=lvj5N0gUJmQ");
        Books TheShining = new Books("The Shining", R.drawable.shin, "January 28, 1977", getResources().getString(R.string.Shinging), "h3.pdf", "https://www.youtube.com/watch?v=lvj5N0gUJmQ");
        Books PetSematary = new Books("Pet Sematary", R.drawable.pet, "November 14, 1983", getResources().getString(R.string.pet), "pet.pdf", "https://www.youtube.com/watch?v=lvj5N0gUJmQ");


        ArrayList<Books> Bookshelf = new ArrayList<>();

        Bookshelf.add(HarryPotter1);
        Bookshelf.add(HarryPotter2);
        Bookshelf.add(HarryPotter3);
        Bookshelf.add(TheHungerGames1);
        Bookshelf.add(TheHungerGames2);
        Bookshelf.add(IT);
        Bookshelf.add(TheShining);
        Bookshelf.add(PetSematary);


        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);


        BooksAdapter ad = new BooksAdapter(Bookshelf, this);
        rv.setAdapter(ad);

        Info inof = new Info();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("Menu");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)

                .withHeaderBackground(R.drawable.header)
                .addProfiles(

                        new ProfileDrawerItem().withName(inof.getName()).withEmail(Email()).withIcon(getResources().getDrawable(R.drawable.logo3))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        Intent intent = new Intent(getApplicationContext(), Profile.class);
                        startActivity(intent);
                        return false;
                    }
                })
                .build();

        new DrawerBuilder().withActivity(this).build();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Main Menu");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withName("Best Selling");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(2).withName("Recommended");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(2).withName("Newly Added");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(2).withName("My Favorite Book");
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(2).withName("Your Profile");
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(2).withName("Logout");




//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6,
                        new DividerDrawerItem(),

                        item7

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position) {
                            case 1:
                                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                                startActivity(intent);
                                break;
                            case 2:
                                Intent inftent = new Intent(getApplicationContext(), First.class);
                                startActivity(inftent);
                                break;
                            case 3:
                                Intent intent13 = new Intent(getApplicationContext(), Recommended.class);
                                startActivity(intent13);
                                break;
                            case 4:
                                Intent intent1443 = new Intent(getApplicationContext(), NewlyAdded.class);
                                startActivity(intent1443);
                                break;
                            case 5:
                                Intent intent14423 = new Intent(getApplicationContext(), Favorite.class);
                                startActivity(intent14423);

                                break;
                            case 6:
                                Intent intent142423 = new Intent(getApplicationContext(), Profile.class);
                                startActivity(intent142423);
                                break;
                            case 8:
                                openDialog();
                                break;

                        }
                        return true;
                    }
                })
                .build();

    }

    public static String Email() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userEmail = user.getEmail();
            return userEmail;
        } else {
            // No user is signed in
            return "Please sign in";
        }

    }

    public void openDialog() {
        DialogBox koo = new DialogBox();
        koo.show(getSupportFragmentManager(), "Abdullah");
    }
}