package pub.devrel.easypermissions.sample;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainFragment extends PermissionsFragment implements EasyPermissions.PermissionCallbacks {

    private static final int RC_SMS_PERM = 122;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Create view
        View v = inflater.inflate(R.layout.fragment_main, container);

        // Button click listener
        v.findViewById(R.id.button_sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runSmsTask();
            }
        });

        return v;
    }

    @AfterPermissionGranted(RC_SMS_PERM)
    private void runSmsTask() {
        if (hasPermissions(Manifest.permission.READ_SMS)) {
            // Have permission, do the thing!
            Toast.makeText(getActivity(), "TODO: SMS things", Toast.LENGTH_LONG).show();
        } else {
            // Request one permission
            requestPermissions(getString(R.string.rationale_sms),
                    RC_SMS_PERM, Manifest.permission.READ_SMS);
        }
    }
}
