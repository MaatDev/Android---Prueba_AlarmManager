package ask.cmom;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

	
	
public class Prueba_AlertManager extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	private final String TAG = getClass().getSimpleName();
	public static final String INTENT_ACTION = "ask.cmom.Prueba_AlertManager";
	
	private Button btn_start;
	private Button btn_stop;
	//Clase manejadora de actividad por tiempo
	private AlarmManager alarm;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.v(TAG, "Estoy en "+TAG+": onCreate");
        
        //Botones del xml
        
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        
        
        //Inicializar el manejador de alarma
        this.alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        
        
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//Preparar el intent para lanzar un servicio
		Intent intent = new Intent(MyService.INTENT_ACTION);
		PendingIntent pintent = PendingIntent.getService(this, 0, intent, 0);
		
		switch(v.getId()){
		
		case R.id.btn_start:
			        
			this.alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5000, pintent);
			
			finish();
			
			break;
			
		case R.id.btn_stop:
			
			this.alarm.cancel(pintent);
			
			
			//Detener el servicio
			stopService(intent);
			
			Toast.makeText(this, "Servicio detenido",Toast.LENGTH_LONG).show();
		
		}
		
	}
}