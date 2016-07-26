package mdl.sinlov.android.dapter.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * Created by "sinlov" on 16/7/26.
 */
public class MDLAdapterViewHolder {
    protected View mConvertView;
    protected MDLViewHolderHelper mViewHolderHelper;

    private MDLAdapterViewHolder(ViewGroup parent, int layoutId) {
        mConvertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
        mViewHolderHelper = new MDLViewHolderHelper(parent, mConvertView);
    }

    /**
     * get one view holder object
     *
     * @param convertView {@link View}
     * @param parent      {@link ViewGroup}
     * @param layoutId    id
     * @return {@link MDLViewHolderHelper}
     */
    public static MDLAdapterViewHolder dequeueReusableAdapterViewHolder(View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new MDLAdapterViewHolder(parent, layoutId);
        }
        return (MDLAdapterViewHolder) convertView.getTag();
    }

    public MDLViewHolderHelper getViewHolderHelper() {
        return mViewHolderHelper;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
