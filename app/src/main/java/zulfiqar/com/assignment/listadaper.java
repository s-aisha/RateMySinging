package zulfiqar.com.assignment;


import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class listadaper extends RecyclerView.Adapter<listadaper.ViewHolder>{
    private List<listdata> listdata;
    private Context context;

    public listadaper(Context context, List<zulfiqar.com.assignment.listdata> listViewH) {

        this.context = context;
        this.listdata=listViewH;
    }

    // RecyclerView recyclerView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final listdata myListData = listdata.get(position);
        holder.textView1.setText(listdata.get(position).getName());
        holder.textView2.setText(listdata.get(position).getAge());
        holder.textView3.setText(listdata.get(position).getCreatedate());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            this.textView1 = (TextView) itemView.findViewById(R.id.name);
            this.textView2 = (TextView) itemView.findViewById(R.id.age);
            this.textView3 = (TextView) itemView.findViewById(R.id.createdate);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}

