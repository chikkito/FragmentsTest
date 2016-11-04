package com.oscar.jfiles;

    import android.app.Activity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.v4.app.FragmentActivity;
    import android.support.v4.app.FragmentTransaction;
    import android.util.Log;
    import android.view.View;
    import android.database.sqlite.*;
    import com.google.gson.Gson;



public class MainActivity
        //extends Activity
        extends FragmentActivity
            //implements HeadlinesFragment.OnHeadlineSelectedListener
    implements fragment.OnFragmentInteractionListener
            {

    static {
        System.loadLibrary("Test");
        //native void pib(float pib, int años, float crecimiento, int añoi);
    }

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //setContentView(R.layout.news_articles);


            Log.e("JSON",toJSON());
            Log.e("JSON",fromJSON(toJSON()).nombre);
            Log.e("JSON",fromJSON(toJSON()).vida);
            Log.e("JSON",fromJSON(toJSON()).sp);
            // Check whether the activity is using the layout version with
            // the fragment_container FrameLayout. If so, we must add the first fragment
           /* if (findViewById(R.id.fragment_container) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.
                if (savedInstanceState != null) {
                    return;
                }

                // Create an instance of ExampleFragment
                HeadlinesFragment firstFragment = new HeadlinesFragment();

                // In case this activity was started with special instructions from an Intent,
                // pass the Intent's extras to the fragment as arguments
                firstFragment.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, firstFragment).commit();
            }*/
        }

        /*public void onArticleSelected(int position) {
            // The user selected the headline of an article from the HeadlinesFragment

            // Capture the article fragment from the activity layout
            ArticleFragment articleFrag = (ArticleFragment)
                    getSupportFragmentManager().findFragmentById(R.id.article_fragment);

            if (articleFrag != null) {
                // If article frag is available, we're in two-pane layout...

                // Call a method in the ArticleFragment to update its content
                articleFrag.updateArticleView(position);

            } else {
                // If the frag is not available, we're in the one-pane layout and must swap frags...

                // Create fragment and give it an argument for the selected article
                ArticleFragment newFragment = new ArticleFragment();
                Bundle args = new Bundle();
                args.putInt(ArticleFragment.ARG_POSITION, position);
                newFragment.setArguments(args);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        }*/
    public native String hola();
    public native String pib(float pib, int años, float crecimiento, int añoi);
    public native void pib(float pib, int años, float crecimiento, int añoi,String fina);
    public void click(View v){
        fragment fragment = new fragment();

        //getSupportFragmentManager().beginTransaction().add(R.id.fragmentito, fragment).commit();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(0, 0, 300, 500);
        transaction.replace(R.id.fragmentito, fragment);
        transaction.addToBackStack("fragmentito");
        transaction.commit();


    }
    boolean mostrado = true;
    public void click1(View v){
        startActivity(new Intent(this,DBActivity.class));
        /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(0,0);
        fragment fragment = (com.oscar.jfiles.fragment) getSupportFragmentManager().getFragments().get(0);
        if (mostrado) {
            ft.show(fragment);
            Log.d("hidden","Show");
        } else {
            ft.hide(fragment);
            Log.d("Shown","Hide");
        }

        ft.commit();*/
    }
    public void clickfragment(View v){
        //fragment fragment = new fragment();
        fragment fragment = (com.oscar.jfiles.fragment) getSupportFragmentManager().getFragments().get(0);
        getSupportFragmentManager().beginTransaction().detach(fragment);
    }
    public void click2(View v){
        String hola = this.hola();
        Log.e("NDK","1 "+hola);
        String fin="";
        this.pib(1140, 5,2.5f,2016,fin);
        Log.e("NDK","2"+fin);
        String pi = this.pib(1140,5,2.5f,2016);
        Log.e("NDK","3 "+pi);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public String toJSON(){
        pjs personaje = new pjs();
        personaje.nombre = "chikkito";
        personaje.vida = "30k";
        personaje.sp = "3k";
        Gson gson = new Gson();
        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        //String json = ow.writeValueAsString(personaje);


        return gson.toJson(personaje);
    }

    public pjs fromJSON(String JSON){

        return new Gson().fromJson(JSON,pjs.class);
    }

    public class pjs{

        String nombre;
        String vida;
        String sp;
    }
}
