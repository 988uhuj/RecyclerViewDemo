package github.chenupt.recyclerviewdemo.recyclerhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by chenupt@gmail.com on 14/10/28.
 * Description : Recycler adapter
 */
public class ModelAdapter extends BaseListAdapter<ItemEntity> {
    private static final String TAG = "ModelAdapter";

    private ModelFactory modelFactory;

    public ModelAdapter(Context context, ModelFactory modelFactory) {
        super(context);
        this.modelFactory = modelFactory;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder: type=" + viewType);
        RecyclerView.ViewHolder viewHolder = modelFactory.createModel(getContext(), modelFactory.getViewClass(viewType), this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: position=" + position);
        ((ModelViewHolder)viewHolder).getView().setModel(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        String type = getItem(position).getModelType();
        return modelFactory.getViewType(type);
    }


}
