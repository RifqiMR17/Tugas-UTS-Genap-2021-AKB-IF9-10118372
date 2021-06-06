package com.akb.tugas_uts_genap_2021_akb_if9_10118372;

import android.content.Intent;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 6 juni 2021
// 10118372
// Rifqi Muhammad Rizqullah
// IF-9

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder>{
    private List<diary> diaries;

    public DiaryAdapter(List<diary> notes) {
        this.diaries = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.diary_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(diaries.get(position).getTitle());
        holder.category.setText(diaries.get(position).getCategory());
        holder.desc.setText(diaries.get(position).getDesc());
        holder.date.setText(diaries.get(position).getDate());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), TambahActivity.class);
            intent.putExtra("", String.valueOf(diaries.get(position)));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return diaries.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView category;
        TextView desc;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_note);
            category = itemView.findViewById(R.id.category_note);
            desc = itemView.findViewById(R.id.desc_note);
            date = itemView.findViewById(R.id.date_note);
        }
    }
}
