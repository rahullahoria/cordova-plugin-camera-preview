package com.livechek.tflite;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.Arrays;

public class TfLite extends CordovaPlugin {

  private static final String TAG = "TfLite";

  
  private static final String Classify_Frame_Base64 = "classifyFrameBase64";


  private ImageClassifier classifier;

  public TfLite(){
    super();
    Log.d(TAG, "Constructing");
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    if (Classify_Frame_Base64.equals(action)) {
      return classifyFrameBase64(args.getString(0),callbackContext);
    } 
    return false;
  }

  private boolean classifyFrameBase64(String base64Img, CallbackContext callbackContext) {
    if(this.hasView(callbackContext) == false){
      return true;
    }


    try {
        classifier = new ImageClassifier(getActivity());

        callbackContext.onSuccess(classifier.classifyFrameBase64(base64Img));
      } catch (IOException e) {
        Log.e(TAG, "Failed to initialize an image classifier." + e.toString());

        callbackContext.onError("Failed to initialize an image classifier." + e.toString());


      }


    return true;
  }
  
}
