package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.io.Serializable;

public class Chosen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen);

        Info inof = new Info();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("Menu");

        Button ebook = findViewById(R.id.Ebook);
        final Button audiobtn = findViewById(R.id.audio);


        final Bundle get = getIntent().getExtras();
        Books pArray = (Books) get.getSerializable("Books");
        final String pdfname = pArray.getPdfname();


        ImageView img2 = findViewById(R.id.imageView3);
        TextView name2 = findViewById(R.id.Title2);
        TextView releasedate2 = findViewById(R.id.Re2);
        TextView sum2 = findViewById(R.id.Sum2);

        img2.setImageResource(pArray.getImage());
        releasedate2.setText("Release Date: " + pArray.getReleaseDate() + "");
        name2.setText(pArray.getName() + "");
        sum2.setText(pArray.getSum() + "");

        audiobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Books pArray = (Books) get.getSerializable("Books");

                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(pArray.getUrl()));
                try {
                    Chosen.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
        });
        ebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chosen.this, pdf.class);
                intent.putExtra("pdf", pdfname);
                startActivity(intent);
            }
        });

// Create the AccountHeader
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