package in.dropcodes.covid19kar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.dropcodes.covid19kar.R;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {


    public final OnClickNameListener onClickNameListener;
    private String name[];
    Context ctx;

    public LocationAdapter(OnClickNameListener onClickNameListener, String[] name, Context ctx) {
        this.onClickNameListener = onClickNameListener;
        this.name = name;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.main_location_name_layout, parent, false);
        return new ViewHolder(view,onClickNameListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, int position) {
        holder.mName.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mName;
        OnClickNameListener listener;

        public ViewHolder(@NonNull View itemView,OnClickNameListener listener) {
            super(itemView);
            mName = itemView.findViewById(R.id.main_tv_name);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick (View view) {
            listener.onClickName(getAdapterPosition());
        }
    }

    public interface OnClickNameListener{
        void onClickName(int position);
    }
}
