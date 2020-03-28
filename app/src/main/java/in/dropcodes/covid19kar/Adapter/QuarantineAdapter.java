package in.dropcodes.covid19kar.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.dropcodes.covid19kar.Model.QuarantineModel;
import in.dropcodes.covid19kar.R;

public class QuarantineAdapter extends RecyclerView.Adapter<QuarantineAdapter.ViewHolder> implements Filterable {

    public List<QuarantineModel> model;
    public List<QuarantineModel> modelFull;
    public Context context;

    public QuarantineAdapter(List<QuarantineModel> model, Context context) {
        this.model = model;
        this.context = context;
        modelFull = new ArrayList<>(model);
    }

    @NonNull
    @Override
    public QuarantineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.quarantie_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuarantineAdapter.ViewHolder holder, int position) {

        String doa = model.get(position).getArrival_date();
        holder.Date_of_arrival.setText("Date of Arrival: " + doa);

        String travelfrom = model.get(position).getFrom();
        holder.Travel_form.setText("Travelled From: " + travelfrom);

        String travelto = model.get(position).getTo();
        holder.Travel_to.setText("Travelled To: " + travelto);

        String addres = model.get(position).getStreet() +", "+ model.get(position).getThesil() +", "+ model.get(position).getCity() +", " + model.get(position).getState();
        holder.Address.setText("Address: " + addres);

        String destin = model.get(position).getDestination();
        holder.Destination.setText("Destination: " + destin);

        String qtill = model.get(position).getQuarantine_date();
        holder.Quarantine_Till.setText("Quarantine ends: " + qtill);

        String pin = model.get(position).getPincode();
        holder.Pincode.setText("PinCode: "+pin);

        String sln = model.get(position).getSlno();
        holder.Sln.setText(sln);

       String status = model.get(position).getStatus();

        if (status.equals("today")){
            holder.Quarantine_Till.setTextColor(Color.RED);
        }else if (status.equals("inactive")){
            holder.Quarantine_Till.setTextColor(Color.GREEN);
        }else{
            holder.Quarantine_Till.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public Filter modelFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<QuarantineModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filterList.addAll(modelFull);
            }else
            {
                String filterPattern  = constraint.toString().toLowerCase().trim();
                for (QuarantineModel item : modelFull){
                    if (item.getPincode().toLowerCase().contains(filterPattern)){
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            model.clear();
            model.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return modelFilter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Date_of_arrival, Travel_form, Travel_to, Address, Destination, Quarantine_Till, Pincode, Sln;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Date_of_arrival = itemView.findViewById(R.id.q_date_of_arrival);
            Travel_form = itemView.findViewById(R.id.q_travel_from);
            Travel_to = itemView.findViewById(R.id.q_travel_to);
            Address = itemView.findViewById(R.id.q_address);
            Destination = itemView.findViewById(R.id.q_destination);
            Quarantine_Till = itemView.findViewById(R.id.q_till);
            Pincode = itemView.findViewById(R.id.q_pin_code);
            Sln = itemView.findViewById(R.id.q_sln);
            linearLayout = itemView.findViewById(R.id.q_ll);

        }

    }
}
