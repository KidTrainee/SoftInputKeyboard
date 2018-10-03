package vn.bfc.softinputkeyboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentParent extends Fragment {

    private FragmentContent fragmentContent;

    public static FragmentParent newInstance() {

        Bundle args = new Bundle();

        FragmentParent fragment = new FragmentParent();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);
        fragmentContent = FragmentContent.newInstance();
        getChildFragmentManager().beginTransaction().replace(R.id.fl_header, FragmentHeader.newInstance()).commit();
        getChildFragmentManager().beginTransaction().replace(R.id.fl_general_info, FragmentGeneralInfo.newInstance()).commit();
        getChildFragmentManager().beginTransaction().replace(R.id.fl_progress_container, fragmentContent).commit();
        getChildFragmentManager().beginTransaction().replace(R.id.fl_footer, FragmentFooter.newInstance()).commit();
        return view;
    }

    public void addFragment4() {
        getChildFragmentManager().beginTransaction()
                .hide(fragmentContent)
                .add(R.id.fl_progress_container, FragmentContent.newInstance())
                .commit();
    }
}
