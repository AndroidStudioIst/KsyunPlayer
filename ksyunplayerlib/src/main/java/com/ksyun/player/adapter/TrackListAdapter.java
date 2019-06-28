package com.ksyun.player.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ksyun.player.R;
import com.ksyun.player.bean.TrackEntity;

import java.util.List;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.ViewHolder> {
    private Context context;
    private List<TrackEntity> data;

    private OnTrackSelectedListener onTrackSelectedListener;

    public TrackListAdapter(@NonNull Context context, List<TrackEntity> data) {
        this.context =context;
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = View.inflate(context, R.layout.item_list_track, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final TrackEntity trackEntity = data.get(viewHolder.getAdapterPosition());
        if (trackEntity != null) {
            Log.e("info", viewHolder.getAdapterPosition() + " -> checked: " + trackEntity.isSelected());
            viewHolder.checked.setVisibility(trackEntity.isSelected() ? View.VISIBLE : View.INVISIBLE);
            viewHolder.title.setText(trackEntity.getTitle());
            viewHolder.line.setVisibility(viewHolder.getAdapterPosition() == data.size() - 1 ? View.INVISIBLE : View.VISIBLE);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (TrackEntity entity : data) {
                        entity.setSelected(entity.equals(data.get(viewHolder.getAdapterPosition())));
                    }
                    if (onTrackSelectedListener != null) {
                        onTrackSelectedListener.onTrackSelected(trackEntity);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView checked;
        private View line;

        private ViewHolder(View viewRoot) {
            super(viewRoot);
            title = viewRoot.findViewById(R.id.title);
            checked = viewRoot.findViewById(R.id.checked);
            line = viewRoot.findViewById(R.id.line);
        }
    }

    public void setOnTrackSelectedListener(OnTrackSelectedListener onTrackSelectedListener) {
        this.onTrackSelectedListener = onTrackSelectedListener;
    }

    public interface OnTrackSelectedListener {
        void onTrackSelected(TrackEntity trackEntity);
    }
}
