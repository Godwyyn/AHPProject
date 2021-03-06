package com.godwyn.ahp_project.assistmethod;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ahpandroid.R;
import com.ahpandroid.databinding.SelectAssistMethodRecycleItemBinding;
import com.ahpandroid.domain.entity.AssistMethod;
import com.ahpandroid.domain.enums.AssistMethodsEnum;

import java.util.List;

public class SelectAssistMethodAdapter extends RecyclerView.Adapter<SelectAssistMethodAdapter.ItemViewHolder>{

    private final SelectAssistMethodContract.View mDashboardView;
    private List<AssistMethod> mAssistMethods;
    private Context mContext;
    private RecyclerView.ViewHolder mViewHolder;

    public SelectAssistMethodAdapter(Context context,
                                     List<AssistMethod> assistMethods,
                                     SelectAssistMethodContract.View dashboardView) {
        this.mContext       = context;
        this.mAssistMethods = assistMethods;
        this.mDashboardView = dashboardView;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        SelectAssistMethodRecycleItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.select_assist_method_recycle_item,
                parent,
                false);

        final ItemViewHolder vh = new ItemViewHolder(binding);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final AssistMethod assistMethod = mAssistMethods.get(position);
        holder.binding.setAssistmethod(assistMethod);
        holder.binding.assistMethodReadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Abrir Colapse com o resto do texto ou ir para outra tela", Toast.LENGTH_SHORT).show();
            }
        });
        holder.binding.assistMethodContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(assistMethod.getMethodId() == AssistMethodsEnum.AHP.getValue())
                    mDashboardView.goToAHP();
                else if(assistMethod.getMethodId() == AssistMethodsEnum.PROGRESSION.getValue())
                    mDashboardView.goToProgression();
                else if(assistMethod.getMethodId() == AssistMethodsEnum.REGRESSION.getValue())
                    mDashboardView.goToRegression();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAssistMethods != null ? mAssistMethods.size() : 0;
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        SelectAssistMethodRecycleItemBinding binding;

        public ItemViewHolder(SelectAssistMethodRecycleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
