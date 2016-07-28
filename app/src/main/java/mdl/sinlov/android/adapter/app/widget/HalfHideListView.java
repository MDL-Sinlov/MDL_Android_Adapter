package mdl.sinlov.android.adapter.app.widget;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Half Hide ListView
 * @author sinlov
 */
public class HalfHideListView extends ListView {

    private final int LIST_SHOW_DEFAULT_NUM = 5;
    private boolean isFullHeight = false;
    private int listShowNum = 0;
    private int mPosition;

    public HalfHideListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public HalfHideListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HalfHideListView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isFullHeight) {
            int expandSpec = makeMeasureSpecSize(Integer.MAX_VALUE >> 2);
            super.onMeasure(widthMeasureSpec, expandSpec);
        } else {
            int expandSpecHalf;
            if (listShowNum == 0) {
                int tempHeight = getHalfHideListChildViewHeight(0, LIST_SHOW_DEFAULT_NUM);
                expandSpecHalf = makeMeasureSpecSize(tempHeight);
            } else {
                int tempHeight = getHalfHideListChildViewHeight(0, listShowNum);
                expandSpecHalf = makeMeasureSpecSize(tempHeight);
            }
            super.onMeasure(widthMeasureSpec, expandSpecHalf);
        }
    }

    private static int makeMeasureSpecSize(int numberCount) {
        return MeasureSpec.makeMeasureSpec(numberCount, MeasureSpec.AT_MOST);
    }

    public boolean isFullHeight() {
        return isFullHeight;
    }

    public void setFullHeight(boolean isFullHeight) {
        this.isFullHeight = isFullHeight;
    }

    public int getListShowNum() {
        return listShowNum;
    }

    /**
     * set how many item when list hiding.
     * @param listShowNum int
     */
    public void setListShowNum(int listShowNum) {
        this.listShowNum = listShowNum;
    }

    @Override
    public void setCacheColorHint(int color) {
        super.setCacheColorHint(Color.argb(0, 0, 0, 0));
    }

    @Override
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        super.setVerticalScrollBarEnabled(false);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int actionMasked = ev.getActionMasked() & MotionEvent.ACTION_MASK;
        // recording position of the finger when pressed
        if (actionMasked == MotionEvent.ACTION_DOWN) {
            mPosition = pointToPosition((int) ev.getX(), (int) ev.getY());
            return super.dispatchTouchEvent(ev);
        }

        if (actionMasked == MotionEvent.ACTION_MOVE) {
            // Ignore MOVE event, ListView onTouch get less MOVE event so it will not roll processing occurs
            return true;
        }

        // when your finger lift
        if (actionMasked == MotionEvent.ACTION_UP
                || actionMasked == MotionEvent.ACTION_CANCEL) {
            // Press the fingers are lifted in the same view, to the parent control processing, which is one click event
            if (pointToPosition((int) ev.getX(), (int) ev.getY()) == mPosition) {
                super.dispatchTouchEvent(ev);
            } else {
                // If the finger has moved Item pressed, indicating that the scrolling behavior, cleaning Item pressed state
                setPressed(false);
                invalidate();
                return true;
            }
        }

        return super.dispatchTouchEvent(ev);
    }

    /**
     * get ListView child height
     * <li> if set endPosition is over the size of adapter, it will use size of adapter
     *
     * @param beginPosition int
     * @param endPosition int
     */
    public int getHalfHideListChildViewHeight(int beginPosition, int endPosition) {
        int listViewShowHeight = 0;
        int adapterCount = getAdapter().getCount();
        if (endPosition < adapterCount) {
            for (int i = beginPosition; i < endPosition; i++) {
                View temp = getAdapter().getView(i, null, null);
                temp.measure(0, 0);
                listViewShowHeight += temp.getMeasuredHeight();
            }
        } else {
            for (int i = beginPosition; i < adapterCount; i++) {
                View temp = getAdapter().getView(i, null, null);
                temp.measure(0, 0);
                listViewShowHeight += temp.getMeasuredHeight();
            }
        }
        return listViewShowHeight;
    }
}
