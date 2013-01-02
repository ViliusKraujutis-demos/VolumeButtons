
package lt.andro.volumebuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int mVolumeValue = 0;
    private static final String EXTRA_VOLUME_VALUE = "EXTRA_VOLUME_VALUE";
    private TextView mMainTotalValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mVolumeValue = savedInstanceState.getInt(EXTRA_VOLUME_VALUE, 0);
        }

        mMainTotalValueTV = (TextView)findViewById(R.id.mainTotalValue);
        mMainTotalValueTV.setText("" + mVolumeValue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
     */
    @Override
    protected void onSaveInstanceState(Bundle pOutState) {
        pOutState.putInt(EXTRA_VOLUME_VALUE, mVolumeValue);
        super.onSaveInstanceState(pOutState);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
     */
    @Override
    public boolean onKeyDown(int pKeyCode, KeyEvent pEvent) {
        switch (pKeyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                mMainTotalValueTV.setText("" + --mVolumeValue);
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:

                mMainTotalValueTV.setText("" + ++mVolumeValue);
                break;

            default:
                break;
        }
        return super.onKeyDown(pKeyCode, pEvent);
    }

}
