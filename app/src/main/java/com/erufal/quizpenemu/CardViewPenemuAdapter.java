package com.erufal.quizpenemu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class CardViewPenemuAdapter extends RecyclerView.Adapter<CardViewPenemuAdapter.CardViewViewHolder> {
    private ArrayList<Penemu> listPenemu;
    private Context context;

    public CardViewPenemuAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Penemu> getListPenemu() {
        return listPenemu;
    }

    public void setListPenemu(ArrayList<Penemu> listPenemu) {
        this.listPenemu = listPenemu;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_penemu, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        Penemu p = getListPenemu().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite " + getListPenemu().get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, IsiMateri.class);
                        intent.putExtra("Name",getListPenemu().get(position).getName());
                        intent.putExtra("Photo",getListPenemu().get(position).getPhoto());
                        intent.putExtra("Remarks",getListPenemu().get(position).getRemarks());
                        intent.putExtra("Cont",getListPenemu().get(position).getPeran());
                        intent.putExtra("Tgl",getListPenemu().get(position).getTgl());
                        intent.putExtra("Bio",getListPenemu().get(position).getBio());

                context.startActivity(intent);
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListPenemu().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPenemu().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button) itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button) itemView.findViewById(R.id.btn_set_share);
        }
    }
}


