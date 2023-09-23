package com.example.quizgamebyasadbek.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.NavOptions;
import com.example.quizgamebyasadbek.R;
import com.example.quizgamebyasadbek.databinding.FragmentFirstBinding;

public class First extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.progressBar.setVisibility(View.INVISIBLE);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dumaloq animatsiya boshlash
                binding.progressBar.setVisibility(View.VISIBLE);
                animateProgressBar();
            }
        });

        return binding.getRoot();
    }

    // ProgressBar animatsiyasi
    private void animateProgressBar() {
        final int totalProgress = 100; // Umumiy progress miqdori
        final int animationDuration = 5000; // Animatsiya davri (ms)

        final Handler handler = new Handler();
        final int increment = totalProgress / (animationDuration / 100); // Progressni har 100ms da yangilash

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress <= totalProgress) {
                    final int finalProgress = progress;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.progressBar.setProgress(finalProgress);
                        }
                    });

                    try {
                        Thread.sleep(100); // Animatsiya tezligi (ms)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress += increment;
                }

                // Animatsiya tugagandan so'ng boshqa fragmentga o'tish
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar.setVisibility(View.GONE);

                        // Fragment o'girish va chiqish animatsiyalari
                        int enterAnim = R.anim.slide_right_to_left;
                        int exitAnim = R.anim.slide_left_to_right;

                        // Boshqa fragmentga o'tish
                        Navigation.findNavController(binding.getRoot()).navigate(
                                R.id.menuFragment,
                                null,
                                new NavOptions.Builder()
                                        .setEnterAnim(enterAnim)
                                        .setExitAnim(exitAnim)
                                        .setPopEnterAnim(enterAnim)
                                        .setPopExitAnim(exitAnim)
                                        .build()
                        );
                    }
                });
            }
        });

        thread.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
