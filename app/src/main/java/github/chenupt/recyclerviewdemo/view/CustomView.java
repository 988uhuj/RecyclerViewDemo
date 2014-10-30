package github.chenupt.recyclerviewdemo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import github.chenupt.recyclerviewdemo.R;
import github.chenupt.recyclerviewdemo.recyclerhelper.BaseItemModel;

/**
 * Created by chenupt@gmail.com on 14/10/28.
 * Description :
 */
public class CustomView extends BaseItemModel {

    private Button btn;
    private TextView textView;

    public CustomView(Context context) {
        super(context);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.item_view, this);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyDataSetChanged();
            }
        });
        textView = (TextView) findViewById(R.id.text_view);

    }

    @Override
    public void bindView() {
        textView.setText(getViewHolder().getPosition() + "");
    }
}
