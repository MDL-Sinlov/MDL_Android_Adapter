package mdl.sinlov.android.adapter.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mdl.sinlov.android.adapter.app.ui.BaseAdapterActivity;
import mdl.sinlov.android.adapter.app.ui.MDLTestActivity;

public class MainActivity extends MDLTestActivity {

    @BindView(R.id.btn_main_base_adapter)
    Button btnMainBaseAdapter;
    @BindView(R.id.btn_main_recycle_adapter)
    Button btnMainRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void bindListener() {

    }

    @OnClick({R.id.btn_main_base_adapter, R.id.btn_main_recycle_adapter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_base_adapter:
                skip2Activity(BaseAdapterActivity.class);
                break;
            case R.id.btn_main_recycle_adapter:
                break;
        }
    }
}
