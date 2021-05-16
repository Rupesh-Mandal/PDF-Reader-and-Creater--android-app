package com.kali.pdfreader.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.kali.pdfreader.R;
import com.kali.pdfreader.interfaces.OnItemClickListener;
import com.kali.pdfreader.model.EnhancementOptionsEntity;

public class EnhancementOptionsAdapter
        extends RecyclerView.Adapter<EnhancementOptionsAdapter.EnhancementOptionsViewHolder> {

    private final OnItemClickListener mOnItemClickListener;
    private final List<EnhancementOptionsEntity> mEnhancementOptionsEntityList;

    public EnhancementOptionsAdapter(OnItemClickListener mOnItemClickListener,
                                     List<EnhancementOptionsEntity> mEnhancementOptionsEntityList) {
        this.mOnItemClickListener = mOnItemClickListener;
        this.mEnhancementOptionsEntityList = mEnhancementOptionsEntityList;
    }

    @NonNull
    @Override
    public EnhancementOptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_enhancement_option, parent, false);
        return new EnhancementOptionsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull EnhancementOptionsViewHolder holder, int position) {
        holder.optionImage.setImageDrawable(mEnhancementOptionsEntityList.get(position).getImage());
        holder.optionName.setText(mEnhancementOptionsEntityList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mEnhancementOptionsEntityList.size();
    }

    public class EnhancementOptionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.option_image)
        ImageView optionImage;
        @BindView(R.id.option_name)
        TextView optionName;

        EnhancementOptionsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
