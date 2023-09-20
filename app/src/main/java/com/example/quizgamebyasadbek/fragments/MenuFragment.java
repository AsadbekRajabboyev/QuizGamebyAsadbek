package com.example.quizgamebyasadbek.fragments;

import static com.example.quizgamebyasadbek.R.id.contact;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quizgamebyasadbek.R;
import com.example.quizgamebyasadbek.databinding.CustomDialogBinding;
import com.example.quizgamebyasadbek.databinding.FragmentMenuBinding;
import com.google.android.material.navigation.NavigationView;


public class MenuFragment extends Fragment {

private FragmentMenuBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         binding= FragmentMenuBinding.inflate(inflater, container, false);
        binding.exit.setOnClickListener(v -> {
            showDialog();
        });
        binding.flags.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_menuFragment_to_flagsFragment);
        });
        return binding.getRoot();
    }

    private void showDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle("Chiqishni tasdiqlang");
            builder.setMessage("Ilovadan chiqmoqchimisiz?");
            builder.setPositiveButton("Ha", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    getActivity().finish(); // Activity ni yopish
                }
            });
            builder.setNegativeButton("Yo'q", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Dialogni yopish
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

