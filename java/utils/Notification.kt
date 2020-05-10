import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.toast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(msg: Int) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.longToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
}

fun Fragment.longToast(msg: Int) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.toast(msg: Int) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.longToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.longToast(msg: Int) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun View.snackBar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)
fun View.snackBar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)
fun View.longSnackBar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_LONG)
fun View.longSnackBar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_LONG)
fun View.indefiniteSnackBar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE)
fun View.indefiniteSnackBar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE)