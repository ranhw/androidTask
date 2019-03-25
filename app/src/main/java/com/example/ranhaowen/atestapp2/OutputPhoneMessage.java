package com.example.ranhaowen.atestapp2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by ranhaowen on 2019/3/22.
 */
public class OutputPhoneMessage extends AppCompatActivity {

    public static final String IMEI_ID = "none";
    private static final String mPermission  = Manifest.permission.READ_PHONE_STATE;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        Intent intent = getIntent();
        if (ContextCompat.checkSelfPermission(this, mPermission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{mPermission}, 1);
        }
        TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
        String message = tm.getDeviceId();  /*返回移动终端的软件版本，例如：GSM手机的IMEI/SV码。*/
        TextView textView = findViewById(R.id.textView7);
        textView.setText(message);
        String message1 = tm.getSubscriberId();
        TextView textView1 = findViewById(R.id.textView3);
        textView1.setText(message1);
        //String message2 = String.valueOf(tm.getNetworkType());//强转为Sting
        int message2 = tm.getDataState();
        String message21 = "none";//临时变量
            if (message2 == -1){message21 = "DATA_UNKNOWN"; }     /**Data connection state: Unknown.  Used before we know the state.*/
            if (message2 == 0){message21 = "DATA_DISCONNECTED"; }/** Data connection state: Disconnected. IP traffic not available. */
            if (message2 == 1){message21 = "DATA_CONNECTING"; }   /** Data connection state: Currently setting up a data connection. */
            if (message2 == 2){message21 = "DATA_CONNECTED"; }    /** Data connection state: Connected. IP traffic should be available. */
            if (message2 == 3) message21 = "DATA_SUSPENDED";      /** data activity may be suspended when a voice call arrives. */
        TextView textView2 = findViewById(R.id.textView5);
        textView2.setText(message21);
        int message3 = tm.getSimState();
        String message31 = "none";//临时变量
        if (message3 == 0){message31 = "SIM_STATE_UNKNOWN";}
        if (message3 == 1){message31 = "SIM_STATE_ABSENT";}        /** SIM card state: no SIM card is available in the device */
        if (message3 == 2){message31 = "SIM_STATE_PIN_REQUIRED";}  /** SIM card state: Locked: requires the user's SIM PIN to unlock */
        if (message3 == 3){message31 = "SIM_STATE_PUK_REQUIRED";}  /** SIM card state: Locked: requires the user's SIM PUK to unlock */
        if (message3 == 4){message31 = "SIM_STATE_NETWORK_LOCKED";}/** SIM card state: Locked: requires a network PIN to unlock */
        if (message3 == 5){message31 = "SIM_STATE_READY";}           /** SIM card state: Ready */
        if (message3 == 6){message31 = "SIM_STATE_NOT_READY";}      /** SIM card state: SIM Card is NOT READY */
        if (message3 == 7){message31 = "SIM_STATE_PERM_DISABLED";} /** SIM card state: SIM Card Error, permanently disabled */
        if (message3 == 8){message31 = "SIM_STATE_CARD_IO_ERROR";}   /** SIM card state: SIM Card Error, present but faulty */
        if (message3 == 9){message31 = "IM_STATE_CARD_RESTRICTED";}                 /** SIM card state: SIM Card restricted, present but not usable due to carrier restrictions.*/
        TextView textView3 = findViewById(R.id.textView9);
        textView3.setText(message31);
        int message4 = tm.getNetworkType();
        String message41 = "none";
        if (message4 == 0){message41 = "NETWORK_TYPE_UNKNOWN";}/* Network type is unknown */
        if (message4 == 1){message41 = "NETWORK_TYPE_GPRS";}   /* Current network is GPRS */
        if (message4 == 2){message41 = "NETWORK_TYPE_EDGE";}   /* Current network is EDGE */
        if (message4 == 3){message41 = "NETWORK_TYPE_UMTS";}   /* Current network is UMTS */
        if (message4 == 4){message41 = "NETWORK_TYPE_CDMA";}   /*Current network is CDMA: Either IS95A or IS95B*/
        if (message4 == 5){message41 = "NETWORK_TYPE_EVDO_0";} /* Current network is EVDO revision 0*/
        if (message4 == 6){message41 = "NETWORK_TYPE_EVDO_A";} /*Current network is EVDO revision A*/
        if (message4 == 7){message41 = "NETWORK_TYPE_1xRTT";}  /* Current network is 1xRTT*/
        if (message4 == 8){message41 = "NETWORK_TYPE_HSDPA";}  /* Current network is HSDPA */
        if (message4 == 9){message41 = "NETWORK_TYPE_HSUPA";}  /* Current network is HSUPA */
        if (message4 == 10){message41 = "NETWORK_TYPE_HSPA";}  /* Current network is HSPA */
        if (message4 == 11){message41 = "NETWORK_TYPE_IDEN";}  /* Current network is iDen */
        if (message4 == 12){message41 = "NETWORK_TYPE_EVDO_B";} /* Current network is EVDO revision B*/
        if (message4 == 13){message41 = "NETWORK_TYPE_LTE";}    /* Current network is LTE */
        if (message4 == 14){message41 = "NETWORK_TYPE_EHRPD";} /* Current network is eHRPD */
        if (message4 == 15){message41 = "NETWORK_TYPE_HSPAP";} /* Current network is HSPA+ */
        if (message4 == 16){message41 = "NETWORK_TYPE_GSM";}   /* Current network is GSM */
        if (message4 == 17){message41 = "NETWORK_TYPE_TD_SCDMA";}/* Current network is TD_SCDMA */
        if (message4 == 18){message41 = "NETWORK_TYPE_IWLAN";} /* Current network is IWLAN */
        if (message4 == 19){message41 = "NETWORK_TYPE_LTE_CA";} /* Current network is LTE_CA  */
        TextView textView4 = findViewById(R.id.textView11);
        textView4.setText(message41);
        int message5 = tm.getCallState();
        String message51 = "none";
        if(message5 == 0){message51 = "CALL_STATE_IDLE";}
        if(message5 == 1){message51 = "CALL_STATE_RINGING";}
        if(message5 == 2){message51 = "CALL_STATE_OFFHOOK";}
        TextView textView5 = findViewById(R.id.textView13);
        textView5.setText(message51);
    }
}
