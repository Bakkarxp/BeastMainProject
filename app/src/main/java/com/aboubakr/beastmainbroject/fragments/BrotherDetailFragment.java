package com.aboubakr.beastmainbroject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherDetailFragment extends BaseFragment {

    //region view binding
    @BindView(R.id.fragment_brother_detail_imageView)
    ImageView picture;

    @BindView(R.id.fragment_brother_detail_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.fragment_brother_detail_crossSemester)
    TextView crossSemester;

    @BindView(R.id.fragment_brother_detail_funFact)
    TextView funFact;

    @BindView(R.id.fragment_brother_detail_major)
    TextView major;

    @BindView(R.id.fragment_brother_detail_name)
    TextView name;

    @BindView(R.id.fragment_brother_detail_whyJoined)
    TextView whyJoined;
    //endregion


    // brother that displayed in the fragment
    private Brother brother;

    // used as a key in the bundle
    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    // create instance of the fragment, brother object passed as parameter
    public static BrotherDetailFragment newInstance(Brother brother) {
        Bundle arguments = new Bundle();
        // put brother object in Bundle
        arguments.putParcelable(BROTHER_EXTRA_INFO, brother);
        BrotherDetailFragment fragment = new BrotherDetailFragment();
        fragment.setArguments(arguments);
        return fragment;
    }
//    public static BrotherDetailFragment newInstance(){
//        return new BrotherDetailFragment();
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // instantiate the brother variable from the brother object in the bundle
        brother = getArguments().getParcelable(BROTHER_EXTRA_INFO);
//        brother = getActivity().getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_brother_details, container, false);

        ButterKnife.bind(this, rootView);

        name.setText(brother.getBrotherName());
        // get the text from the resource and replace %1$s in the string with the content of the
        // brother.getBrotherMajor() content
        major.setText(getString(R.string.major_intro, brother.getBrotherMajor()));
        funFact.setText(getString(R.string.fun_fact_intro, brother.getBrotherFunFact()));
        crossSemester.setText(getString(R.string.crossed_semester_intro, brother.getBrotherCrossSemister()));
        whyJoined.setText(brother.getBrotherWhyJoin());

        // load picture in imageView using picasso
        Picasso.with(getActivity()).load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(picture, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        return rootView;
    }

}
