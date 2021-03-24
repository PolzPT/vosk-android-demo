package org.kaldi.demo;

import android.app.Activity;
import android.os.Bundle;

public class SignUpForm extends Activity {
    private String mTag = "signinform";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mTag);
    }

    private void setContentView(String tag) {
        int id = getResources().getIdentifier(tag, "layout", getPackageName());
        setContentView(id);
    }

}
