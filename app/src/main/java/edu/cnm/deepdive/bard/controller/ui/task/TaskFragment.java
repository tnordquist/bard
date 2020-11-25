package edu.cnm.deepdive.bard.controller.ui.task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.bard.R;

public class TaskFragment extends Fragment {

  private TaskViewModel taskViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    taskViewModel =
        ViewModelProviders.of(this).get(TaskViewModel.class);
    View root = inflater.inflate(R.layout.fragment_task, container, false);
    final TextView textView = root.findViewById(R.id.text_task);
    taskViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}