package mdl.sinlov.android.adapter.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.text.Html;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

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
public class MDLViewHolderHelper implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {
    protected final SparseArray<View> mViews;
    protected OnMDLItemChildClickListener mOnItemChildClickListener;
    protected OnMDLItemChildLongClickListener mOnItemChildLongClickListener;
    protected OnMDLItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;
    protected View mConvertView;
    protected Context mContext;
    protected int mPosition;
    protected ViewGroup mAdapterView;
    /**
     * to more obj
     */
    protected Object mObj;

    public MDLViewHolderHelper(ViewGroup adapterView, View convertView) {
        mViews = new SparseArray<>();
        mAdapterView = adapterView;
        mConvertView = convertView;
        mContext = convertView.getContext();
    }


    public void setPosition(int position) {
        mPosition = position;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setOnItemChildClickListener(OnMDLItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setItemChildClickListener(@IdRes int viewId) {
        getView(viewId).setOnClickListener(this);
    }

    public void setOnItemChildLongClickListener(OnMDLItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public void setItemChildLongClickListener(@IdRes int viewId) {
        getView(viewId).setOnLongClickListener(this);
    }


    public void setOnItemChildCheckedChangeListener(OnMDLItemChildCheckedChangeListener onItemChildCheckedChangeListener) {
        mOnItemChildCheckedChangeListener = onItemChildCheckedChangeListener;
    }

    public void setItemChildCheckedChangeListener(@IdRes int viewId) {
        if (getView(viewId) instanceof CompoundButton) {
            ((CompoundButton) getView(viewId)).setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemChildClickListener != null) {
            if (mAdapterView != null) {
                mOnItemChildClickListener.onItemChildClick(mAdapterView, v, getPosition());
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemChildLongClickListener != null) {
            if (mAdapterView != null) {
                return mOnItemChildLongClickListener.onItemChildLongClick(mAdapterView, v, getPosition());
            }
        }
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (mOnItemChildCheckedChangeListener != null) {
            if (mAdapterView != null) {
                mOnItemChildCheckedChangeListener.onItemChildCheckedChanged(mAdapterView, buttonView, getPosition(), isChecked);
            }
        }
    }

    /**
     * get View by ID, if not in mViews, will add to mView by rootView
     *
     * @param viewId int
     * @return T
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * get ImageView by ID
     *
     * @param viewId id
     * @return {@link ImageView}
     */
    public ImageView getImageView(@IdRes int viewId) {
        return getView(viewId);
    }

    /**
     * get TextView by ID
     *
     * @param viewId id
     * @return {@link TextView}
     */
    public TextView getTextView(@IdRes int viewId) {
        return getView(viewId);
    }

    /**
     * convert view
     *
     * @return {@link View}
     */
    public View getConvertView() {
        return mConvertView;
    }

    public void setObj(Object obj) {
        mObj = obj;
    }

    public Object getObj() {
        return mObj;
    }

    /**
     * set Text by text view
     *
     * @param viewId id
     * @param text   {@link TextView}
     * @return
     */
    public MDLViewHolderHelper setText(@IdRes int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * set Text by string id
     * @param viewId id
     * @param stringResId R.string.id
     * @return
     */
    public MDLViewHolderHelper setText(@IdRes int viewId, @StringRes int stringResId) {
        TextView view = getView(viewId);
        view.setText(stringResId);
        return this;
    }

    /**
     * set html to TextView
     * @param viewId
     * @param source html文本
     * @return
     */
    public MDLViewHolderHelper setHtml(@IdRes int viewId, String source) {
        TextView view = getView(viewId);
        view.setText(Html.fromHtml(source));
        return this;
    }

    /**
     * set Checkable view by iad
     * @param viewId id
     * @param checked boolean
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setChecked(@IdRes int viewId, boolean checked) {
        Checkable view = getView(viewId);
        view.setChecked(checked);
        return this;
    }

    public MDLViewHolderHelper setTag(@IdRes int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public MDLViewHolderHelper setTag(@IdRes int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public MDLViewHolderHelper setVisibility(@IdRes int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public MDLViewHolderHelper setImageBitmap(@IdRes int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public MDLViewHolderHelper setImageDrawable(@IdRes int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * set TextView color by color id
     * @param viewId id
     * @param textColorResId R.color.id
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setTextColorRes(@IdRes int viewId, @ColorRes int textColorResId) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorResId));
        return this;
    }

    /**
     * set TextView color by color Number
     * @param viewId id
     * @param textColor color number
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setTextColor(@IdRes int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * set View Background by id
     * @param viewId id
     * @param backgroundResId R.dr
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setBackgroundRes(@IdRes int viewId, int backgroundResId) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundResId);
        return this;
    }

    /**
     * @param viewId id
     * @param color  color number
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setBackgroundColor(@IdRes int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * @param viewId id
     * @param colorResId R.color.id
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setBackgroundColorRes(@IdRes int viewId, @ColorRes int colorResId) {
        View view = getView(viewId);
        view.setBackgroundColor(mContext.getResources().getColor(colorResId));
        return this;
    }

    /**
     *
     * @param viewId id
     * @param imageResId R.drawable.id
     * @return {@link MDLViewHolderHelper}
     */
    public MDLViewHolderHelper setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

}
