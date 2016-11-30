package com.yamankod.component_14_mydeviceinfo;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {
	private static final String TAG = "!!!";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ContentResolver contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(Settings.System.CONTENT_URI,
				null, null, null, null);
		startManagingCursor(cursor);

		Log.d(TAG, "cursor.getCount()" + cursor.getCount());

		ListView listView = (ListView) findViewById(R.id.listview);

		String[] from = { Settings.System.NAME, Settings.System.VALUE };
		int[] to = { R.id.textName, R.id.textValue };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(
				getApplicationContext(), R.layout.row, cursor, from, to);
		listView.setAdapter(adapter);
    }
}