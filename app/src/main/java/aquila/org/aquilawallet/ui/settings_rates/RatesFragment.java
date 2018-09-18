package aquila.org.aquilawallet.ui.settings_rates;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import aquila.org.aquilawallet.R;
import global.AquilaRate;
import aquila.org.aquilawallet.ui.base.BaseRecyclerFragment;
import aquila.org.aquilawallet.ui.base.tools.adapter.BaseRecyclerAdapter;
import aquila.org.aquilawallet.ui.base.tools.adapter.BaseRecyclerViewHolder;
import aquila.org.aquilawallet.ui.base.tools.adapter.ListItemListeners;

/**
 * Created by MotoAcidic on 7/2/17.
 */

public class RatesFragment extends BaseRecyclerFragment<AquilaRate> implements ListItemListeners<AquilaRate> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setEmptyText("No rate available");
        setEmptyTextColor(Color.parseColor("#cccccc"));
        return view;
    }

    @Override
    protected List<AquilaRate> onLoading() {
        return aquilaModule.listRates();
    }

    @Override
    protected BaseRecyclerAdapter<AquilaRate, ? extends AquilaRateHolder> initAdapter() {
        BaseRecyclerAdapter<AquilaRate, AquilaRateHolder> adapter = new BaseRecyclerAdapter<AquilaRate, AquilaRateHolder>(getActivity()) {
            @Override
            protected AquilaRateHolder createHolder(View itemView, int type) {
                return new AquilaRateHolder(itemView,type);
            }

            @Override
            protected int getCardViewResource(int type) {
                return R.layout.rate_row;
            }

            @Override
            protected void bindHolder(AquilaRateHolder holder, AquilaRate data, int position) {
                holder.txt_name.setText(data.getCode());
                if (list.get(0).getCode().equals(data.getCode()))
                    holder.view_line.setVisibility(View.GONE);
            }
        };
        adapter.setListEventListener(this);
        return adapter;
    }

    @Override
    public void onItemClickListener(AquilaRate data, int position) {
        aquilaApplication.getAppConf().setSelectedRateCoin(data.getCode());
        Toast.makeText(getActivity(),R.string.rate_selected,Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

    @Override
    public void onLongItemClickListener(AquilaRate data, int position) {

    }

    private  class AquilaRateHolder extends BaseRecyclerViewHolder{

        private TextView txt_name;
        private View view_line;

        protected AquilaRateHolder(View itemView, int holderType) {
            super(itemView, holderType);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            view_line = itemView.findViewById(R.id.view_line);
        }
    }
}
