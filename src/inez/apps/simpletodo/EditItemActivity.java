package inez.apps.simpletodo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

	EditText edittext;
	int position;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		String text = getIntent().getStringExtra("text");
		position = getIntent().getIntExtra("position", 0);

		edittext = (EditText) findViewById(R.id.editText1);
		edittext.setText(text);
		edittext.setSelection(text.length());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}
	
    public void save(View v) {
    	Intent i = new Intent(this, TodoActivity.class);
		i.putExtra("text", edittext.getText().toString());
		i.putExtra("position", position);
		setResult(RESULT_OK, i);
		finish();
	}

}
