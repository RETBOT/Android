package mx.edu.itl.c85360673.u4smsreceptorapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceptor extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
    SmsMessage smsMessage [] = Telephony.Sms.Intents.getMessagesFromIntent( intent );

    if ( smsMessage != null ) {
        SmsMessage sms = smsMessage [ 0 ];
        String telef = sms.getOriginatingAddress();
        String text = sms.getMessageBody();

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis( sms.getTimestampMillis() );
        String fechaHora = c.getTime().toString();

        Toast.makeText( context,
                        "SMS: ("+fechaHora+")\n"+telef+"\n"+text,
                            Toast.LENGTH_LONG).show();
    }
    }
}
