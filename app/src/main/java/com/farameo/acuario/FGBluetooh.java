package com.farameo.acuario;


import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FGBluetooh extends Fragment {

    private Button btnBluetooth;
    private BluetoothAdapter bluetoothAdapter;


    public FGBluetooh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.fragment_fgbluetooh, container, false);

        btnBluetooth = (Button) view.findViewById(R.id.btnBluetooth);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            btnBluetooth.setEnabled(false);
        } else {
            btnBluetooth.setEnabled(true);
        }

        if (bluetoothAdapter.isEnabled()) {
            btnBluetooth.setText("desactivar");
        } else {
            btnBluetooth.setText("activar");
        }

        return view;
    }
    
    public void ocBlueetooth(View v) {
        Toast.makeText(getActivity(), "asdads", Toast.LENGTH_SHORT).show();
    }

}
