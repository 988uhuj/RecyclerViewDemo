package github.chenupt.recyclerviewdemo.recyclerhelper;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by chenupt@gmail.com on 14/10/28.
 * Description : simple model view holder
 */
public class ModelViewHolder extends RecyclerView.ViewHolder {

    private BaseItemModel baseItemModel;

    public ModelViewHolder(View itemView, BaseListAdapter adapter) {
        super(itemView);
        baseItemModel = (BaseItemModel) itemView;
        baseItemModel.setViewHolder(this);
        baseItemModel.setAdapter(adapter);
    }


    public void bindView(){
        baseItemModel.bindView();
    }

    public BaseItemModel getView(){
        return baseItemModel;
    }


}
