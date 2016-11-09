package pub.devrel.easypermissions.sample;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import java.util.List;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * base fragment for using permission request in compatible mode
 */
public class BaseFragment extends Fragment implements EasyPermissions.PermissionCallbacks {
    protected final String TAG = getClass().getSimpleName();

    /*********************************
     * CONFIGURE PERMISSIONS REQUEST *
     *********************************/

    public boolean hasPermissions(@NonNull String... perms) {
        return EasyPermissions.hasPermissions(getContext(), perms);
    }

    public void requestPermissions(@NonNull String rationale,
                                   final int requestCode, @NonNull final String... perms) {
        // Request one permission
        EasyPermissions.requestPermissions(this, rationale,
                requestCode, perms);
    }

    @Override
    public final void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());
    }
}
