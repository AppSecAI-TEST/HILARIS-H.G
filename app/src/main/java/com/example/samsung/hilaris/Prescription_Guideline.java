package com.example.samsung.hilaris;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class Prescription_Guideline extends AppCompatActivity {

    public String date;
    public Guidelines Guideline;
    public Prescription Prescription;
    private JSON response_JSON;
    Prescription_Guideline (JSONObject response) throws JSONException {
        response_JSON = new JSON(response);
        {
            date = response_JSON.getDate();
        }
        setGuidelines(response);
        setPrescriptions(response);
    }
    public void setGuidelines(JSONObject response) throws JSONException {
                    JSON Guideline = new JSON(response); // Parse it into JsonObject --> GuideLine
                    JSON xmlToJson = new JSON(XML.toJSONObject(Guideline.get_Guideline())); // make XML type to Json Type
                    JSON guidelines_JSON = new JSON(xmlToJson.get_guidelines()); // Make it into JsonObject
                    JSONArray GuidelineArray = guidelines_JSON.get_guidelineConvert();
                    Prescription_Guideline.this.Guideline = new Guidelines(GuidelineArray);
    }
    public void setPrescriptions(JSONObject response) throws JSONException {
                    JSON Prescription = new JSON(response); // Parse it into JsonObject --> GuideLine
                    JSON xmlToJson = new JSON(XML.toJSONObject(Prescription.get_Prescription())); // make XML type to Json Type
                    JSON prescriptions_JSON = new JSON(xmlToJson.get_prescriptions());
                    JSONArray PrescriptionArray = prescriptions_JSON.get_ExerciseRoutineConvert();
                    Prescription_Guideline.this.Prescription = new Prescription(PrescriptionArray);
    }


}