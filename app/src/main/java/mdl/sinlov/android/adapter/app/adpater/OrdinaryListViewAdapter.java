package mdl.sinlov.android.adapter.app.adpater;

import android.content.Context;

import mdl.sinlov.android.adapter.app.R;
import mdl.sinlov.android.adapter.app.module.ItemOrdinary;
import mdl.sinlov.android.adapter.base.MDLAdpater;
import mdl.sinlov.android.adapter.base.MDLViewHolderHelper;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by "sinlov" on 16/7/27.
 */
public class OrdinaryListViewAdapter extends MDLAdpater<ItemOrdinary> {

    public OrdinaryListViewAdapter(Context context) {
        super(context, R.layout.item_horizontal_ordinary);
    }

    @Override
    protected void fillData(MDLViewHolderHelper helper, int position, ItemOrdinary model) {
        helper.setText(R.id.tv_item_horizontal_title, model.getTitle());
        helper.setText(R.id.tv_item_horizontal_content, model.getContent());
        helper.setItemChildClickListener(R.id.btn_item_submit);
        helper.setItemChildLongClickListener(R.id.btn_item_submit);
    }
}
