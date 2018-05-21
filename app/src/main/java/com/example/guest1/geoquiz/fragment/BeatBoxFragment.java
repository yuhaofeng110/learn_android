package com.example.guest1.geoquiz.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest1.geoquiz.R;
import com.example.guest1.geoquiz.beatbox.BeatBox;
import com.example.guest1.geoquiz.beatbox.Sound;
import com.example.guest1.geoquiz.beatbox.SoundViewModel;
import com.example.guest1.geoquiz.databinding.FragmentBeatBoxBinding;
import com.example.guest1.geoquiz.databinding.ListItemSoundBinding;

import java.util.List;

public class BeatBoxFragment extends Fragment {

    private BeatBox mBeatBox;

    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        FragmentBeatBoxBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box,container,false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        binding.recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));

        return binding.getRoot();
    }

    private class SoundHolder extends RecyclerView.ViewHolder{

        private ListItemSoundBinding mBinding;

        private SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(new SoundViewModel(mBeatBox));

        }

        public void bind(Sound sound){
            mBinding.getViewModel().setSound(sound);
            //立即刷新试图
            mBinding.executePendingBindings();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{

        private List<Sound> mSounds;

        public SoundAdapter(List<Sound> sounds){
            mSounds = sounds;
        }

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemSoundBinding binding = DataBindingUtil.inflate(inflater,R.layout.list_item_sound,parent,false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder holder, int position) {
            Sound sound = mSounds.get(position);
            holder.bind(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//调用setRetainInstance(true)方法可保留
//fragment。已保留的fragment不会随activity一起被销毁。相反，它会一直保留，并在需要时原封 不动地转给新的activity。
        setRetainInstance(true);
        mBeatBox = new BeatBox(getActivity());
    }
}
