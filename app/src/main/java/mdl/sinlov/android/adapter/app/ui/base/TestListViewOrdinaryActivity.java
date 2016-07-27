package mdl.sinlov.android.adapter.app.ui.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mdl.sinlov.android.adapter.app.R;
import mdl.sinlov.android.adapter.app.adpater.OrdinaryListViewAdapter;
import mdl.sinlov.android.adapter.app.module.ItemOrdinary;
import mdl.sinlov.android.adapter.app.ui.MDLTestActivity;
import mdl.sinlov.android.adapter.app.utils.RandomString;

public class TestListViewOrdinaryActivity extends MDLTestActivity {

    @BindView(R.id.adapter_clear_item)
    Button adapterClearItem;
    @BindView(R.id.adapter_add_item)
    Button adapterAddItem;
    @BindView(R.id.adapter_add_item_first)
    Button adapterAddItemFirst;
    @BindView(R.id.adapter_add_item_last)
    Button adapterAddItemLast;
    @BindView(R.id.adapter_remove_item)
    Button adapterRemoveItem;
    @BindView(R.id.adapter_replace_item)
    Button adapterReplaceItem;
    @BindView(R.id.adapter_swapItem_item)
    Button adapterSwapItemItem;
    @BindView(R.id.adapter_add_head_datas)
    Button adapterAddHeadDatas;
    @BindView(R.id.adapter_add_more_datas)
    Button adapterAddMoreDatas;
    @BindView(R.id.lv_base_test)
    ListView lvBaseTest;

    private List<ItemOrdinary> datasInit;
    private OrdinaryListViewAdapter adapter;


    private void initTextData() {
        datasInit = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemOrdinary item = new ItemOrdinary();
            item.setCheck(false);
            item.setId(i);
            item.setTitle("Title: " + i);
            item.setContent(RandomString.generateMixString(240));
            datasInit.add(item);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initTextData();
        setContentView(R.layout.activity_test_list_view_ordinary);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter = new OrdinaryListViewAdapter(this);
    }

    @Override
    protected void bindListener() {
        lvBaseTest.setAdapter(adapter);
        adapter.addHeadDatas(datasInit);
    }

    @OnClick({R.id.adapter_clear_item, R.id.adapter_add_item, R.id.adapter_add_item_first, R.id.adapter_add_item_last, R.id.adapter_remove_item, R.id.adapter_replace_item, R.id.adapter_swapItem_item, R.id.adapter_add_head_datas, R.id.adapter_add_more_datas})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.adapter_clear_item:
                break;
            case R.id.adapter_add_item:
                break;
            case R.id.adapter_add_item_first:
                break;
            case R.id.adapter_add_item_last:
                break;
            case R.id.adapter_remove_item:
                break;
            case R.id.adapter_replace_item:
                break;
            case R.id.adapter_swapItem_item:
                break;
            case R.id.adapter_add_head_datas:
                break;
            case R.id.adapter_add_more_datas:
                break;
        }
    }

}
