package com.example.salmanma.icecreamsatease;
//main activity which shows 4fragments
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private  Toolbar toolbar;
    private CollapsingToolbarLayout cp;
    private Menu menu;
    private BottomSheetBehavior hehe;
    private View btm;
    public static Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CategoryAdapter adapter = new CategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //Adding listeners to page change
        cp=(CollapsingToolbarLayout)findViewById(R.id.collaptb);
        cp.setContentScrimColor(getResources().getColor(R.color.black));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        //setting to get recycler view flow normal
        NestedScrollView fsa=(NestedScrollView)findViewById(R.id.nstscmain);
        fsa.setFillViewport(true);
        toolbar = (Toolbar) findViewById(R.id.toolbarinMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Navigatoin drawer setup
        initNavigationDrawer();
    }
    //To provide more icon on action bar
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu=menu;
        return true;
    }
    */
    //navigation drawer setup
    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                //to do something when an option is selected in navigation drawer
                switch (id){
                    case R.id.homenab:
                            drawerLayout.closeDrawers();
                            break;
                    case R.id.dashboardnab:
                            startActivity(new Intent(getApplicationContext(), userset.class));
                            break;
                    case R.id.cart:
                           startActivity(new Intent(getApplicationContext(),cart.class));
                        break;
                    case R.id.recentordernab:
                          startActivity(new Intent(getApplicationContext(),recentorder.class));
                        break;
                    case R.id.favnab:
                       startActivity(new Intent(getApplicationContext(), favourites.class));
                        break;
						case R.id.settingsnab:
						    Intent sjy=new Intent(getApplicationContext(),interlocpanel.class);
                            sjy.putExtra("From","MainActiv");
					     startActivity(sjy);
                        break;

                }
                return true;
            }
        });
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        tv_email.setText("Hello User");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            //on navigation drawer close and open
            @Override
            public void onDrawerClosed(View v){

                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v)
            {
                super.onDrawerClosed(v);

            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this,Comingback.class));
    }
}
