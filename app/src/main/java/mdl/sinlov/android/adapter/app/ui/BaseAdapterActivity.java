package mdl.sinlov.android.adapter.app.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mdl.sinlov.android.adapter.app.R;
import mdl.sinlov.android.adapter.app.ui.base.TestGridViewOrdinaryActivity;
import mdl.sinlov.android.adapter.app.ui.base.TestListViewOrdinaryActivity;

public class BaseAdapterActivity extends MDLTestActivity {


    @BindView(R.id.btn_base_adapter_list_view_ordinary)
    Button btnBaseAdapterListViewOrdinary;
    @BindView(R.id.btn_base_adapter_grid_view_ordinary)
    Button btnBaseAdapterGridViewOrdinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_base_adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void bindListener() {

    }

    @OnClick({R.id.btn_base_adapter_list_view_ordinary, R.id.btn_base_adapter_grid_view_ordinary})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_base_adapter_list_view_ordinary:
                skip2Activity(TestListViewOrdinaryActivity.class);
                break;
            case R.id.btn_base_adapter_grid_view_ordinary:
                skip2Activity(TestGridViewOrdinaryActivity.class);
                break;
        }
    }
}
