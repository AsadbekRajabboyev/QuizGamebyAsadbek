package com.example.quizgamebyasadbek.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.quizgamebyasadbek.R;
import com.example.quizgamebyasadbek.databinding.FragmentFlagsBinding;
import com.example.quizgamebyasadbek.models.FlagsModel;
import com.example.quizgamebyasadbek.models.WordModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlagsFragment extends Fragment implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
private FragmentFlagsBinding binding;
    private List<FlagsModel> flagsModelList;
    private int currentIndex = 0;
    private List<WordModel> wordModelList;
    private int level = 1;
    private int coins1 = 50;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFlagsBinding.inflate(inflater, container, false);
        loadData();
        setData();
        return binding.getRoot();
    }

    private void setData() {
        WordModel wordModel = wordModelList.get(currentIndex);
        binding.img.setImageResource(wordModel.getImg());
        String word = wordModel.getWord();//book
        int length = word.length();//4
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);

//        for (int i = 0; i < length; i++) {
//            Button button = new Button(this);
//            button.setText(String.valueOf(word.charAt(i)));//bo
//            button.setLayoutParams(layoutParams);
//            binding.layout.addView(button);
//        }

        List<String> harf2List = getHarfList(word);
        for (int i = 0; i < harf2List.size() / 2; i++) {

            Button button1 = new Button(requireContext());
            button1.setText(harf2List.get(i).toString());
            button1.setLayoutParams(layoutParams);
            button1.setOnClickListener(this);
            binding.lay1.addView(button1);

        }
        for (int i = harf2List.size() / 2; i < harf2List.size(); i++) {

            Button button = new Button(requireContext());
            button.setText(harf2List.get(i).toString());
            button.setLayoutParams(layoutParams);
            button.setOnClickListener(this);
            binding.lay2.addView(button);

        }

        Button buttonHint =new Button(requireContext());
        buttonHint.setText("HINT");
        buttonHint.setLayoutParams(layoutParams);
        binding.buttonLayout.addView(buttonHint);
        buttonHint.setOnClickListener(v -> {
            if (coins1>= 10){
                binding.textHint.setText(wordModel.getHint());
                int i = coins1 - 10;
                coins1=i;
                buttonHint.setVisibility(View.INVISIBLE);
                binding.coins.setText(i+"coins");
            }else {
                Toast.makeText(requireContext(), "Sizda yetarli mablag mavjud emas", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private List<String> getHarfList(String s) {
        String alphabet = "ABCDEFGHIJKLMONPQRUSTVWXYZ";
        String s1 = alphabet.substring(0, 18 - s.length());
        List<String> harfList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            harfList.add(String.valueOf(s1.charAt(i)));
        }
        for (int i = 0; i < s.length(); i++) {
            harfList.add(String.valueOf(s.charAt(i)));
        }
        Collections.shuffle(harfList);
        return harfList;
    }

    private void loadData() {
        wordModelList = new ArrayList<>();
        wordModelList.add(new WordModel(R.drawable.img_5, "Argetina","South America"));//0
        wordModelList.add(new WordModel(R.drawable.img_7, "Mexico","North America"));//1
        wordModelList.add(new WordModel(R.drawable.img_6, "China", "Asia"));
        wordModelList.add(new WordModel(R.drawable.img_4, "EGYPT", "Africa"));
        wordModelList.add(new WordModel(R.drawable.img_3, "USA", "North America"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String s = button.getText().toString();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);

        Button cButton1 = new Button(requireContext());
        cButton1.setText(s);
        cButton1.setLayoutParams(layoutParams);
        binding.layout.addView(cButton1);
        button.setVisibility(View.INVISIBLE);

        cButton1.setOnClickListener(v1 -> {
            binding.layout.removeView(cButton1);
            button.setVisibility(View.VISIBLE);
        });

        int childCount = binding.layout.getChildCount();
        String trueAnswer = wordModelList.get(currentIndex).getWord();
        int length = trueAnswer.length();
        StringBuilder stringBuilder = new StringBuilder();
        if (childCount == length) {
            for (int i = 0; i < childCount; i++) {
                Button btn = (Button) binding.layout.getChildAt(i);
                stringBuilder.append(btn.getText());

            }
            if (trueAnswer.equalsIgnoreCase(stringBuilder.toString())) {
                binding.layout.removeAllViews();
                binding.lay1.removeAllViews();
                binding.lay2.removeAllViews();
                binding.buttonLayout.removeAllViews();
                currentIndex++;
                level++;
                coins1+=10;
                binding.coins.setText(coins1+ "coins");
                binding.textViewLevel.setText(level +"-level");
                setData();
                binding.textHint.setText("");
                Toast.makeText(requireContext(), "Barakalla", Toast.LENGTH_SHORT).show();

            }
        }


    }
}