package com.farameo.acuario;


import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class FGBluetooh extends Fragment {
    int REQUEST_ENABLE_BT = 1;

    private Button btnBluetooth;
    private BluetoothAdapter bluetoothAdapter;


    public FGBluetooh() {
        // Required empty public constructor
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK){
            Toast.makeText(getContext(), "uno", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getContext(), "NO CERO", Toast.LENGTH_SHORT).show();
        }
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

        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLE_BT);
            }
        });


        return view;
    }
    

}
