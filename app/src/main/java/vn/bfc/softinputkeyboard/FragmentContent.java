package vn.bfc.softinputkeyboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class FragmentContent extends Fragment {

    RecyclerView rc;
    private Button btn;
    private FragmentParent fragmentParent;

    public static FragmentContent newInstance() {

        Bundle args = new Bundle();

        FragmentContent fragment = new FragmentContent();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        fragmentParent = (FragmentParent) getParentFragment();

        LinearLayout ll = view.findViewById(R.id.ll);

        rc = view.findViewById(R.id.rc);
        btn = view.findViewById(R.id.activity_report_palette_btn_done);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentParent.addFragment4();
            }
        });
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        ViewAdapter adapter = new ViewAdapter();
        rc.setAdapter(adapter);

        for (int i = 0; i < 15; i++) {
            View child = inflater.inflate(R.layout.list, ll, false);
            ll.addView(child);
        }
        return view;
    }


    private class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.list1, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
