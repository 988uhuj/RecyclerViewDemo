package github.chenupt.recyclerviewdemo.recyclerhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenupt@gmail.com on 2014/5/18.
 * Description : Base list adapter with some functions
 */
public abstract class BaseListAdapter<T> extends RecyclerView.Adapter {

    protected List<T> list;
    protected List<T> lazyList;
    protected Context context;
    
    public BaseListAdapter(Context context) {
        list = new ArrayList<T>();
        lazyList = new ArrayList<T>();
        this.context = context;
    }

//    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList(){
        return list;
    }

    public void addList(List<T> list){
        if(list != null){
            this.list.addAll(list);
        }
    }

    public void addListToHead(List<T> list){
        if(list != null){
            this.list.addAll(0, list);
        }
    }

    public void removeList(List<T> list){
        this.list.removeAll(list);
    }


    /**
     * 将缓存的数据添加到list
     */
    public void addLazyDataToList(){
        this.list.addAll(lazyList);
    }

    /**
     * 保存缓存数据
     * @param list
     */
    public void saveLazyList(List<T> list){
        if(list != null){
            this.lazyList = list;
        }
    }

    public void addItem(T item){
        this.list.add(item);
    }

    public void clearList(){
        this.list.clear();
    }
    
    public void remove(int position){
    	this.list.remove(position);
    }

    public void remove(T item){
        this.list.remove(item);
    }
    
    public Context getContext(){
    	return context;
    }
}
