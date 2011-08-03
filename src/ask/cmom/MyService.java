package ask.cmom;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{

	private final String TAG = getClass().getSimpleName();
	public static final String INTENT_ACTION = "ask.cmom.MyService";
	
	
	public static int contador1 = 0;
	private int contador2=0;
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		
		Log.v(TAG, "Estoy en "+TAG+": onStart public "+contador1);
		Log.v(TAG, "Estoy en "+TAG+": onStart private "+contador2);
		
		//Duración del Toast por 3 segundos
		
		int duration = 2*1000;
				
		//Mostrar la iteración del servicio
				
		Toast.makeText(this, "Estoy en el service num:  "+contador1, duration).show();
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		Log.v(TAG, "Estoy en "+TAG+": onStartCommand"+contador2++);
		
		//Duración del Toast por 3 segundos
		
		int duration = 2*1000;
		
		//Mostrar la iteración del servicio
		
		String cadena = "Estoy en el service num public:  "+contador1+'\n'+
				"Estoy en el service num private:  "+contador2;
		
		Toast.makeText(this,cadena, duration).show();
	
		stopSelf();
		
		//Otra forma de realizar tarea es con Timer
//		TimerTask task = new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				Log.v(TAG, "Soy TimerTask hehehehe: "+contador2);
//				
//			}
//		};
//		
//		
//		Timer timer = new Timer();
//		
//		timer.schedule(task,1000,1000);
			
		return START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Log.v(TAG, "Estoy en "+TAG+": onDestroy public "+contador1);
		Log.v(TAG, "Estoy en "+TAG+": onDestroy private "+contador2);
	}

}
