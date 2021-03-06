package mdl.sinlov.android.adapter.app.ui.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import mdl.sinlov.android.adapter.base.OnMDLItemChildClickListener;
import mdl.sinlov.android.adapter.base.OnMDLItemChildLongClickListener;

public class TestListViewOrdinaryActivity extends MDLTestActivity {

    @BindView(R.id.btn_adapter_clear_item)
    Button adapterClearItem;
    @BindView(R.id.btn_adapter_add_item)
    Button adapterAddItem;
    @BindView(R.id.btn_adapter_add_item_first)
    Button adapterAddItemFirst;
    @BindView(R.id.btn_adapter_add_item_last)
    Button adapterAddItemLast;
    @BindView(R.id.btn_adapter_remove_item)
    Button adapterRemoveItem;
    @BindView(R.id.btn_adapter_replace_item)
    Button adapterReplaceItem;
    @BindView(R.id.btn_adapter_swapItem_item)
    Button adapterSwapItemItem;
    @BindView(R.id.btn_adapter_add_head_datas)
    Button adapterAddHeadDatas;
    @BindView(R.id.btn_adapter_add_more_datas)
    Button adapterAddMoreDatas;
    @BindView(R.id.lv_base_test)
    ListView lvBaseTest;
    @BindView(R.id.btn_adapter_reset_all)
    Button adapterResetAll;

    private OrdinaryListViewAdapter adapter;
    private List<ItemOrdinary> datasInit;
    private List<ItemOrdinary> datasFirst;
    private List<ItemOrdinary> datasMore;
    private ItemOrdinary dataFirst;
    private ItemOrdinary dataLast;
    private ItemOrdinary dataNew;


    private void initTestData() {
        datasInit = generateDatas(20, "Title: ");
        datasFirst = generateDatas(2, "First datas Title: ");
        datasMore = generateDatas(2, "More datas Title: ");
        dataFirst = generateData(0, "First item");
        dataLast = generateData(0, "Last item");
        dataNew = generateData(0, "New item");
    }

    private ArrayList<ItemOrdinary> generateDatas(int size, String titleMsg) {
        ArrayList<ItemOrdinary> datas = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ItemOrdinary item = new ItemOrdinary();
            item.setCheck(false);
            item.setIdView(i);
            item.setTitle(titleMsg + i);
            item.setContent(RandomString.generateMixString(120));
            datas.add(item);
        }
        return datas;
    }

    private ItemOrdinary generateData(int idView, String titleMsg) {
        ItemOrdinary item = new ItemOrdinary();
        item.setCheck(false);
        item.setTitle(titleMsg);
        item.setIdView(idView);
        item.setContent(RandomString.generateMixString(120));
        return item;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initTestData();
        setContentView(R.layout.activity_test_list_view_ordinary);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adapter = new OrdinaryListViewAdapter(this);
        lvBaseTest.setAdapter(adapter);
        adapter.addHeadDatas(datasInit);
    }

    @Override
    protected void bindListener() {
        lvBaseTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String result = "onItemClick Msg:\n" + adapter.getDatas().get(position).getTitle();
                showToast(result);
            }
        });
        adapter.setOnItemChildClickListener(new OnMDLItemChildClickListener() {
            @Override
            public void onItemChildClick(ViewGroup parent, View childView, int position) {
                String result = "onItemChildClick Msg:\n" + adapter.getDatas().get(position).getTitle();
                showToast(result);
            }
        });
        lvBaseTest.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String result = "onItemLongClick Msg:\n" + adapter.getDatas().get(position).getTitle();
                showToast(result);
                return true;
            }
        });
        adapter.setOnItemChildLongClickListener(new OnMDLItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(ViewGroup parent, View childView, int position) {
                String result = "onItemChildLongClick Msg:\n" + adapter.getDatas().get(position).getTitle();
                showToast(result);
                return true;
            }
        });
    }

    @OnClick({R.id.btn_adapter_clear_item, R.id.btn_adapter_reset_all, R.id.btn_adapter_add_item, R.id.btn_adapter_add_item_first, R.id.btn_adapter_add_item_last, R.id.btn_adapter_remove_item, R.id.btn_adapter_replace_item, R.id.btn_adapter_swapItem_item, R.id.btn_adapter_add_head_datas, R.id.btn_adapter_add_more_datas})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_adapter_reset_all:
                adapter.clear();
                adapter.setDatas(datasInit);
                break;
            case R.id.btn_adapter_clear_item:
                adapter.clear();
                break;
            case R.id.btn_adapter_add_item:
                adapter.addItem(0, dataNew);
                break;
            case R.id.btn_adapter_remove_item:
                if (adapter.getCount() > 1) {
                    adapter.removeItem(1);
                    showToast("remove success!");
                } else {
                    showToast("no item 2 to replace");
                }
                break;
            case R.id.btn_adapter_replace_item:
                if (adapter.getCount() > 1) {
                    ItemOrdinary dataOld = adapter.getItem(1);
                    adapter.replaceItem(dataOld, generateData(0, "replace item"));
                    showToast("replace success!");
                } else {
                    showToast("no item 2 to replace");
                }
                break;
            case R.id.btn_adapter_swapItem_item:
                if (adapter.getCount() > 3) {
                    adapter.swapItem(1, 2);
                    showToast("swap success!");
                } else {
                    showToast("must has 3 item to test");
                }
                break;
            case R.id.btn_adapter_add_head_datas:
                adapter.addHeadDatas(datasFirst);
                break;
            case R.id.btn_adapter_add_more_datas:
                adapter.addMoreDatas(datasMore);
                break;
            case R.id.btn_adapter_add_item_first:
                adapter.addFirstItem(dataFirst);
                break;
            case R.id.btn_adapter_add_item_last:
                adapter.addLastItem(dataLast);
                break;
        }
    }
}
