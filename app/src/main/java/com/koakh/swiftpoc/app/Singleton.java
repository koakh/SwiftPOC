package com.koakh.swiftpoc.app;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;

import com.koakh.swiftpoc.rest.identity.authenticate.AuthenticateResponse;

/**
 * Created by mario on 15/02/2015.
 */
public class Singleton extends Application {

  /**
   * Constants
   */
  public static final String TAG = "SwiftPOC";
  public static final String API_URL_IDENTITY = "http://koakh.com:5000/v2.0";
  public static final String API_URL_SWIFT = "http://koakh.com:8080/v1/AUTH_%s";

  private Context mContext;

  /**
   * Swift/OpenStack
   */
  //Store FULL Authentication Response, Includes all Details, ex Token used for all Request
  private AuthenticateResponse authenticateResponse;

  private static EditText editTextLog;

  public Singleton() {
  }

  public Context getContext() {
    return mContext;
  }
  public void setContext(Context context) {
    this.mContext = context;
  }

  public AuthenticateResponse getAuthenticateResponse() {
    return authenticateResponse;
  }
  public void setAuthenticateResponse(AuthenticateResponse authenticateResponse) {
    this.authenticateResponse = authenticateResponse;
  }

  public String getAuthenticateToken() {
    return authenticateResponse.getAccess().getToken().getId();
  }

  public String getTenant() {
    return authenticateResponse.getAccess().getToken().getTenant().getId();
  }

  public EditText getEditTextLog() {
    return Singleton.editTextLog;
  }

  public void setEditTextLog(EditText editTextLog) {
    Singleton.editTextLog = editTextLog;
  }
}
