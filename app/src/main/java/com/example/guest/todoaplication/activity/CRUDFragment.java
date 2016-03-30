package com.example.guest.todoaplication.activity;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.todoaplication.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRUDFragment extends DialogFragment implements View.OnClickListener {
    @Bind(R.id.detailTitle) TextView mDetailTitleTextView;
    @Bind(R.id.detailDescription) TextView mDetailDescriptionTextView;
    @Bind(R.id.detailCategory) TextView mDetailCategoryTextView;
    @Bind(R.id.detailEdit) Button mDetailEditButton;
    @Bind(R.id.detailDelete) Button mDetailDeleteButton;
    Bundle bundle;

    public CRUDFragment() {
        // Required empty public constructor
    }


    public static CRUDFragment newInstance() {
        return new CRUDFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crud, container, false);
        ButterKnife.bind(this, view);
        bundle = getArguments();
        if (bundle == null) {
            return view;
        } else {
            mDetailTitleTextView.setText(bundle.get("title").toString());
            mDetailDescriptionTextView.setText(bundle.get("description").toString());
            mDetailCategoryTextView.setText(bundle.get("category").toString());
            mDetailEditButton.setOnClickListener(this);
            mDetailDeleteButton.setOnClickListener(this);
            return view;
        }
    }


    @Override
    public void onClick(View v) {
        if (v == mDetailEditButton) {

            dismiss();
        }
        if (v == mDetailDeleteButton) {
            String uuid = bundle.get("uuid").toString();
            Firebase firebaseRef = new Firebase("https://epicodustodoapp.firebaseio.com/tasks/" + uuid);
            firebaseRef.removeValue();
            dismiss();
        }
    }
}
