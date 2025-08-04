override fun onReceive(context:Context,intent:Intent){
    val mp=MediaPlayer.create(context,R.raw.alarm)
    Log.d("AlarmReceiver","Alarm received")
    mp.start()
    Toast.make(context,"Alram is ringning",Toast.LENGTH_LONG).show()
}
--------------------------------------------------------------------------------
var start = findViewById<Button>(R.id.button)
var RStart = findViewById<Button>(R.id.RStart)
var cancel = findViewById<Button>(R.id.cancel_button)
var Etext = findViewById<EditText>(R.id.time)
var alarmManager: AlarmManager
val intent = Intent(this,P12AlarmBroadCast::class.java)
val pendingIntent = PendingIntent.getBroadcast(this,0,intent, FLAG_IMMUTABLE)// flag_Update_current


start.setOnClickListener {
    var i = Etext.text.toString().toInt()
    alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
    //RTC.WAKEUP:
    //
    //
    //
    alarmManager.set(AlarmManager.RTC_WAKEUP,
        System.currentTimeMillis()+(i*1000),pendingIntent)
    Toast.makeText(this, "Alarm set in $i seconds", Toast.LENGTH_LONG ).show()
}

RStart.setOnClickListener {
    alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),
        5000,pendingIntent)
    Toast.makeText(this,"Repeating Alarm 5 Seconds", Toast.LENGTH_LONG).show()
}

cancel.setOnClickListener {
    alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
    alarmManager.cancel(pendingIntent)
    Toast.makeText(this,"Alarm Cancelled", Toast.LENGTH_SHORT).show()
}
}