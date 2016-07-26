package mdl.sinlov.android.dapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * base adapter for ListView and grid view
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
 * Created by "sinlov" on 16/7/7.
 */
public abstract class MDLAdpater<B> extends BaseAdapter {

    protected final int mItemLayoutId;
    protected Context mContext;
    protected List<B> mDatas;
    protected OnMDLItemChildClickListener mOnItemChildClickListener;
    protected OnMDLItemChildLongClickListener mOnItemChildLongClickListener;
    protected OnMDLItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;

    public MDLAdpater(Context context, int itemLayoutId) {
        mContext = context;
        mItemLayoutId = itemLayoutId;
        mDatas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public B getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MDLAdapterViewHolder viewHolder = MDLAdapterViewHolder.dequeueReusableAdapterViewHolder(convertView, parent, mItemLayoutId);
        viewHolder.getViewHolderHelper().setPosition(position);
        viewHolder.getViewHolderHelper().setOnItemChildClickListener(mOnItemChildClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildLongClickListener(mOnItemChildLongClickListener);
        viewHolder.getViewHolderHelper().setOnItemChildCheckedChangeListener(mOnItemChildCheckedChangeListener);
        setItemChildListener(viewHolder.getViewHolderHelper());

        fillData(viewHolder.getViewHolderHelper(), position, getItem(position));
        return viewHolder.getConvertView();
    }

    /**
     * for user setting item child listener
     *
     * @param viewHolderHelper {@link MDLViewHolderHelper}
     */
    protected void setItemChildListener(MDLViewHolderHelper viewHolderHelper) {
    }

    /**
     * fill data
     *
     * @param viewHolderHelper {@link MDLViewHolderHelper}
     * @param position         int
     * @param model            Model
     */
    protected abstract void fillData(MDLViewHolderHelper viewHolderHelper, int position, B model);

    /**
     * @param onItemChildClickListener {@link OnMDLItemChildClickListener}
     */
    public void setOnItemChildClickListener(OnMDLItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    /**
     * @param onItemChildLongClickListener {@link OnMDLItemChildLongClickListener}
     */
    public void setOnItemChildLongClickListener(OnMDLItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    /**
     * @param onItemChildCheckedChangeListener {@link OnMDLItemChildCheckedChangeListener}
     */
    public void setOnItemChildCheckedChangeListener(OnMDLItemChildCheckedChangeListener onItemChildCheckedChangeListener) {
        mOnItemChildCheckedChangeListener = onItemChildCheckedChangeListener;
    }

    /**
     * get all data
     *
     * @return List<B>
     */
    public List<B> getDatas() {
        return mDatas;
    }

    /**
     * add data to head, most use in push to refresh
     *
     * @param datas List<B>
     */
    public void addHeadDatas(List<B> datas) {
        if (datas != null) {
            mDatas.addAll(0, datas);
            notifyDataSetChanged();
        }
    }

    /**
     * add data to last, most use in pull to load more
     *
     * @param datas List<B>
     */
    public void addMoreDatas(List<B> datas) {
        if (datas != null) {
            mDatas.addAll(mDatas.size(), datas);
            notifyDataSetChanged();
        }
    }

    /**
     * set New Data, if you want clear data, you can set null
     *
     * @param datas List<B>
     */
    public void setDatas(List<B> datas) {
        if (datas != null) {
            mDatas = datas;
        } else {
            mDatas.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * clear datas
     */
    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    /**
     * remove position in list
     *
     * @param position int
     */
    public void removeItem(int position) {
        mDatas.remove(position);
        notifyDataSetChanged();
    }

    /**
     * remove by model
     *
     * @param model model
     */
    public void removeItem(B model) {
        mDatas.remove(model);
        notifyDataSetChanged();
    }

    /**
     * add data in position with Model
     *
     * @param position int
     * @param model    Model
     */
    public void addItem(int position, B model) {
        mDatas.add(position, model);
        notifyDataSetChanged();
    }

    /**
     * add one item at first of list
     *
     * @param model Model
     */
    public void addFirstItem(B model) {
        addItem(0, model);
    }

    /**
     * add one item at last of list
     *
     * @param model Model
     */
    public void addLastItem(B model) {
        addItem(mDatas.size(), model);
    }

    /**
     * replace item at location by new model
     *
     * @param location int
     * @param newModel Model
     */
    public void replaceItem(int location, B newModel) {
        mDatas.set(location, newModel);
        notifyDataSetChanged();
    }

    /**
     * replace item at model by new model
     *
     * @param oldModel
     * @param newModel
     */
    public void replaceItem(B oldModel, B newModel) {
        replaceItem(mDatas.indexOf(oldModel), newModel);
    }

    /**
     * swap item from fromPosition to toPosition
     *
     * @param fromPosition int
     * @param toPosition   int
     */
    public void swapItem(int fromPosition, int toPosition) {
        Collections.swap(mDatas, fromPosition, toPosition);
        notifyDataSetChanged();
    }
}
