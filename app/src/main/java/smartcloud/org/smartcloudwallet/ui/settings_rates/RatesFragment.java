package smartcloud.cash.smartcloudwallet.ui.settings_rates;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import smartcloud.cash.smartcloudwallet.R;
import global.SmartcloudRate;
import smartcloud.cash.smartcloudwallet.ui.base.BaseRecyclerFragment;
import smartcloud.cash.smartcloudwallet.ui.base.tools.adapter.BaseRecyclerAdapter;
import smartcloud.cash.smartcloudwallet.ui.base.tools.adapter.BaseRecyclerViewHolder;
import smartcloud.cash.smartcloudwallet.ui.base.tools.adapter.ListItemListeners;

/**
 * Created by Telostia on 7/2/17.
 */

public class RatesFragment extends BaseRecyclerFragment<SmartcloudRate> implements ListItemListeners<SmartcloudRate> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setEmptyText("No rate available");
        setEmptyTextColor(Color.parseColor("#cccccc"));
        return view;
    }

    @Override
    protected List<SmartcloudRate> onLoading() {
        return smartcloudModule.listRates();
    }

    @Override
    protected BaseRecyclerAdapter<SmartcloudRate, ? extends SmartcloudRateHolder> initAdapter() {
        BaseRecyclerAdapter<SmartcloudRate, SmartcloudRateHolder> adapter = new BaseRecyclerAdapter<SmartcloudRate, SmartcloudRateHolder>(getActivity()) {
            @Override
            protected SmartcloudRateHolder createHolder(View itemView, int type) {
                return new SmartcloudRateHolder(itemView, type);
            }

            @Override
            protected int getCardViewResource(int type) {
                return R.layout.rate_row;
            }

            @Override
            protected void bindHolder(SmartcloudRateHolder holder, SmartcloudRate data, int position) {
                holder.txt_name.setText(data.getCode());
                if (list.get(0).getCode().equals(data.getCode()))
                    holder.view_line.setVisibility(View.GONE);
            }
        };
        adapter.setListEventListener(this);
        return adapter;
    }

    @Override
    public void onItemClickListener(SmartcloudRate data, int position) {
        smartcloudApplication.getAppConf().setSelectedRateCoin(data.getCode());
        Toast.makeText(getActivity(), R.string.rate_selected, Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

    @Override
    public void onLongItemClickListener(SmartcloudRate data, int position) {

    }

    private class SmartcloudRateHolder extends BaseRecyclerViewHolder {

        private TextView txt_name;
        private View view_line;

        protected SmartcloudRateHolder(View itemView, int holderType) {
            super(itemView, holderType);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            view_line = itemView.findViewById(R.id.view_line);
        }
    }
}
