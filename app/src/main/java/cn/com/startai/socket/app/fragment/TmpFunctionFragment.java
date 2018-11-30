package cn.com.startai.socket.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import cn.com.startai.socket.R;
import cn.com.startai.socket.debuger.Debuger;
import cn.com.startai.socket.global.LooperManager;
import cn.com.startai.socket.mutual.Controller;
import cn.com.startai.socket.sign.hardware.WiFi.impl.NetworkManager;
import cn.com.startai.socket.sign.scm.impl.SocketScmManager;
import cn.com.swain.baselib.util.IpUtil;
import cn.com.swain.support.protocolEngine.pack.ComModel;
import cn.com.swain169.log.Tlog;

/**
 * author: Guoqiang_Sun
 * date : 2018/4/13 0013
 * desc :
 */

public class TmpFunctionFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tlog.v(TAG, " TmpFunctionFragment onCreate() ");
    }

    private TextView mStateTxt;

    @Override
    protected View inflateView() {
        Tlog.v(TAG, " TmpFunctionFragment inflateView() ");
        View view = View.inflate(getActivity(), R.layout.framgment_function,
                null);

        EditText rEdt = view.findViewById(R.id.r_edt);
        EditText gEdt = view.findViewById(R.id.g_edt);
        EditText bEdt = view.findViewById(R.id.b_edt);
        Button mSubmitBtn = view.findViewById(R.id.submit_btn);

        mStateTxt = view.findViewById(R.id.flash_state);

        mSubmitBtn.setOnClickListener(v -> {

            Context context = getContext();
            if (context == null) {
                return;
            }

            String s;

            s = rEdt.getText().toString();
            int r;
            if ((r = strToInt(s)) == -1) return;

            s = gEdt.getText().toString();
            int g;
            if ((g = strToInt(s)) == -1) return;

            s = bEdt.getText().toString();
            int b;
            if ((b = strToInt(s)) == -1) return;

            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            if (imm.isActive()) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

            SocketScmManager scmManager =
                    Controller.getInstance().getScmManager();
            if (scmManager != null) {
                scmManager.setLightRGB(Debuger.getInstance().getProductDevice(), 0, r, g, b);
            } else {
                Toast.makeText(context, "scm is null", Toast.LENGTH_SHORT).show();
            }

        });

        Button mQueryBtn = view.findViewById(R.id.query_state_btn);
        mQueryBtn.setOnClickListener(v -> {
            SocketScmManager scmManager =
                    Controller.getInstance().getScmManager();
            if (scmManager != null) {
                scmManager.queryFlashState(Debuger.getInstance().getProductDevice());
            } else {
                Toast.makeText(getContext(), "scm is null", Toast.LENGTH_SHORT).show();
            }
        });

        Button mOpenBtn = view.findViewById(R.id.open_btn);
        mOpenBtn.setOnClickListener(v -> {
            SocketScmManager scmManager =
                    Controller.getInstance().getScmManager();
            if (scmManager != null) {
                scmManager.switchFlash(Debuger.getInstance().getProductDevice(), true);
            } else {
                Toast.makeText(getContext(), "scm is null", Toast.LENGTH_SHORT).show();
            }
        });

        Button mCloseBtn = view.findViewById(R.id.close_btn);
        mCloseBtn.setOnClickListener(v -> {
            SocketScmManager scmManager =
                    Controller.getInstance().getScmManager();
            if (scmManager != null) {
                scmManager.switchFlash(Debuger.getInstance().getProductDevice(), false);
            } else {
                Toast.makeText(getContext(), "scm is null", Toast.LENGTH_SHORT).show();
            }
        });

        Handler mWorkHandler = new Handler(LooperManager.getInstance().getWorkLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Toast.makeText(getContext(),
                        " workThread Running",
                        Toast.LENGTH_SHORT).show();

            }
        };

        Button mCheckWorkThreadBtn = view.findViewById(R.id.check_work_thread_btn);
        mCheckWorkThreadBtn.setOnClickListener(v -> mWorkHandler.sendEmptyMessage(0));

        Handler mProtocolHandler = new Handler(LooperManager.getInstance().getWorkLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Toast.makeText(getContext(),
                        " protocolThread Running",
                        Toast.LENGTH_SHORT).show();
            }
        };


        Button mCheckProtocolThreadBtn = view.findViewById(R.id.check_protocol_thread_btn);
        mCheckProtocolThreadBtn.setOnClickListener(v -> mProtocolHandler.sendEmptyMessage(0));

        Handler mRepeatHandler = new Handler(LooperManager.getInstance().getWorkLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Toast.makeText(getContext(),
                        " repeatThread Running",
                        Toast.LENGTH_SHORT).show();
            }
        };

        Button mCheckRepeatThreadBtn = view.findViewById(R.id.check_repeat_thread_btn);
        mCheckRepeatThreadBtn.setOnClickListener(v -> mRepeatHandler.sendEmptyMessage(0));

        EditText mInputEdt = view.findViewById(R.id.protocol_engine_input_edt);

        Button mCheckProtocolEngineBtn = view.findViewById(R.id.check_protocolEngine_btn);
        mCheckProtocolEngineBtn.setOnClickListener(v -> {
            SocketScmManager scmManager = Controller.getInstance().getScmManager();
            if (scmManager != null) {
                String s = mInputEdt.getText().toString();
                scmManager.testProtocolAnalysis(Debuger.getInstance().getProductDevice(), s, ComModel.SEND_MODEL_LAN);
            } else {
                Toast.makeText(getContext(), " scmManager=null ", Toast.LENGTH_SHORT).show();
            }
        });

        EditText mInputWEdt = view.findViewById(R.id.protocol_engineW_input_edt);
        Button mCheckProtocolEngineWBtn = view.findViewById(R.id.check_protocolEngineW_btn);
        mCheckProtocolEngineWBtn.setOnClickListener(v -> {
            SocketScmManager scmManager = Controller.getInstance().getScmManager();
            if (scmManager != null) {
                String s = mInputWEdt.getText().toString();
                scmManager.testProtocolAnalysis(Debuger.getInstance().getProductDevice(), s, ComModel.SEND_MODEL_WAN);
            } else {
                Toast.makeText(getContext(), " scmManager=null ", Toast.LENGTH_SHORT).show();
            }
        });


        EditText mInputCEdt = view.findViewById(R.id.protocol_engineC_input_edt);
        Button mCheckProtocolEngineCBtn = view.findViewById(R.id.check_protocolEngineC_btn);
        mCheckProtocolEngineCBtn.setOnClickListener(v -> {
            SocketScmManager scmManager = Controller.getInstance().getScmManager();
            if (scmManager != null) {
                String s = mInputCEdt.getText().toString();
                scmManager.testProtocolAnalysis(Debuger.getInstance().getProductDevice(), s, ComModel.SEND_MODEL_CASUAL);
            } else {
                Toast.makeText(getContext(), " scmManager=null ", Toast.LENGTH_SHORT).show();
            }
        });

        TextView mIpTxt = view.findViewById(R.id.ip_txt);
        TextView mPortTxt = view.findViewById(R.id.port_txt);
        String ip = null;
        int port = -1;

        NetworkManager networkManager = Controller.getInstance().getNetworkManager();
        if (networkManager != null) {
            ip =
                    IpUtil.getLocalIpV4Address() + "--" +
                            networkManager.getUdpLanComIp() + "--" +
                            IpUtil.getBroadcastAddress(Objects.requireNonNull(getContext()));
            port = networkManager.getUdpLanComPort();
        }

        mIpTxt.setText(String.valueOf(ip));
        mPortTxt.setText(String.valueOf(port));

        return view;
    }

    private int strToInt(String s) {

        if ("".equals(s)) {
            Toast.makeText(getContext(), "please input", Toast.LENGTH_SHORT).show();
            return -1;
        }

        try {

            int i = Integer.parseInt(s);

            if (i > 255) {
                Toast.makeText(getContext(), "input must less than 255", Toast.LENGTH_SHORT).show();
                return -1;
            }

            if (i < 0) {
                Toast.makeText(getContext(), "input must more than 0", Toast.LENGTH_SHORT).show();
                return -1;
            }

            return i;
        } catch (Exception e) {
            Toast.makeText(getContext(), "please input number", Toast.LENGTH_SHORT).show();
            return -1;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Tlog.v(TAG, " TmpFunctionFragment onCreateView() ");
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }


    @Override
    public void onDestroyView() {
        Tlog.v(TAG, " TmpFunctionFragment onDestroyView() ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Tlog.v(TAG, " TmpFunctionFragment onDestroy() ");
    }

    public void flashModel(boolean on) {
        if (mStateTxt != null) {
            mStateTxt.setText(on ? "on" : "off");
        }
    }

    public void receiveProtocolAnalysisResult(byte[] protocolParams) {
        String s = null;
        if (protocolParams != null) {
            s = new String(protocolParams);
        }
        Toast.makeText(getContext(), "Test success " + s, Toast.LENGTH_SHORT).show();
    }

}
