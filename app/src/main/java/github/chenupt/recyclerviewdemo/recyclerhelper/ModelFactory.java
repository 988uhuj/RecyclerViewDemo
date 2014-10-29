package github.chenupt.recyclerviewdemo.recyclerhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by chenupt@gmail.com on 14/10/28.
 * Description : view的生成和使用管理
 */
public class ModelFactory {

    public static final String TAG = "ModelFactory";

    public Builder builder;

    protected ModelFactory(Builder builder) {
        this.builder = builder;
    }

    public RecyclerView.ViewHolder createModel(Context context, Class<?> owner, BaseListAdapter adapter){
        Log.d(TAG, "createModel: " + owner.getName());
        BaseItemModel baseItemModel = null;
        try {
            // 抽出实例化方法让子类可覆盖
            baseItemModel = newInstance(context, owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelViewHolder(baseItemModel, adapter);
    }

    /**
     * 子类可复写此方法来实现不同的实例化
     * @param context
     * @param owner
     * @return
     * @throws Exception
     */
    protected BaseItemModel newInstance(Context context, Class<?> owner) throws Exception {
        return (BaseItemModel) owner.getConstructor(Context.class).newInstance(context);
    }

    /**
     * 通过模板类型获取模板指针
     * @param modelType
     * @return
     */
    public int getViewType(String modelType){
        if( !builder.indexMap.containsKey(modelType)){
            Log.d(TAG, builder.indexMap.toString());
            throw new RuntimeException("The list does not contain the modelView:'" + modelType + "'. Please check the ModelFactory.");
        }
        Log.d(TAG, "getViewType:" + builder.indexMap.get(modelType));
        return builder.indexMap.get(modelType);
    }

    /**
     * 通过模板类型获取模板
     * @param viewType
     * @return
     */
    public Class<?> getViewClass(int viewType){
        return builder.iViewMap.get(viewType);
    }

    /**
     * 获取模板数量
     * @return
     */
    public int getViewTypeCount(){
        Log.d(TAG, "getViewTypeCount:" + builder.viewMap.size());
        return builder.viewMap.size();
    }

    /**
     * 当前模板是否可以固定头部
     * @param type
     * @return
     */
    public boolean isItemViewTypePinned(int type){
        return builder.pinnedMap.get(type);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 创建ModelFactory需添加Model
    ///////////////////////////////////////////////////////////////////////////

    public static class Builder{

        private HashMap<String, Class<?>> viewMap;  // 模板类型 -> 模板展示View
        private HashMap<String, Integer> indexMap;  // 模板类型 -> 模板指针
        private HashMap<Integer, Boolean> pinnedMap;// 模板指针 -> View是否固定
        private HashMap<Integer, Class<?>> iViewMap;// 模板指针 -> 模板展示View

        public Builder() {
            viewMap = new HashMap<String, Class<?>>();
            indexMap = new HashMap<String, Integer>();
            pinnedMap = new HashMap<Integer, Boolean>();
            iViewMap = new HashMap<Integer, Class<?>>();
        }

        public ModelFactory build(){
            return new ModelFactory(this);
        }

        public Builder addModel(Class<?> viewClass){
            return addModel(viewClass, false);
        }

        public Builder addModel(Class<?> viewClass, boolean isPinned){
            return addToMap(getModelTypeName(viewClass), viewClass, isPinned);
        }

        public Builder addModel(String modelType, Class<?> viewClass){
            return addModel(modelType, viewClass, false);
        }

        public Builder addModel(String modelType, Class<?> viewClass, boolean isPinned){
            return addToMap(modelType, viewClass, isPinned);
        }

        private Builder addToMap(String modelType, Class<?> viewClass, boolean isPinned){
            if(!viewMap.containsKey(modelType)){
                viewMap.put(modelType, viewClass);
                int viewType = viewMap.size() - 1;
                indexMap.put(modelType, viewType);
                pinnedMap.put(viewType , isPinned);
                iViewMap.put(viewType, viewClass);
            }
            return this;
        }


        private String getModelTypeName(Class<?> modelView){
            return modelView.getName();
        }

    }

}
