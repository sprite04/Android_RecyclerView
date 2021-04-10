package com.example.recyclerview.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.module.Module;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;



public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {

    private ArrayList<Module> moduleList;

    public ModuleAdapter(ArrayList<Module> moduleList) {
        this.moduleList = moduleList;
    }

    /**
     * create new views
     * @param parent
     * @param viewType
     * @return viewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();

        LayoutInflater inflater= LayoutInflater.from(context);

        View view=inflater.inflate(R.layout.modulelayout,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);

        //create event delete a module
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder b=new AlertDialog.Builder(context);
                b.setTitle(R.string.title);
                b.setMessage(R.string.message);
                b.setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        moduleList.remove(viewHolder.getPosition());
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }});
                b.setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }

                });

                b.create().show();
                return false;
            }
        });

        return viewHolder;
    }

    /**
     * replace the contents of a view
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Module module=moduleList.get(position);

        //set content for each element in view
        holder.imgIcon.setImageResource(module.getIcon());
        holder.txtTitle.setText(module.getTitle());
        holder.txtCategory.setText(module.getCategory());
        holder.txtDescription.setText(module.getDescription());
    }

    /*
    * @return size of module list
    */
    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Title
        private TextView txtTitle;
        //Description
        private TextView txtDescription;
        //Category
        private TextView txtCategory;
        //Icon
        private ImageView imgIcon;

        /*
        * View Holder constructor
        * @param itemView
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtDescription=itemView.findViewById(R.id.txtDescription);
            txtCategory =itemView.findViewById(R.id.txtCategory);
            imgIcon = itemView.findViewById(R.id.imgIcon);
        }
    }
}
