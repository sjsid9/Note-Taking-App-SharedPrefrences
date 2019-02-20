package com.infisoln.siddhant.note_taking_app_sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    ArrayList<Note> arrayList;
    Context ctx;


    public NotesAdapter(ArrayList<Note> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ctx = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = layoutInflater.inflate(R.layout.layout_row, viewGroup, false);
        return new NotesHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder notesHolder, int i) {

        Note note = arrayList.get(i);

        notesHolder.Note.setText(note.getTitle());
        notesHolder.timeStamp.setText(note.getTimeStamp());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NotesHolder extends RecyclerView.ViewHolder {

        TextView Note, timeStamp;
        Button delete;

        public NotesHolder(@NonNull View itemView) {
            super(itemView);
            Note = itemView.findViewById(R.id.tvNote);
            timeStamp = itemView.findViewById(R.id.tvTimeStamp);
            delete = itemView.findViewById(R.id.btnDelete);

            SharedPreferences sharedPreferences = ctx.getSharedPreferences("myprefs", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note currentNote = arrayList.get(getAdapterPosition());
                    editor.remove(currentNote.getTimeStamp());
                    arrayList.remove(currentNote);
//                    Toast.makeText(ctx, ""+currentNote.getTimeStamp(), Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                    editor.apply();
                }
            });

        }
    }


}
