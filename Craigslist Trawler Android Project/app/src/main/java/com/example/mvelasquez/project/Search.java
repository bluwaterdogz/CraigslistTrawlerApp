package com.example.mvelasquez.project;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Search extends ActionBarActivity {

    private final String SFCL = "http://sfbay.craigslist.org/";

    public String jobTypeSelected = null;
    public String citySelected = null;
    public String jobCode = null;
    public String cityCode = null;
//    public Resources res = getResources();

//    public String[] jobTypeArray = res.getStringArray(R.array.selectablejobs);
//    public String[] cityArray = res.getStringArray(R.array.selectableCities);
//    public String[] jobCodeArray = res.getStringArray(R.array.jobCodes);
//    public String[] cityCodeArray = res.getStringArray(R.array.cityCodes);
//
    TextView resultTVTitle1 = (TextView) findViewById(R.id.resultsTVTitle1);
    TextView resultTVTitle2 = (TextView) findViewById(R.id.resultsTVTitle2);
    TextView resultTVPay1 = (TextView) findViewById(R.id.resultsTVPay1);
    TextView resultTVPay2 = (TextView) findViewById(R.id.resultsTVPay2);
    TextView resultTVDate1 = (TextView) findViewById(R.id.resultsTVDate1);
    TextView resultTVDate2 = (TextView) findViewById(R.id.resultsTVDate2);

//    public String CLuri;




    public class DownloadJobInfo extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String...uri){
            // super.doInBackground(); ?
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse response;
            String responseAsString = null;
            try{
                response = httpClient.execute(new HttpGet(uri[0]));
                StatusLine statusLine = response.getStatusLine();
                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    out.close();
                    responseAsString = out.toString();

                }else{
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            }
            catch(ClientProtocolException e){
                Toast toast = Toast.makeText(getApplicationContext(),"Problem with client Protocol",Toast.LENGTH_LONG);
                toast.show();
            }

            catch(IOException e){}

            return responseAsString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//
//            final String TITLE1STARTTAG = "class=\"hdrlnk\">";
//            final String TITLE1ENDTAG = "<a/>";
//
//            int beginIndex = s.indexOf(TITLE1STARTTAG)+ TITLE1STARTTAG.length();
//            int endIndex = s.indexOf(TITLE1ENDTAG);
//
//            String jobTitle = s.substring(beginIndex,endIndex);
//
//            resultTVTitle1.setText(Html.fromHtml(jobTitle));

        }
    }
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        Spinner citySpinner = (Spinner) findViewById(R.id.cityDropdown);
//        Spinner jobSpinner = (Spinner) findViewById(R.id.jobTypeDropdown);
//
//        ArrayAdapter<CharSequence> citySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.selectableCities, android.R.layout.simple_spinner_item);
//        citySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        citySpinner.setAdapter(citySpinnerAdapter);
//
//        ArrayAdapter<CharSequence> jobSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.selectablejobs, android.R.layout.simple_spinner_item);
//        jobSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        jobSpinner.setAdapter(jobSpinnerAdapter);
//
////        Map<String, String> map = new HashMap<String, String>();
////
////        for (int i = 0; i < jobTypeArray.length; i++) {
////
////            map.put(jobTypeArray[i], );
////
////        }
//
//    }
//
//
//    public void onClick(){
//
////        if(jobCode != null && cityCode != null){
////            if(){
////                CLuri = MBCL+"search/"+"/"+cityCode+"/"+jobCode;
////            }
////            else{
////                CLuri = SFCL+"search/"+"/"+cityCode+"/"+jobCode;
////            }
////
////        }
////        CLuri = SFCL+"search/"+"/"+"scz"+"/"+"web";
////            //why execute?
////        new DownloadJobInfo().execute(CLuri);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




