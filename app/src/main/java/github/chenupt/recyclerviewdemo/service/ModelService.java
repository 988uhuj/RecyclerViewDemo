package github.chenupt.recyclerviewdemo.service;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.recyclerviewdemo.view.CustomView;
import github.chenupt.recyclerviewdemo.recyclerhelper.AAModelFactory;
import github.chenupt.recyclerviewdemo.recyclerhelper.ItemEntity;
import github.chenupt.recyclerviewdemo.recyclerhelper.ItemEntityCreator;
import github.chenupt.recyclerviewdemo.recyclerhelper.ModelFactory;

/**
 * Created by chenupt@gmail.com on 14/10/28.
 * Description : model service
 */
public class ModelService {

    public ModelFactory getModelFactory(){
        ModelFactory modelFactory = new AAModelFactory.Builder()
                .addModel(CustomView.class)
                .build();
        return modelFactory;
    }

    // test
    public List<ItemEntity> getModelList(){
        List<ItemEntity> list = new ArrayList<ItemEntity>();
        for (int i = 0; i < 10; i++) {
            ItemEntityCreator.create("").setModelView(CustomView.class).attach(list);
        }
        return list;
    }

}
