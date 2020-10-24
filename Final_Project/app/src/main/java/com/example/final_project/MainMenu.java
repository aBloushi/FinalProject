package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainMenu extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.harry1, R.drawable.harry2, R.drawable.harry3,R.drawable.hunger1,R.drawable.hunger2,R.drawable.it,R.drawable.pet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        TextView best = findViewById(R.id.Best);
        TextView newlyadded = findViewById(R.id.newl);
        TextView rec = findViewById(R.id.reco);

        carouselView = (CarouselView) findViewById(R.id.Car);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainMenu.this,First.class);
                startActivity(intent);
            }
        });


        newlyadded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NewlyAdded.class);
                        startActivity(intent);
            }
        });

        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Recommended.class);
                startActivity(intent);
            }
        });



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

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    };
}
