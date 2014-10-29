package github.chenupt.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import github.chenupt.recyclerviewdemo.recyclerhelper.ModelAdapter;
import github.chenupt.recyclerviewdemo.service.ModelService;

/**
 * Demo
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find view
        ModelService modelService = new ModelService();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // init recycler view
        ModelAdapter adapter = new ModelAdapter(this, modelService.getModelFactory());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        // set data source
        adapter.setList(modelService.getModelList());
        adapter.notifyDataSetChanged();
    }

}
