package com.gifmyneeds.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.gifmyneeds.R;

import com.gifmyneeds.models.Child;
import com.gifmyneeds.models.User;

import java.util.ArrayList;



public class ChildListAdapter extends ArrayAdapter<Child> implements Filterable {

    private static final String TAG = "ChildListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
    private User parentOfCild;
    private ArrayList<Child> childsArrayList;
    private ArrayList<Child> orig;
     /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView name;
        TextView gender;
        TextView age;
         TextView id;
     }

    /**
     * Default constructor for the ChildListAdapter
     */
    public ChildListAdapter(Context context, int resource, ArrayList<Child> objects, User parentOfCild) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        childsArrayList = objects;
        this.parentOfCild = parentOfCild;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //get the child information
        String name = getItem(position).getFullName();
        String gender = getItem(position).getGender();
        String age = getItem(position).getAge();
        String id = getItem(position).getId();

        //Create the child object with the information
        Child child = null;
        try {
            child = new Child(id,name,gender,age, parentOfCild.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.etIncomingName);
            holder.gender = (TextView) convertView.findViewById(R.id.etIncomingGender);
            holder.age = (TextView) convertView.findViewById(R.id.etIncomingAge);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(child.getFullName());
        holder.gender.setText(child.getGender());
        holder.age.setText(child.getAge());


        return convertView;
    }

    @NonNull
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Child> results = new ArrayList<>();
                if (orig == null)
                    orig = childsArrayList;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final Child g : orig) {
                            if (g.getFullName().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                childsArrayList = (ArrayList<Child>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return childsArrayList.size();
    }

    @Override
    @NonNull
    public Child getItem(int position) {
        return childsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}

























