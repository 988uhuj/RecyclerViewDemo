package github.chenupt.recyclerviewdemo.recyclerhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Base model view can show different item views.
 */
public abstract class BaseItemModel<T> extends FrameLayout {

    protected ItemEntity<T> model;
    protected List<ItemEntity<T>> modelList;
    protected int viewPosition;
    protected ItemEntity<T> groupModel;
    protected int groupPosition;

    protected BaseListAdapter adapter;
    protected RecyclerView.ViewHolder viewHolder;

    public BaseItemModel(Context context){
        this(context, null);
    }

    public BaseItemModel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public abstract void bindView();


    public void setModel(ItemEntity<T> model, List<ItemEntity<T>> modelList){
        if(this.model != null){
            // 判断数据是否唯一项，如果数据未过期则不进行bindView，显示缓存的view
            if (this.model.isSingleton() && this.model.getTimestamp() == model.getTimestamp()) {
                return ;
            }
        }

        this.model = model;
        this.modelList =  modelList;
        bindView();
    };

    public void setModel(ItemEntity<T> model){
        setModel(model, null);
    };

    public void setViewPosition(int position){
        this.viewPosition = position;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public void setGroupModel(ItemEntity<T> groupModel) {
        this.groupModel = groupModel;
    }

    public BaseListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(BaseListAdapter adapter) {
        this.adapter = adapter;
    }

    public void notifyDataSetChanged(){
        adapter.notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(RecyclerView.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }
}
