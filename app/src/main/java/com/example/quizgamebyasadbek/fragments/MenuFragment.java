package com.example.quizgamebyasadbek.fragments;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.quizgamebyasadbek.R;
import com.example.quizgamebyasadbek.databinding.FragmentMenuBinding;
public class MenuFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (getArguments() != null) {
            String param1 = bundle.getString("param1");
            String param2 = bundle.getString("param2");

        }
    }
private FragmentMenuBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         binding= FragmentMenuBinding.inflate(inflater, container, false);
        //ilovadan chiqish
         binding.exit.setOnClickListener(v -> {
            showDialog();
        });
        //menu fragmentdan flags fragmentiga o'tish
        binding.flags.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_menuFragment_to_flagsFragment);
        });
        //menu fragmentdan clubs fragmentiga o'tish
        binding.clubs.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_menuFragment_to_footballClubsFragment);
        });
        //menu fragmentdan cars fragmentiga o'tish
        binding.cars.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_menuFragment_to_carsFragment);
        });
        binding.info.setOnClickListener(v -> {
            openAlertDialog();
        });
        return binding.getRoot();
    }

    private void openAlertDialog() {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());

            // AlertDialog sarlavhasi va matni
            alertDialogBuilder.setTitle("About Developer!");
            alertDialogBuilder.setMessage("Bu ilova Asadbek Rajabboyev tomonidan yaratilgan. Taklif va murojatlar bolsa +998991594946 raqamiga yoki asadrajab28@gmali.com ga murojat qiling");

            // "Ok" tugmasi va unga click qilganda amalni bajaruvchi qismi
            alertDialogBuilder.setPositiveButton("Ok", (dialog, which) -> {
                // Bu joyda "Ok" tugmasi bosilganda bajariladigan amalni yozing
                // Masalan, alertDialogni yopishingiz mumkin
                dialog.dismiss();
            });

            // AlertDialog obyektini yaratish va ochish
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    private void showDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle("Chiqishni tasdiqlang");
            builder.setMessage("Ilovadan chiqmoqchimisiz?");
            builder.setPositiveButton("Ha", (dialog, which) -> {
                dialog.dismiss();
                getActivity().finish(); // Activity ni yopish
            });
            builder.setNegativeButton("Yo'q", (dialog, which) -> {
                dialog.dismiss(); // Dialogni yopish
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

