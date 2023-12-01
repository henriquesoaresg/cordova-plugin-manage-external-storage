package br.com.rickdev;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;


import org.apache.cordova.*;
import java.lang.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ManageExternalStorage extends CordovaPlugin {

    private static final String ACTION_CHECK_PERMISSION = "checkPermission";
    private static final String ACTION_GET_PERMISSION = "openConfigPermissionScreen";
    
    private static final int PERMISSION_RESULT_CODE = 0;
    private static final int PERMISSION_FAIL_RESULT_CODE = 0;
    private static final int PERMISSION_SUCCESS_RESULT_CODE = 1;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(ACTION_CHECK_PERMISSION)) {
            boolean result = checkPermissionAction();
            if (result) {
                callbackContext.success(PERMISSION_SUCCESS_RESULT_CODE);
            }else{
                callbackContext.success(PERMISSION_FAIL_RESULT_CODE);
            }
            return result;
        } else if (action.equals(ACTION_GET_PERMISSION)) {
            openConfigPermissionScreen();
            return true;            
        }
        return false;
    }

    private boolean checkPermissionAction(){
        return Environment.isExternalStorageManager();
    }

    private void openConfigPermissionScreen() {
        Activity activity = this.cordova.getActivity();
        Context context = this.cordova.getActivity().getApplicationContext();
        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:" + activity.getPackageName()));
        activity.startActivityForResult(intent, PERMISSION_RESULT_CODE);
    }

    private void addProperty(JSONObject obj, String key, Object value) {
        try {
            if (value == null) {
                obj.put(key, JSONObject.NULL);
            } else {
                obj.put(key, value);
            }
        } catch (JSONException ex) {
            System.out.println("Error: " + ex);
        }
    }
}