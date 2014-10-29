package github.chenupt.recyclerviewdemo.recyclerhelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenupt@gmail.com on 2014/8/13.
 * Description : SimpleEntity for list item
 */
public class ItemEntity<T> implements Serializable{

    private long id;
    /**
     * 模板显示内容数据
     */
    private T content;
    /**
     * 当前项是否选中
     */
    private boolean isCheck;
    /**
     * 当前状态
     */
    private int status;
    /**
     * 模板类型，默认使用类名
     */
    private String modelType;
    /**
     * 模板显示view
     */
    private Class<?> modelView;
    /**
     * 数据缓存时间戳
     */
    private long timestamp;
    /**
     * 额外保存的数据
     */
    private Object extraData;

    /**
     * 该数据是否在列表中只有一条
     * 设置true时，列表只进行一次bingView，从而提高列表滑动效率
     */
    private boolean isSingleton;

    public ItemEntity() {
        // 默认设置数据缓存时间为当前时间戳
        setTimestamp(System.currentTimeMillis());
    }

    public ItemEntity(T t) {
        this.content = t;
        // 默认设置数据缓存时间为当前时间戳
        setTimestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public ItemEntity setId(long id) {
        this.id = id;
        return this;
    }

    public T getContent() {
        return content;
    }

    public ItemEntity setContent(T content) {
        this.content = content;
        return this;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public ItemEntity setCheck(boolean isCheck) {
        this.isCheck = isCheck;
        return this;
    }

    public ItemEntity setStatus(int status){
        this.status = status;
        return this;
    }

    public int getStatus(){
        return this.status;
    }

    public String getModelType() {
        return modelType;
    }

    public ItemEntity setModelType(String modelType) {
        this.modelType = modelType;
        return this;
    }

    public Class<?> getModelView() {
        return modelView;
    }

    public ItemEntity setModelView(Class<?> modelView) {
        // 未设置模板类型时
        if(modelType == null){
            // 默认使用类名做modelType
            setModelType(modelView.getName());
        }
        this.modelView = modelView;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    /**
     * 当数据为singleton时，可传递从服务端获取而来的timestamp，可不传
     * @param timestamp
     */
    public ItemEntity setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    /**
     * 设置该数据显示的view是否在列表中唯一，例如海报位
     * @param isSingleton
     */
    public ItemEntity setSingleton(boolean isSingleton) {
        this.isSingleton = isSingleton;
        return this;
    }

    public Object getExtraData() {
        return extraData;
    }

    public ItemEntity setExtraData(Object extraData) {
        this.extraData = extraData;
        return this;
    }

    public void attach(List<ItemEntity> list){
        list.add(this);
    }
}
