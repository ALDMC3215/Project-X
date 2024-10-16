package com.example.video26.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpproject.Model.Person;
import com.example.mvpproject.R;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private final List<Person> personList;
    private PersonViewHolder previouslyClickedHolder;
    private final SecondContract.Presenter presenter; // Add presenter reference


    public PersonAdapter(List<Person> personList, SecondContract.Presenter presenter) {
        this.personList = personList;
        this.previouslyClickedHolder = null;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_4, parent, false);
        return new PersonViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {

        holder.btn_update.setVisibility(View.GONE);
        holder.btn_delete.setVisibility(View.GONE);
        holder.txt_phone.setVisibility(View.GONE);

        Person person = personList.get(position);
        holder.NAF.setText(person.getName() + " " + person.getFamily());
        holder.txt_phone.setText(person.getPhoneNumber());

        holder.card.setOnClickListener(view -> {
            if((previouslyClickedHolder != null) && (previouslyClickedHolder != holder)) {
                previouslyClickedHolder.txt_phone.setVisibility(View.GONE);
                previouslyClickedHolder.btn_update.setVisibility(View.GONE);
                previouslyClickedHolder.btn_delete.setVisibility(View.GONE);
            }
            if(holder.txt_phone.getVisibility() == View.VISIBLE && holder.btn_update.getVisibility() == View.VISIBLE && holder.btn_delete.getVisibility() == View.VISIBLE) {

                holder.txt_phone.setVisibility(View.GONE);
                holder.btn_update.setVisibility(View.GONE);
                holder.btn_delete.setVisibility(View.GONE);

            } else {
                holder.txt_phone.setVisibility(View.VISIBLE);
                holder.btn_update.setVisibility(View.VISIBLE);
                holder.btn_delete.setVisibility(View.VISIBLE);
                previouslyClickedHolder = holder;
            }
        });

        holder.btn_delete.setOnClickListener(view -> {

            int currentPosition = holder.getAdapterPosition(); // Get updated position

            if(currentPosition != RecyclerView.NO_POSITION) { // Check for valid position
                Person personToDelete = personList.get(currentPosition);
                int personId = personToDelete.getPersonId();

                if(presenter != null) {
                    presenter.onDeletePerson(person);
                    presenter.onShowAllContacts();
                    personList.clear(); // Clear existing list
                    personList.addAll(presenter.getPersons()); // Update with new data
                    notifyItemRemoved(position);
                }

                personList.remove(currentPosition);
                notifyItemRemoved(currentPosition);

                Toast.makeText(holder.itemView.getContext(), personToDelete.getName() + " Deleted Succesfuly !", Toast.LENGTH_SHORT).show();

            }
        });

        holder.btn_update.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), Update_Info.class);
            intent.putExtra("name", person.getName());
            intent.putExtra("family", person.getFamily());
            intent.putExtra("phoneNumber", person.getPhoneNumber());
            intent.putExtra("personId", person.getPersonId());
            holder.itemView.getContext().startActivity(intent);
        });


    }


    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        public CardView card;
        public TextView NAF, txt_phone;
        public ImageButton btn_update, btn_delete;
        public ImageView img;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card_layout);
            NAF = itemView.findViewById(R.id.txt_name);
            txt_phone = itemView.findViewById(R.id.txt_phone);
            btn_update = itemView.findViewById(R.id.btn_update);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            img = itemView.findViewById(R.id.img_profile);

        }
    }


}
